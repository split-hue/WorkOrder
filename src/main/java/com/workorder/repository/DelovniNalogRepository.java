package com.workorder.repository;

import com.workorder.model.DelovniNalogDto;
import com.workorder.model.Evidencaur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Repozitorij za delovne naloge.
 *
 * Vrača DelovniNalogDto (JOIN rezultat), ne JPA entitete.
 * Za write operacije (update status, insert Evidencaur) uporablja JdbcTemplate direktno.
 */
@Repository
public class DelovniNalogRepository {

    private static final String STATUS_PL = "PL";
    private static final String STATUS_VD = "VD";
    private static final String STATUS_ND = "ND";
    private static final String STATUS_KO = "KO";
    private static final String STATUS_TG = "TG";

    private final JdbcTemplate jdbc;

    public DelovniNalogRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Vrne filtrirane naloge za grid (JOIN query).
     *
     * @param dc šifra delovnega centra (Integer)
     */
    public List<DelovniNalogDto> findAktivneNaloge(Integer dc) {
        String sql = """
            WITH FiltriraniZapisi AS (
                SELECT
                    PDA.PDnStZapisa,
                    PDA.PDnStDelNaloga,
                    PDA.PDnStatus,
                    PDA.PDnSifDelCentra,
                    PDA.PDnSifMp,
                    PDA.PDnInfZapStDp,
                    PDA.PDnStZapDelNaloga,
                    PDA.PDnNazivDp,
                    DNP.DNpKolZaIzdelavo,
                    DNP.DNpPlanDatZak,
                    DNP.DNpSifVrsteDN,
                    MP.MpDoNaziv,
                    MP.mprisbafname,
                    MP.MpOpomba,
                    MP.Mpkolpakiranmp,
                    LAG(PDA.PDnStatus) OVER (
                        PARTITION BY PDA.PDnStDelNaloga
                        ORDER BY PDA.PDnInfZapStDp
                    ) AS PrevStatus,
                    LEAD(PDA.PDnNazivDp) OVER (
                        PARTITION BY PDA.PDnStDelNaloga
                        ORDER BY PDA.PDnInfZapStDp
                    ) AS NextPDnNazivDp
                FROM Potekdelovneganaloga PDA
                INNER JOIN Delnalogproizvodni DNP
                    ON DNP.DnpStevilka = PDA.PDnStDelNaloga
                INNER JOIN Maticnipodatki MP
                    ON MP.mpsifra = PDA.PDnSifMp
                WHERE DNP.DnpSifStat = 'LA'
                  AND DNP.DnpSifStroskMesta = '2'
                  AND DNP.DnpStPos IN ('0', '1')
            ),
            ZAgregati AS (
                SELECT
                    F.*,
                    ISNULL(SUM(CAST(EU.EuKolDobrih AS FLOAT)), 0)           AS SumEuKolDobrih,
                    ISNULL(SUM(CAST(EU.EuKolIzmeta AS FLOAT)), 0)            AS SumEuKolIzmeta,
                    ISNULL(SUM(TRY_CAST(EU.EuCustom1 AS FLOAT)), 0)          AS SumEuCustom1,
                    ISNULL(SUM(TRY_CAST(EU.EuCustom2 AS FLOAT)), 0)          AS SumEuCustom2
                FROM FiltriraniZapisi F
                LEFT JOIN Evidencaur EU
                    ON EU.EuStZapPotekaDN = F.PDnStZapisa
                GROUP BY
                    F.PDnStZapisa, F.PDnStDelNaloga, F.PDnStatus,
                    F.PDnSifDelCentra, F.PDnSifMp, F.PDnInfZapStDp,
                    F.PDnStZapDelNaloga, F.PDnNazivDp,
                    F.DNpKolZaIzdelavo, F.DNpPlanDatZak, F.DNpSifVrsteDN,
                    F.MpDoNaziv, F.mprisbafname, F.MpOpomba, F.Mpkolpakiranmp,
                    F.PrevStatus, F.NextPDnNazivDp
            )
            SELECT *
            FROM ZAgregati
            WHERE PDnSifDelCentra = ?
              AND (PrevStatus IN (?, ?, ?) OR PrevStatus IS NULL)
              AND PDnStatus IN (?, ?, ?)
            ORDER BY DNpPlanDatZak
            """;

        return jdbc.query(
                sql,
                new DtoRowMapper(),
                dc,
                STATUS_KO, STATUS_VD, STATUS_ND,
                STATUS_VD, STATUS_PL, STATUS_ND
        );
    }

    /**
     * Posodobi status naloga
     */
    public void updateStatus(Integer pdnStZapisa, String novStatus) {
        jdbc.update(
                "UPDATE Potekdelovneganaloga SET PDnStatus = ? WHERE PDnStZapisa = ?",
                novStatus, pdnStZapisa
        );
    }

    public boolean updateStatusIfNot(Integer pdnStZapisa, String novStatus, String preprecanStatus) {
        int affected = jdbc.update(
                "UPDATE Potekdelovneganaloga SET PDnStatus = ? " +
                        "WHERE PDnStZapisa = ? AND PDnStatus != ?",
                novStatus, pdnStZapisa, preprecanStatus
        );
        return affected > 0; // false = nekdo drug je bil prej
    }

    /**
     * Vstavi nov Evidencaur zapis
     */
    public void insertEvidencaur(Evidencaur eu) {
        String sql = """
        INSERT INTO Evidencaur (
            EuStZapisa,
            EuStZapPotekaDN, EuStDelNaloga, EuStZapDelNaloga,
            EuKolDobrih, EuKolIzmeta,
            EuCustom1, EuCustom2, EuCustom4, EuCustom6,
            NameOper, Datum, EuDatum,
            EuSifDeVnos, EuSifDe, EuSifVrUre,
            EuStTock, EuStUr, EuFaktor,
            EuTipDela, EuTip, EuStevDel,
            EuRaz_StrDel, EuKvaliteta,
            EuSifStroskMesta, EuDeSifStat,
            EuFaktor2, EuFaktor3,
            EuSifVrDok, EuPovzrocitelj,
            EuZadnjaOp, EuVrstaIzm, EuSifDelCentra,
            EuStZapOperacije, EuOpomba
        )
        SELECT
            ISNULL(MAX(EuStZapisa), 0) + 1,
            ?, ?, ?,
            ?, ?,
            ?, ?, ?, ?,
            ?, ?, ?,
            ?, ?, ?,
            ?, ?, ?,
            ?, ?, ?,
            ?, ?,
            ?, ?,
            ?, ?,
            ?, ?,
            ?, ?, ?,
            ?, ?
        FROM Evidencaur
        WITH (TABLOCKX)
        """;

        jdbc.update(sql,
                eu.getEuStZapPotekaDN(), eu.getEuStDelNaloga(), eu.getEuStZapDelNaloga(),
                eu.getEuKolDobrih(), eu.getEuKolIzmeta(),
                eu.getEuCustom1(), eu.getEuCustom2(), eu.getEuCustom4(), eu.getEuCustom6(),
                eu.getNameOper(), eu.getDatum(), eu.getEuDatum(),
                eu.getEuSifDeVnos(), eu.getEuSifDe(), eu.getEuSifVrUre(),
                eu.getEuStTock(), eu.getEuStUr(), eu.getEuFaktor(),
                eu.getEuTipDela(), eu.getEuTip(), eu.getEuStevDel(),
                eu.getEuRaz_StrDel(), eu.getEuKvaliteta(),
                eu.getEuSifStroskMesta(), eu.getEuDeSifStat(),
                eu.getEuFaktor2(), eu.getEuFaktor3(),
                eu.getEuSifVrDok(), eu.getEuPovzrocitelj(),
                eu.getEuZadnjaOp(), eu.getEuVrstaIzm(), eu.getEuSifDelCentra(),
                eu.getEuStZapOperacije(), eu.getEuOpomba()
        );
    }

    //-----RowMapper za DTO-----------------------------------------------------------
    private static class DtoRowMapper implements RowMapper<DelovniNalogDto> {
        @Override
        public DelovniNalogDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            DelovniNalogDto d = new DelovniNalogDto();

            d.setPdnStZapisa(rs.getInt("PDnStZapisa"));
            d.setPdnStDelNaloga(rs.getInt("PDnStDelNaloga"));
            d.setPdnStZapDelNaloga(rs.getInt("PDnStZapDelNaloga"));
            d.setPdnStatus(rs.getString("PDnStatus"));
            d.setPdnSifDelCentra(rs.getInt("PDnSifDelCentra"));
            d.setPdnSifMp(rs.getInt("PDnSifMp"));
            d.setPdnInfZapStDp(rs.getInt("PDnInfZapStDp"));
            d.setPdnNazivDp(rs.getString("PDnNazivDp"));

            d.setDnpKolZaIzdelavo(rs.getDouble("DNpKolZaIzdelavo"));
            d.setDnpPlanDatZak(rs.getString("DNpPlanDatZak"));
            d.setDnpSifVrsteDN(rs.getString("DNpSifVrsteDN"));

            d.setMpNaziv(rs.getString("MpDoNaziv"));
            d.setMpRisbaFname(rs.getString("mprisbafname"));
            d.setMpOpomba(rs.getString("MpOpomba"));
            d.setMpKolPakiranMp(rs.getDouble("Mpkolpakiranmp"));

            d.setNextPdnNazivDp(rs.getString("NextPDnNazivDp"));

            // PrevStatus je lahko NULL (LAG pri prvi vrstici)
            String prevStatus = rs.getString("PrevStatus");
            d.setPrevStatus(prevStatus);

            d.setSumEuKolDobrih(rs.getDouble("SumEuKolDobrih"));
            d.setSumEuKolIzmeta(rs.getDouble("SumEuKolIzmeta"));
            d.setSumEuCustom1(rs.getDouble("SumEuCustom1"));
            d.setSumEuCustom2(rs.getDouble("SumEuCustom2"));

            return d;
        }
    }

    //record/DTO za izpis možnih napak
    public record Napaka(Integer sifra, String naziv) {}

    public List<Napaka> getNapake() {
        return jdbc.query(
                "SELECT NapSifra, NapNaziv FROM Napaka ORDER BY NapSifra",
                (rs, rowNum) -> new Napaka(rs.getInt("NapSifra"), rs.getString("NapNaziv"))
        );
    }
}
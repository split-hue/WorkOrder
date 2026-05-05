package com.workorder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA entiteta za tabelo Potekdelovneganaloga.
 */
@Entity
@Table(name = "Potekdelovneganaloga")
public class PotekDelovnegaNaloga {

    @Id
    @Column(name = "PDnStZapisa")
    private Integer pDnStZapisa;
    public Integer getPDnStZapisa() { return pDnStZapisa; }
    public void setPDnStZapisa(Integer v) { this.pDnStZapisa = v; }

    @Column(name = "NameOper")
    private String nameOper;
    public String getNameOper() { return nameOper; }
    public void setNameOper(String v) { this.nameOper = v; }

    @Column(name = "Datum")
    private java.time.LocalDateTime datum;
    public java.time.LocalDateTime getDatum() { return datum; }
    public void setDatum(java.time.LocalDateTime v) { this.datum = v; }

    @Column(name = "PDnStZapDelNaloga")
    private Integer pDnStZapDelNaloga;
    public Integer getPDnStZapDelNaloga() { return pDnStZapDelNaloga; }
    public void setPDnStZapDelNaloga(Integer v) { this.pDnStZapDelNaloga = v; }

    @Column(name = "PDnStDelNaloga")
    private Integer pDnStDelNaloga;
    public Integer getPDnStDelNaloga() { return pDnStDelNaloga; }
    public void setPDnStDelNaloga(Integer v) { this.pDnStDelNaloga = v; }

    @Column(name = "PDnStPosDelNaloga")
    private Integer pDnStPosDelNaloga;
    public Integer getPDnStPosDelNaloga() { return pDnStPosDelNaloga; }
    public void setPDnStPosDelNaloga(Integer v) { this.pDnStPosDelNaloga = v; }

    @Column(name = "PDnInfZapStDp")
    private Integer pDnInfZapStDp;
    public Integer getPDnInfZapStDp() { return pDnInfZapStDp; }
    public void setPDnInfZapStDp(Integer v) { this.pDnInfZapStDp = v; }

    @Column(name = "PDnNazivDp")
    private String pDnNazivDp;
    public String getPDnNazivDp() { return pDnNazivDp; }
    public void setPDnNazivDp(String v) { this.pDnNazivDp = v; }

    @Column(name = "PDnSkupinaDp")
    private Integer pDnSkupinaDp;
    public Integer getPDnSkupinaDp() { return pDnSkupinaDp; }
    public void setPDnSkupinaDp(Integer v) { this.pDnSkupinaDp = v; }

    @Column(name = "PDnPozObdelDp")
    private Integer pDnPozObdelDp;
    public Integer getPDnPozObdelDp() { return pDnPozObdelDp; }
    public void setPDnPozObdelDp(Integer v) { this.pDnPozObdelDp = v; }

    @Column(name = "PDnSifStandardPos")
    private Integer pDnSifStandardPos;
    public Integer getPDnSifStandardPos() { return pDnSifStandardPos; }
    public void setPDnSifStandardPos(Integer v) { this.pDnSifStandardPos = v; }

    @Column(name = "PDnSifDelCentra")
    private Integer pDnSifDelCentra;
    public Integer getPDnSifDelCentra() { return pDnSifDelCentra; }
    public void setPDnSifDelCentra(Integer v) { this.pDnSifDelCentra = v; }

    @Column(name = "PDnSifStZahP")
    private Integer pDnSifStZahP;
    public Integer getPDnSifStZahP() { return pDnSifStZahP; }
    public void setPDnSifStZahP(Integer v) { this.pDnSifStZahP = v; }

    @Column(name = "PDnSifDp")
    private Integer pDnSifDp;
    public Integer getPDnSifDp() { return pDnSifDp; }
    public void setPDnSifDp(Integer v) { this.pDnSifDp = v; }

    @Column(name = "PDnPlCasNastavitve")
    private Double pDnPlCasNastavitve;
    public Double getPDnPlCasNastavitve() { return pDnPlCasNastavitve; }
    public void setPDnPlCasNastavitve(Double v) { this.pDnPlCasNastavitve = v; }

    @Column(name = "PDnPlCasDela")
    private Double pDnPlCasDela;
    public Double getPDnPlCasDela() { return pDnPlCasDela; }
    public void setPDnPlCasDela(Double v) { this.pDnPlCasDela = v; }

    @Column(name = "PDnPlDatZacetka")
    private java.time.LocalDateTime pDnPlDatZacetka;
    public java.time.LocalDateTime getPDnPlDatZacetka() { return pDnPlDatZacetka; }
    public void setPDnPlDatZacetka(java.time.LocalDateTime v) { this.pDnPlDatZacetka = v; }

    @Column(name = "PDnPlUraZacetka")
    private java.time.LocalDateTime pDnPlUraZacetka;
    public java.time.LocalDateTime getPDnPlUraZacetka() { return pDnPlUraZacetka; }
    public void setPDnPlUraZacetka(java.time.LocalDateTime v) { this.pDnPlUraZacetka = v; }

    @Column(name = "PDnPlDatZakljucka")
    private java.time.LocalDateTime pDnPlDatZakljucka;
    public java.time.LocalDateTime getPDnPlDatZakljucka() { return pDnPlDatZakljucka; }
    public void setPDnPlDatZakljucka(java.time.LocalDateTime v) { this.pDnPlDatZakljucka = v; }

    @Column(name = "PDnPlUraZakljucka")
    private java.time.LocalDateTime pDnPlUraZakljucka;
    public java.time.LocalDateTime getPDnPlUraZakljucka() { return pDnPlUraZakljucka; }
    public void setPDnPlUraZakljucka(java.time.LocalDateTime v) { this.pDnPlUraZakljucka = v; }

    @Column(name = "PDnCasNastavitve")
    private Double pDnCasNastavitve;
    public Double getPDnCasNastavitve() { return pDnCasNastavitve; }
    public void setPDnCasNastavitve(Double v) { this.pDnCasNastavitve = v; }

    @Column(name = "PDnCasDela")
    private Double pDnCasDela;
    public Double getPDnCasDela() { return pDnCasDela; }
    public void setPDnCasDela(Double v) { this.pDnCasDela = v; }

    @Column(name = "PDnDatZacetka")
    private java.time.LocalDateTime pDnDatZacetka;
    public java.time.LocalDateTime getPDnDatZacetka() { return pDnDatZacetka; }
    public void setPDnDatZacetka(java.time.LocalDateTime v) { this.pDnDatZacetka = v; }

    @Column(name = "PDnUraZacetka")
    private java.time.LocalDateTime pDnUraZacetka;
    public java.time.LocalDateTime getPDnUraZacetka() { return pDnUraZacetka; }
    public void setPDnUraZacetka(java.time.LocalDateTime v) { this.pDnUraZacetka = v; }

    @Column(name = "PDnDatZakljucka")
    private java.time.LocalDateTime pDnDatZakljucka;
    public java.time.LocalDateTime getPDnDatZakljucka() { return pDnDatZakljucka; }
    public void setPDnDatZakljucka(java.time.LocalDateTime v) { this.pDnDatZakljucka = v; }

    @Column(name = "PDnUraZakljucka")
    private java.time.LocalDateTime pDnUraZakljucka;
    public java.time.LocalDateTime getPDnUraZakljucka() { return pDnUraZakljucka; }
    public void setPDnUraZakljucka(java.time.LocalDateTime v) { this.pDnUraZakljucka = v; }

    @Column(name = "PDnDatKontrole")
    private java.time.LocalDateTime pDnDatKontrole;
    public java.time.LocalDateTime getPDnDatKontrole() { return pDnDatKontrole; }
    public void setPDnDatKontrole(java.time.LocalDateTime v) { this.pDnDatKontrole = v; }

    @Column(name = "PDnSifMp")
    private Integer pDnSifMp;
    public Integer getPDnSifMp() { return pDnSifMp; }
    public void setPDnSifMp(Integer v) { this.pDnSifMp = v; }

    @Column(name = "PDnSifDelavca")
    private Integer pDnSifDelavca;
    public Integer getPDnSifDelavca() { return pDnSifDelavca; }
    public void setPDnSifDelavca(Integer v) { this.pDnSifDelavca = v; }

    @Column(name = "PDnKolDobrih")
    private Integer pDnKolDobrih;
    public Integer getPDnKolDobrih() { return pDnKolDobrih; }
    public void setPDnKolDobrih(Integer v) { this.pDnKolDobrih = v; }

    @Column(name = "PDnKolIzmeta")
    private Integer pDnKolIzmeta;
    public Integer getPDnKolIzmeta() { return pDnKolIzmeta; }
    public void setPDnKolIzmeta(Integer v) { this.pDnKolIzmeta = v; }

    /**
     * POPRAVEK: String, ne Integer!
     * Vrednosti v bazi: 'PL', 'VD', 'ND', 'KO', 'TG'
     */
    @Column(name = "PDnStatus")
    private String pDnStatus;
    public String getPDnStatus() { return pDnStatus; }
    public void setPDnStatus(String v) { this.pDnStatus = v; }

    @Column(name = "PDnOpomba")
    private String pDnOpomba;
    public String getPDnOpomba() { return pDnOpomba; }
    public void setPDnOpomba(String v) { this.pDnOpomba = v; }

    @Column(name = "PDnPlDatZacetkaZ")
    private java.time.LocalDateTime pDnPlDatZacetkaZ;
    public java.time.LocalDateTime getPDnPlDatZacetkaZ() { return pDnPlDatZacetkaZ; }
    public void setPDnPlDatZacetkaZ(java.time.LocalDateTime v) { this.pDnPlDatZacetkaZ = v; }

    @Column(name = "PDnPlDatZakljuckaZ")
    private java.time.LocalDateTime pDnPlDatZakljuckaZ;
    public java.time.LocalDateTime getPDnPlDatZakljuckaZ() { return pDnPlDatZakljuckaZ; }
    public void setPDnPlDatZakljuckaZ(java.time.LocalDateTime v) { this.pDnPlDatZakljuckaZ = v; }

    @Column(name = "PDnObvSpr")
    private Integer pDnObvSpr;
    public Integer getPDnObvSpr() { return pDnObvSpr; }
    public void setPDnObvSpr(Integer v) { this.pDnObvSpr = v; }

    @Column(name = "PDnPrioritetaSpr")
    private Integer pDnPrioritetaSpr;
    public Integer getPDnPrioritetaSpr() { return pDnPrioritetaSpr; }
    public void setPDnPrioritetaSpr(Integer v) { this.pDnPrioritetaSpr = v; }

    @Column(name = "PDnPlMesecKon")
    private Integer pDnPlMesecKon;
    public Integer getPDnPlMesecKon() { return pDnPlMesecKon; }
    public void setPDnPlMesecKon(Integer v) { this.pDnPlMesecKon = v; }

    @Column(name = "PDnPlCasDelaDel")
    private Double pDnPlCasDelaDel;
    public Double getPDnPlCasDelaDel() { return pDnPlCasDelaDel; }
    public void setPDnPlCasDelaDel(Double v) { this.pDnPlCasDelaDel = v; }

    @Column(name = "PDnStPosDelNalPod")
    private Integer pDnStPosDelNalPod;
    public Integer getPDnStPosDelNalPod() { return pDnStPosDelNalPod; }
    public void setPDnStPosDelNalPod(Integer v) { this.pDnStPosDelNalPod = v; }

    @Column(name = "PDnTipTerm")
    private Integer pDnTipTerm;
    public Integer getPDnTipTerm() { return pDnTipTerm; }
    public void setPDnTipTerm(Integer v) { this.pDnTipTerm = v; }

    @Column(name = "PDnTermEnota")
    private Integer pDnTermEnota;
    public Integer getPDnTermEnota() { return pDnTermEnota; }
    public void setPDnTermEnota(Integer v) { this.pDnTermEnota = v; }

    @Column(name = "PDnZapStvTerm")
    private Integer pDnZapStvTerm;
    public Integer getPDnZapStvTerm() { return pDnZapStvTerm; }
    public void setPDnZapStvTerm(Integer v) { this.pDnZapStvTerm = v; }

    @Column(name = "PDnExtPrior")
    private Integer pDnExtPrior;
    public Integer getPDnExtPrior() { return pDnExtPrior; }
    public void setPDnExtPrior(Integer v) { this.pDnExtPrior = v; }

    @Column(name = "PDnIntPrior")
    private Integer pDnIntPrior;
    public Integer getPDnIntPrior() { return pDnIntPrior; }
    public void setPDnIntPrior(Integer v) { this.pDnIntPrior = v; }

    @Column(name = "PDnPlTrmZacDD")
    private java.time.LocalDateTime pDnPlTrmZacDD;
    public java.time.LocalDateTime getPDnPlTrmZacDD() { return pDnPlTrmZacDD; }
    public void setPDnPlTrmZacDD(java.time.LocalDateTime v) { this.pDnPlTrmZacDD = v; }

    @Column(name = "PDnPlTrmKonDD")
    private java.time.LocalDateTime pDnPlTrmKonDD;
    public java.time.LocalDateTime getPDnPlTrmKonDD() { return pDnPlTrmKonDD; }
    public void setPDnPlTrmKonDD(java.time.LocalDateTime v) { this.pDnPlTrmKonDD = v; }

    @Column(name = "PDnNepNaslOper")
    private Integer pDnNepNaslOper;
    public Integer getPDnNepNaslOper() { return pDnNepNaslOper; }
    public void setPDnNepNaslOper(Integer v) { this.pDnNepNaslOper = v; }

    @Column(name = "PDnPlCasObd")
    private Double pDnPlCasObd;
    public Double getPDnPlCasObd() { return pDnPlCasObd; }
    public void setPDnPlCasObd(Double v) { this.pDnPlCasObd = v; }

    @Column(name = "PDnPlCasMz")
    private Double pDnPlCasMz;
    public Double getPDnPlCasMz() { return pDnPlCasMz; }
    public void setPDnPlCasMz(Double v) { this.pDnPlCasMz = v; }

    @Column(name = "PDnPopMz")
    private Double pDnPopMz;
    public Double getPDnPopMz() { return pDnPopMz; }
    public void setPDnPopMz(Double v) { this.pDnPopMz = v; }

    @Column(name = "PDnNacPo")
    private Integer pDnNacPo;
    public Integer getPDnNacPo() { return pDnNacPo; }
    public void setPDnNacPo(Integer v) { this.pDnNacPo = v; }

    @Column(name = "PDnPlCasPo")
    private Double pDnPlCasPo;
    public Double getPDnPlCasPo() { return pDnPlCasPo; }
    public void setPDnPlCasPo(Double v) { this.pDnPlCasPo = v; }

    @Column(name = "PDnStvPredOper")
    private Integer pDnStvPredOper;
    public Integer getPDnStvPredOper() { return pDnStvPredOper; }
    public void setPDnStvPredOper(Integer v) { this.pDnStvPredOper = v; }

    @Column(name = "PDnPlTrmZacZ")
    private java.time.LocalDateTime pDnPlTrmZacZ;
    public java.time.LocalDateTime getPDnPlTrmZacZ() { return pDnPlTrmZacZ; }
    public void setPDnPlTrmZacZ(java.time.LocalDateTime v) { this.pDnPlTrmZacZ = v; }

    @Column(name = "PDnPlTrmKonZ")
    private java.time.LocalDateTime pDnPlTrmKonZ;
    public java.time.LocalDateTime getPDnPlTrmKonZ() { return pDnPlTrmKonZ; }
    public void setPDnPlTrmKonZ(java.time.LocalDateTime v) { this.pDnPlTrmKonZ = v; }

    @Column(name = "PDnZapStOpDcZ")
    private Integer pDnZapStOpDcZ;
    public Integer getPDnZapStOpDcZ() { return pDnZapStOpDcZ; }
    public void setPDnZapStOpDcZ(Integer v) { this.pDnZapStOpDcZ = v; }

    @Column(name = "PDnNepPredOper")
    private Integer pDnNepPredOper;
    public Integer getPDnNepPredOper() { return pDnNepPredOper; }
    public void setPDnNepPredOper(Integer v) { this.pDnNepPredOper = v; }

    @Column(name = "PDnStvNaslOper")
    private Integer pDnStvNaslOper;
    public Integer getPDnStvNaslOper() { return pDnStvNaslOper; }
    public void setPDnStvNaslOper(Integer v) { this.pDnStvNaslOper = v; }

    @Column(name = "PDnPlTrmZacK")
    private java.time.LocalDateTime pDnPlTrmZacK;
    public java.time.LocalDateTime getPDnPlTrmZacK() { return pDnPlTrmZacK; }
    public void setPDnPlTrmZacK(java.time.LocalDateTime v) { this.pDnPlTrmZacK = v; }

    @Column(name = "PDnPlTrmKonK")
    private java.time.LocalDateTime pDnPlTrmKonK;
    public java.time.LocalDateTime getPDnPlTrmKonK() { return pDnPlTrmKonK; }
    public void setPDnPlTrmKonK(java.time.LocalDateTime v) { this.pDnPlTrmKonK = v; }

    @Column(name = "PDnPomicnost")
    private Integer pDnPomicnost;
    public Integer getPDnPomicnost() { return pDnPomicnost; }
    public void setPDnPomicnost(Integer v) { this.pDnPomicnost = v; }

    @Column(name = "PDnZapStOpDcK")
    private Integer pDnZapStOpDcK;
    public Integer getPDnZapStOpDcK() { return pDnZapStOpDcK; }
    public void setPDnZapStOpDcK(Integer v) { this.pDnZapStOpDcK = v; }

    @Column(name = "PDnStvPrerOper")
    private Integer pDnStvPrerOper;
    public Integer getPDnStvPrerOper() { return pDnStvPrerOper; }
    public void setPDnStvPrerOper(Integer v) { this.pDnStvPrerOper = v; }

    @Column(name = "PDnStatPlan")
    private Integer pDnStatPlan;
    public Integer getPDnStatPlan() { return pDnStatPlan; }
    public void setPDnStatPlan(Integer v) { this.pDnStatPlan = v; }

    @Column(name = "PDnStvStrojev")
    private Integer pDnStvStrojev;
    public Integer getPDnStvStrojev() { return pDnStvStrojev; }
    public void setPDnStvStrojev(Integer v) { this.pDnStvStrojev = v; }

    @Column(name = "PDnVuSifra")
    private String pDnVuSifra;
    public String getPDnVuSifra() { return pDnVuSifra; }
    public void setPDnVuSifra(String v) { this.pDnVuSifra = v; }

    @Column(name = "PDnStrojDC")
    private String pDnStrojDC;
    public String getPDnStrojDC() { return pDnStrojDC; }
    public void setPDnStrojDC(String v) { this.pDnStrojDC = v; }

    @Column(name = "PDnTeh")
    private String pDnTeh;
    public String getPDnTeh() { return pDnTeh; }
    public void setPDnTeh(String v) { this.pDnTeh = v; }

    @Column(name = "PDnVarianta")
    private String pDnVarianta;
    public String getPDnVarianta() { return pDnVarianta; }
    public void setPDnVarianta(String v) { this.pDnVarianta = v; }

    @Column(name = "PDnOzAlter")
    private String pDnOzAlter;
    public String getPDnOzAlter() { return pDnOzAlter; }
    public void setPDnOzAlter(String v) { this.pDnOzAlter = v; }

    @Column(name = "PDnStatDelo")
    private Integer pDnStatDelo;
    public Integer getPDnStatDelo() { return pDnStatDelo; }
    public void setPDnStatDelo(Integer v) { this.pDnStatDelo = v; }
}
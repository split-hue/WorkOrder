package com.workorder.service;

import com.workorder.model.DelovniNalogDto;
import com.workorder.model.Evidencaur;
import com.workorder.repository.DelovniNalogRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DelovniNalogService {

    private final DelovniNalogRepository repo;

    @Value("${app.dc:20}")
    private Integer dc;

    public DelovniNalogService(DelovniNalogRepository repo) {
        this.repo = repo;
    }

    public List<DelovniNalogDto> getNalogi() {
        return repo.findAktivneNaloge(dc);
    }

    /**
     * ZAČETEK: nastavi status VD, vstavi Evidencaur
     */
    @Transactional
    public void zacniNalog(DelovniNalogDto nalog, String operater) {
        boolean uspelo = repo.updateStatusIfNot(nalog.getPdnStZapisa(), "VD", "VD");
        if (!uspelo) {
            throw new IllegalStateException("Nalog je že v delu >> drug delavec je bil hitrejši.");
        }

        Evidencaur eu = novaEvidencaur(nalog, operater);
        eu.setEuKolDobrih(0);
        eu.setEuKolIzmeta(0);
        eu.setEuCustom1(null);
        eu.setEuCustom2(null);
        eu.setEuZadnjaOp(0);

        repo.insertEvidencaur(eu);
    }

    /**
     * KONEC: izračuna status (KO/ND), vpiše panele, vstavi Evidencaur
     */
    @Transactional
    public void zakljuciNalog(DelovniNalogDto nalog, int steviloPanelov, String operater) {
        //double pakirano   = safe(nalog.getMpKolPakiranMp(), 1.0);
        double pankos = steviloPanelov;
        double sumDobrih  = safe(nalog.getSumEuKolDobrih(), 0.0);
        //double sumCustom1 = safe(nalog.getSumEuCustom1(), 0.0); ne rabmo več k se kle ne štejejo paneli, sam raw kosi
        double zaIzdelavo = safe(nalog.getDnpKolZaIzdelavo(), 0.0);

        double novSkupajKosi    = sumDobrih + pankos;
        //int    novSkupajPanelov = (int)(sumCustom1 + steviloPanelov);

        boolean zakljucen = novSkupajKosi >= zaIzdelavo;
        String novStatus = zakljucen ? "KO" : "ND";
        int zadnjaOp  = zakljucen ? 1 : 0;

        repo.updateStatus(nalog.getPdnStZapisa(), novStatus);

        Evidencaur eu = novaEvidencaur(nalog, operater);
        eu.setEuKolDobrih((int) pankos);
        eu.setEuKolIzmeta(0);
        eu.setEuCustom1(null); //String.valueOf(novSkupajPanelov));
        eu.setEuCustom2(null); //String.valueOf(steviloPanelov));
        eu.setEuZadnjaOp(zadnjaOp);

        repo.insertEvidencaur(eu);
    }

    //-----helpers----------------------------------------------------------------

    private Evidencaur novaEvidencaur(DelovniNalogDto nalog, String operater) {
        Evidencaur eu = new Evidencaur();

        // FK polja
        eu.setEuStZapPotekaDN(nalog.getPdnStZapisa());
        eu.setEuStDelNaloga(nalog.getPdnStDelNaloga());
        eu.setEuStZapDelNaloga(nalog.getPdnStZapDelNaloga());
        eu.setEuSifDelCentra(nalog.getPdnSifDelCentra());

        //operater in čas
        eu.setNameOper(operater);
        eu.setDatum(LocalDateTime.now());
        eu.setEuDatum(LocalDateTime.now());
        eu.setEuCustom4("17");
        eu.setEuCustom6(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        
        eu.setEuSifDeVnos(1);
        eu.setEuSifDe(1);
        eu.setEuSifVrUre(1);
        eu.setEuStTock(0);
        eu.setEuStUr(0);
        eu.setEuFaktor(0.0);
        eu.setEuTipDela(1);
        eu.setEuTip(1);
        eu.setEuStevDel(1);
        eu.setEuRaz_StrDel("1");
        eu.setEuKvaliteta("100");
        eu.setEuSifStroskMesta(2);
        eu.setEuDeSifStat(null);
        eu.setEuFaktor2(1.0);
        eu.setEuFaktor3(1.0);
        eu.setEuSifVrDok(null);
        eu.setEuPovzrocitelj("1");
        eu.setEuVrstaIzm(0);

        return eu;
    }

    private double safe(Double val, double fallback) {
        return (val != null && val > 0) ? val : fallback;
    }
}
package com.workorder.model;

/**
 * DTO (Data Transfer Object) za prikaz v gridu.
 *
 * NI JPA entiteta >> je rezultat native SQL querja ki JOINa
 * Potekdelovneganaloga + Delnalogproizvodni + Maticnipodatki + Evidencaur
 *
 */
public class DelovniNalogDto {

    //>>iz Potekdelovneganaloga
    private Integer pdnStZapisa;
    private Integer pdnStDelNaloga;
    private Integer pdnStZapDelNaloga;
    private String  pdnStatus;           // String! vred.: 'PL','VD','ND','KO','TG'
    private Integer pdnSifDelCentra;
    private Integer pdnSifMp;
    private Integer pdnInfZapStDp;
    private String  pdnNazivDp;

    //>>iz Delnalogproizvodni
    private Double  dnpKolZaIzdelavo;
    private String  dnpPlanDatZak;
    private String  dnpSifVrsteDN;

    //>>iz Maticnipodatki
    private String  mpNaziv;
    private String  mpRisbaFname;
    private String  mpOpomba;
    private Double  mpKolPakiranMp;

    //>>LEAD()
    private String  nextPdnNazivDp;

    //>>LAG() - status prejšnjega zapisa
    private String prevStatus;

    //>>Agregati iz Evidencaur
    private Double  sumEuKolDobrih;
    private Double  sumEuKolIzmeta;
    private Double  sumEuCustom1;
    private Double  sumEuCustom2;

    //----------getterji & setterji-----------------------------------------

    public Integer getPdnStZapisa() { return pdnStZapisa; }
    public void setPdnStZapisa(Integer v) { this.pdnStZapisa = v; }

    public Integer getPdnStDelNaloga() { return pdnStDelNaloga; }
    public void setPdnStDelNaloga(Integer v) { this.pdnStDelNaloga = v; }

    public Integer getPdnStZapDelNaloga() { return pdnStZapDelNaloga; }
    public void setPdnStZapDelNaloga(Integer v) { this.pdnStZapDelNaloga = v; }

    public String getPdnStatus() { return pdnStatus; }
    public void setPdnStatus(String v) { this.pdnStatus = v; }

    public Integer getPdnSifDelCentra() { return pdnSifDelCentra; }
    public void setPdnSifDelCentra(Integer v) { this.pdnSifDelCentra = v; }

    public Integer getPdnSifMp() { return pdnSifMp; }
    public void setPdnSifMp(Integer v) { this.pdnSifMp = v; }

    public Integer getPdnInfZapStDp() { return pdnInfZapStDp; }
    public void setPdnInfZapStDp(Integer v) { this.pdnInfZapStDp = v; }

    public String getPdnNazivDp() { return pdnNazivDp; }
    public void setPdnNazivDp(String v) { this.pdnNazivDp = v; }

    public Double getDnpKolZaIzdelavo() { return dnpKolZaIzdelavo; }
    public void setDnpKolZaIzdelavo(Double v) { this.dnpKolZaIzdelavo = v; }

    public String getDnpPlanDatZak() { return dnpPlanDatZak; }
    public void setDnpPlanDatZak(String v) { this.dnpPlanDatZak = v; }

    public String getDnpSifVrsteDN() { return dnpSifVrsteDN; }
    public void setDnpSifVrsteDN(String v) { this.dnpSifVrsteDN = v; }

    public String getMpNaziv() { return mpNaziv; }
    public void setMpNaziv(String v) { this.mpNaziv = v; }

    public String getMpRisbaFname() { return mpRisbaFname; }
    public void setMpRisbaFname(String v) { this.mpRisbaFname = v; }

    public String getMpOpomba() { return mpOpomba; }
    public void setMpOpomba(String v) { this.mpOpomba = v; }

    public Double getMpKolPakiranMp() { return mpKolPakiranMp; }
    public void setMpKolPakiranMp(Double v) { this.mpKolPakiranMp = v; }

    public String getNextPdnNazivDp() { return nextPdnNazivDp; }
    public void setNextPdnNazivDp(String v) { this.nextPdnNazivDp = v; }

    public String getPrevStatus() { return prevStatus; }
    public void setPrevStatus(String v) { this.prevStatus = v; }

    public Double getSumEuKolDobrih() { return sumEuKolDobrih; }
    public void setSumEuKolDobrih(Double v) { this.sumEuKolDobrih = v; }

    public Double getSumEuKolIzmeta() { return sumEuKolIzmeta; }
    public void setSumEuKolIzmeta(Double v) { this.sumEuKolIzmeta = v; }

    public Double getSumEuCustom1() { return sumEuCustom1; }
    public void setSumEuCustom1(Double v) { this.sumEuCustom1 = v; }

    public Double getSumEuCustom2() { return sumEuCustom2; }
    public void setSumEuCustom2(Double v) { this.sumEuCustom2 = v; }

    //----------helpers--------------------------------------------------------------
    public boolean isVDelu()    { return "VD".equals(pdnStatus); }
    public boolean isPlaniran() { return "PL".equals(pdnStatus); }
    public boolean isKoncano()  { return "KO".equals(pdnStatus); }
    public boolean isNedokoncano() { return "ND".equals(pdnStatus); }
}
 
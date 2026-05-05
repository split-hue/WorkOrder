package com.nalogapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class PotekDelovnegaNaloga {

    private String nameOper;
    @Column(name = "NameOper")
    public String getNameOper() { return nameOper; }
    public void setNameOper(String v) { this.nameOper = v; }

    private java.time.LocalDateTime datum;
    @Column(name = "Datum")
    public java.time.LocalDateTime getDatum() { return datum; }
    public void setDatum(java.time.LocalDateTime v) { this.datum = v; }

    @Id
    @Column(name = "PDnStZapisa")
    private Integer pDnStZapisa;
    public Integer getPDnStZapisa() { return pDnStZapisa; }
    public void setPDnStZapisa(Integer v) { this.pDnStZapisa = v; }

    private Integer pDnStZapDelNaloga;
    @Column(name = "PDnStZapDelNaloga")
    public Integer getPDnStZapDelNaloga() { return pDnStZapDelNaloga; }
    public void setPDnStZapDelNaloga(Integer v) { this.pDnStZapDelNaloga = v; }

    private Integer pDnStDelNaloga;
    @Column(name = "PDnStDelNaloga")
    public Integer getPDnStDelNaloga() { return pDnStDelNaloga; }
    public void setPDnStDelNaloga(Integer v) { this.pDnStDelNaloga = v; }

    private Integer pDnStPosDelNaloga;
    @Column(name = "PDnStPosDelNaloga")
    public Integer getPDnStPosDelNaloga() { return pDnStPosDelNaloga; }
    public void setPDnStPosDelNaloga(Integer v) { this.pDnStPosDelNaloga = v; }

    private Integer pDnInfZapStDp;
    @Column(name = "PDnInfZapStDp")
    public Integer getPDnInfZapStDp() { return pDnInfZapStDp; }
    public void setPDnInfZapStDp(Integer v) { this.pDnInfZapStDp = v; }

    private String pDnNazivDp;
    @Column(name = "PDnNazivDp")
    public String getPDnNazivDp() { return pDnNazivDp; }
    public void setPDnNazivDp(String v) { this.pDnNazivDp = v; }

    private Integer pDnSkupinaDp;
    @Column(name = "PDnSkupinaDp")
    public Integer getPDnSkupinaDp() { return pDnSkupinaDp; }
    public void setPDnSkupinaDp(Integer v) { this.pDnSkupinaDp = v; }

    private Integer pDnPozObdelDp;
    @Column(name = "PDnPozObdelDp")
    public Integer getPDnPozObdelDp() { return pDnPozObdelDp; }
    public void setPDnPozObdelDp(Integer v) { this.pDnPozObdelDp = v; }

    private Integer pDnSifStandardPos;
    @Column(name = "PDnSifStandardPos")
    public Integer getPDnSifStandardPos() { return pDnSifStandardPos; }
    public void setPDnSifStandardPos(Integer v) { this.pDnSifStandardPos = v; }

    private Integer pDnSifDelCentra;
    @Column(name = "PDnSifDelCentra")
    public Integer getPDnSifDelCentra() { return pDnSifDelCentra; }
    public void setPDnSifDelCentra(Integer v) { this.pDnSifDelCentra = v; }

    private Integer pDnSifStZahP;
    @Column(name = "PDnSifStZahP")
    public Integer getPDnSifStZahP() { return pDnSifStZahP; }
    public void setPDnSifStZahP(Integer v) { this.pDnSifStZahP = v; }

    private Integer pDnSifDp;
    @Column(name = "PDnSifDp")
    public Integer getPDnSifDp() { return pDnSifDp; }
    public void setPDnSifDp(Integer v) { this.pDnSifDp = v; }

    private Double pDnPlCasNastavitve;
    @Column(name = "PDnPlCasNastavitve")
    public Double getPDnPlCasNastavitve() { return pDnPlCasNastavitve; }
    public void setPDnPlCasNastavitve(Double v) { this.pDnPlCasNastavitve = v; }

    private Double pDnPlCasDela;
    @Column(name = "PDnPlCasDela")
    public Double getPDnPlCasDela() { return pDnPlCasDela; }
    public void setPDnPlCasDela(Double v) { this.pDnPlCasDela = v; }

    private java.time.LocalDateTime pDnPlDatZacetka;
    @Column(name = "PDnPlDatZacetka")
    public java.time.LocalDateTime getPDnPlDatZacetka() { return pDnPlDatZacetka; }
    public void setPDnPlDatZacetka(java.time.LocalDateTime v) { this.pDnPlDatZacetka = v; }

    private java.time.LocalDateTime pDnPlUraZacetka;
    @Column(name = "PDnPlUraZacetka")
    public java.time.LocalDateTime getPDnPlUraZacetka() { return pDnPlUraZacetka; }
    public void setPDnPlUraZacetka(java.time.LocalDateTime v) { this.pDnPlUraZacetka = v; }

    private java.time.LocalDateTime pDnPlDatZakljucka;
    @Column(name = "PDnPlDatZakljucka")
    public java.time.LocalDateTime getPDnPlDatZakljucka() { return pDnPlDatZakljucka; }
    public void setPDnPlDatZakljucka(java.time.LocalDateTime v) { this.pDnPlDatZakljucka = v; }

    private java.time.LocalDateTime pDnPlUraZakljucka;
    @Column(name = "PDnPlUraZakljucka")
    public java.time.LocalDateTime getPDnPlUraZakljucka() { return pDnPlUraZakljucka; }
    public void setPDnPlUraZakljucka(java.time.LocalDateTime v) { this.pDnPlUraZakljucka = v; }

    private Double pDnCasNastavitve;
    @Column(name = "PDnCasNastavitve")
    public Double getPDnCasNastavitve() { return pDnCasNastavitve; }
    public void setPDnCasNastavitve(Double v) { this.pDnCasNastavitve = v; }

    private Double pDnCasDela;
    @Column(name = "PDnCasDela")
    public Double getPDnCasDela() { return pDnCasDela; }
    public void setPDnCasDela(Double v) { this.pDnCasDela = v; }

    private java.time.LocalDateTime pDnDatZacetka;
    @Column(name = "PDnDatZacetka")
    public java.time.LocalDateTime getPDnDatZacetka() { return pDnDatZacetka; }
    public void setPDnDatZacetka(java.time.LocalDateTime v) { this.pDnDatZacetka = v; }

    private java.time.LocalDateTime pDnUraZacetka;
    @Column(name = "PDnUraZacetka")
    public java.time.LocalDateTime getPDnUraZacetka() { return pDnUraZacetka; }
    public void setPDnUraZacetka(java.time.LocalDateTime v) { this.pDnUraZacetka = v; }

    private java.time.LocalDateTime pDnDatZakljucka;
    @Column(name = "PDnDatZakljucka")
    public java.time.LocalDateTime getPDnDatZakljucka() { return pDnDatZakljucka; }
    public void setPDnDatZakljucka(java.time.LocalDateTime v) { this.pDnDatZakljucka = v; }

    private java.time.LocalDateTime pDnUraZakljucka;
    @Column(name = "PDnUraZakljucka")
    public java.time.LocalDateTime getPDnUraZakljucka() { return pDnUraZakljucka; }
    public void setPDnUraZakljucka(java.time.LocalDateTime v) { this.pDnUraZakljucka = v; }

    private java.time.LocalDateTime pDnDatKontrole;
    @Column(name = "PDnDatKontrole")
    public java.time.LocalDateTime getPDnDatKontrole() { return pDnDatKontrole; }
    public void setPDnDatKontrole(java.time.LocalDateTime v) { this.pDnDatKontrole = v; }

    private Integer pDnSifMp;
    @Column(name = "PDnSifMp")
    public Integer getPDnSifMp() { return pDnSifMp; }
    public void setPDnSifMp(Integer v) { this.pDnSifMp = v; }

    private Integer pDnSifDelavca;
    @Column(name = "PDnSifDelavca")
    public Integer getPDnSifDelavca() { return pDnSifDelavca; }
    public void setPDnSifDelavca(Integer v) { this.pDnSifDelavca = v; }

    private Integer pDnKolDobrih;
    @Column(name = "PDnKolDobrih")
    public Integer getPDnKolDobrih() { return pDnKolDobrih; }
    public void setPDnKolDobrih(Integer v) { this.pDnKolDobrih = v; }

    private Integer pDnKolIzmeta;
    @Column(name = "PDnKolIzmeta")
    public Integer getPDnKolIzmeta() { return pDnKolIzmeta; }
    public void setPDnKolIzmeta(Integer v) { this.pDnKolIzmeta = v; }

    private Integer pDnStatus;
    @Column(name = "PDnStatus")
    public Integer getPDnStatus() { return pDnStatus; }
    public void setPDnStatus(Integer v) { this.pDnStatus = v; }

    private String pDnOpomba;
    @Column(name = "PDnOpomba")
    public String getPDnOpomba() { return pDnOpomba; }
    public void setPDnOpomba(String v) { this.pDnOpomba = v; }

    private java.time.LocalDateTime pDnPlDatZacetkaZ;
    @Column(name = "PDnPlDatZacetkaZ")
    public java.time.LocalDateTime getPDnPlDatZacetkaZ() { return pDnPlDatZacetkaZ; }
    public void setPDnPlDatZacetkaZ(java.time.LocalDateTime v) { this.pDnPlDatZacetkaZ = v; }

    private java.time.LocalDateTime pDnPlDatZakljuckaZ;
    @Column(name = "PDnPlDatZakljuckaZ")
    public java.time.LocalDateTime getPDnPlDatZakljuckaZ() { return pDnPlDatZakljuckaZ; }
    public void setPDnPlDatZakljuckaZ(java.time.LocalDateTime v) { this.pDnPlDatZakljuckaZ = v; }

    private Double pDnSkPrCas;
    @Column(name = "PDnSkPrCas")
    public Double getPDnSkPrCas() { return pDnSkPrCas; }
    public void setPDnSkPrCas(Double v) { this.pDnSkPrCas = v; }

    private Double pDnSkCasDela;
    @Column(name = "PDnSkCasDela")
    public Double getPDnSkCasDela() { return pDnSkCasDela; }
    public void setPDnSkCasDela(Double v) { this.pDnSkCasDela = v; }

    private java.time.LocalDateTime pDnRokNarocila;
    @Column(name = "PDnRokNarocila")
    public java.time.LocalDateTime getPDnRokNarocila() { return pDnRokNarocila; }
    public void setPDnRokNarocila(java.time.LocalDateTime v) { this.pDnRokNarocila = v; }

    private Integer pDnPrioriteta;
    @Column(name = "PDnPrioriteta")
    public Integer getPDnPrioriteta() { return pDnPrioriteta; }
    public void setPDnPrioriteta(Integer v) { this.pDnPrioriteta = v; }

    private Integer pDnRazvrstitev;
    @Column(name = "PDnRazvrstitev")
    public Integer getPDnRazvrstitev() { return pDnRazvrstitev; }
    public void setPDnRazvrstitev(Integer v) { this.pDnRazvrstitev = v; }

    private Integer pDnPlTedenZac;
    @Column(name = "PDnPlTedenZac")
    public Integer getPDnPlTedenZac() { return pDnPlTedenZac; }
    public void setPDnPlTedenZac(Integer v) { this.pDnPlTedenZac = v; }

    private Integer pDnPlTedenKon;
    @Column(name = "PDnPlTedenKon")
    public Integer getPDnPlTedenKon() { return pDnPlTedenKon; }
    public void setPDnPlTedenKon(Integer v) { this.pDnPlTedenKon = v; }

    private Integer pDnPlMesec;
    @Column(name = "PDnPlMesec")
    public Integer getPDnPlMesec() { return pDnPlMesec; }
    public void setPDnPlMesec(Integer v) { this.pDnPlMesec = v; }

    private Integer pDnVrNar;
    @Column(name = "PDnVrNar")
    public Integer getPDnVrNar() { return pDnVrNar; }
    public void setPDnVrNar(Integer v) { this.pDnVrNar = v; }

    private Double pDnSkupKolPDN;
    @Column(name = "PDnSkupKolPDN")
    public Double getPDnSkupKolPDN() { return pDnSkupKolPDN; }
    public void setPDnSkupKolPDN(Double v) { this.pDnSkupKolPDN = v; }

    private String pDnEMKol;
    @Column(name = "PDnEMKol")
    public String getPDnEMKol() { return pDnEMKol; }
    public void setPDnEMKol(String v) { this.pDnEMKol = v; }

    private Double pDnUrPop;
    @Column(name = "PDnurPop")
    public Double getPDnUrPop() { return pDnUrPop; }
    public void setPDnUrPop(Double v) { this.pDnUrPop = v; }

    private Integer pDnStatMat;
    @Column(name = "PDnStatMat")
    public Integer getPDnStatMat() { return pDnStatMat; }
    public void setPDnStatMat(Integer v) { this.pDnStatMat = v; }

    private String pDnSpKrNaziv;
    @Column(name = "PDnSpKrNaziv")
    public String getPDnSpKrNaziv() { return pDnSpKrNaziv; }
    public void setPDnSpKrNaziv(String v) { this.pDnSpKrNaziv = v; }

    private Integer pDnSkuZapST;
    @Column(name = "PDnSkuZapST")
    public Integer getPDnSkuZapST() { return pDnSkuZapST; }
    public void setPDnSkuZapST(Integer v) { this.pDnSkuZapST = v; }

    private Integer pDnStevDel;
    @Column(name = "PDnStevDel")
    public Integer getPDnStevDel() { return pDnStevDel; }
    public void setPDnStevDel(Integer v) { this.pDnStevDel = v; }

    private Double pDnCasDelaDel;
    @Column(name = "PDnCasDelaDel")
    public Double getPDnCasDelaDel() { return pDnCasDelaDel; }
    public void setPDnCasDelaDel(Double v) { this.pDnCasDelaDel = v; }

    private Integer pDnObvSpr;
    @Column(name = "PDnObvSpr")
    public Integer getPDnObvSpr() { return pDnObvSpr; }
    public void setPDnObvSpr(Integer v) { this.pDnObvSpr = v; }

    private Integer pDnPrioritetaSpr;
    @Column(name = "PDnPrioritetaSpr")
    public Integer getPDnPrioritetaSpr() { return pDnPrioritetaSpr; }
    public void setPDnPrioritetaSpr(Integer v) { this.pDnPrioritetaSpr = v; }

    private Integer pDnPlMesecKon;
    @Column(name = "PDnPlMesecKon")
    public Integer getPDnPlMesecKon() { return pDnPlMesecKon; }
    public void setPDnPlMesecKon(Integer v) { this.pDnPlMesecKon = v; }

    private Double pDnPlCasDelaDel;
    @Column(name = "PDnPlCasDelaDel")
    public Double getPDnPlCasDelaDel() { return pDnPlCasDelaDel; }
    public void setPDnPlCasDelaDel(Double v) { this.pDnPlCasDelaDel = v; }

    private Integer pDnStPosDelNalPod;
    @Column(name = "PDnStPosDelNalPod")
    public Integer getPDnStPosDelNalPod() { return pDnStPosDelNalPod; }
    public void setPDnStPosDelNalPod(Integer v) { this.pDnStPosDelNalPod = v; }

    private Integer pDnTipTerm;
    @Column(name = "PDnTipTerm")
    public Integer getPDnTipTerm() { return pDnTipTerm; }
    public void setPDnTipTerm(Integer v) { this.pDnTipTerm = v; }

    private Integer pDnTermEnota;
    @Column(name = "PDnTermEnota")
    public Integer getPDnTermEnota() { return pDnTermEnota; }
    public void setPDnTermEnota(Integer v) { this.pDnTermEnota = v; }

    private Integer pDnZapStvTerm;
    @Column(name = "PDnZapStvTerm")
    public Integer getPDnZapStvTerm() { return pDnZapStvTerm; }
    public void setPDnZapStvTerm(Integer v) { this.pDnZapStvTerm = v; }

    private Integer pDnExtPrior;
    @Column(name = "PDnExtPrior")
    public Integer getPDnExtPrior() { return pDnExtPrior; }
    public void setPDnExtPrior(Integer v) { this.pDnExtPrior = v; }

    private Integer pDnIntPrior;
    @Column(name = "PDnIntPrior")
    public Integer getPDnIntPrior() { return pDnIntPrior; }
    public void setPDnIntPrior(Integer v) { this.pDnIntPrior = v; }

    private java.time.LocalDateTime pDnPlTrmZacDD;
    @Column(name = "PDnPlTrmZacDD")
    public java.time.LocalDateTime getPDnPlTrmZacDD() { return pDnPlTrmZacDD; }
    public void setPDnPlTrmZacDD(java.time.LocalDateTime v) { this.pDnPlTrmZacDD = v; }

    private java.time.LocalDateTime pDnPlTrmKonDD;
    @Column(name = "PDnPlTrmKonDD")
    public java.time.LocalDateTime getPDnPlTrmKonDD() { return pDnPlTrmKonDD; }
    public void setPDnPlTrmKonDD(java.time.LocalDateTime v) { this.pDnPlTrmKonDD = v; }

    private Integer pDnNepNaslOper;
    @Column(name = "PDnNepNaslOper")
    public Integer getPDnNepNaslOper() { return pDnNepNaslOper; }
    public void setPDnNepNaslOper(Integer v) { this.pDnNepNaslOper = v; }

    private Double pDnPlCasObd;
    @Column(name = "PDnPlCasObd")
    public Double getPDnPlCasObd() { return pDnPlCasObd; }
    public void setPDnPlCasObd(Double v) { this.pDnPlCasObd = v; }

    private Double pDnPlCasMz;
    @Column(name = "PDnPlCasMz")
    public Double getPDnPlCasMz() { return pDnPlCasMz; }
    public void setPDnPlCasMz(Double v) { this.pDnPlCasMz = v; }

    private Double pDnPopMz;
    @Column(name = "PDnPopMz")
    public Double getPDnPopMz() { return pDnPopMz; }
    public void setPDnPopMz(Double v) { this.pDnPopMz = v; }

    private Integer pDnNacPo;
    @Column(name = "PDnNacPo")
    public Integer getPDnNacPo() { return pDnNacPo; }
    public void setPDnNacPo(Integer v) { this.pDnNacPo = v; }

    private Double pDnPlCasPo;
    @Column(name = "PDnPlCasPo")
    public Double getPDnPlCasPo() { return pDnPlCasPo; }
    public void setPDnPlCasPo(Double v) { this.pDnPlCasPo = v; }

    private Integer pDnStvPredOper;
    @Column(name = "PDnStvPredOper")
    public Integer getPDnStvPredOper() { return pDnStvPredOper; }
    public void setPDnStvPredOper(Integer v) { this.pDnStvPredOper = v; }

    private java.time.LocalDateTime pDnPlTrmZacZ;
    @Column(name = "PDnPlTrmZacZ")
    public java.time.LocalDateTime getPDnPlTrmZacZ() { return pDnPlTrmZacZ; }
    public void setPDnPlTrmZacZ(java.time.LocalDateTime v) { this.pDnPlTrmZacZ = v; }

    private java.time.LocalDateTime pDnPlTrmKonZ;
    @Column(name = "PDnPlTrmKonZ")
    public java.time.LocalDateTime getPDnPlTrmKonZ() { return pDnPlTrmKonZ; }
    public void setPDnPlTrmKonZ(java.time.LocalDateTime v) { this.pDnPlTrmKonZ = v; }

    private Integer pDnZapStOpDcZ;
    @Column(name = "PDnZapStOpDcZ")
    public Integer getPDnZapStOpDcZ() { return pDnZapStOpDcZ; }
    public void setPDnZapStOpDcZ(Integer v) { this.pDnZapStOpDcZ = v; }

    private Integer pDnNepPredOper;
    @Column(name = "PDnNepPredOper")
    public Integer getPDnNepPredOper() { return pDnNepPredOper; }
    public void setPDnNepPredOper(Integer v) { this.pDnNepPredOper = v; }

    private Integer pDnStvNaslOper;
    @Column(name = "PDnStvNaslOper")
    public Integer getPDnStvNaslOper() { return pDnStvNaslOper; }
    public void setPDnStvNaslOper(Integer v) { this.pDnStvNaslOper = v; }

    private java.time.LocalDateTime pDnPlTrmZacK;
    @Column(name = "PDnPlTrmZacK")
    public java.time.LocalDateTime getPDnPlTrmZacK() { return pDnPlTrmZacK; }
    public void setPDnPlTrmZacK(java.time.LocalDateTime v) { this.pDnPlTrmZacK = v; }

    private java.time.LocalDateTime pDnPlTrmKonK;
    @Column(name = "PDnPlTrmKonK")
    public java.time.LocalDateTime getPDnPlTrmKonK() { return pDnPlTrmKonK; }
    public void setPDnPlTrmKonK(java.time.LocalDateTime v) { this.pDnPlTrmKonK = v; }

    private Integer pDnPomicnost;
    @Column(name = "PDnPomicnost")
    public Integer getPDnPomicnost() { return pDnPomicnost; }
    public void setPDnPomicnost(Integer v) { this.pDnPomicnost = v; }

    private Integer pDnZapStOpDcK;
    @Column(name = "PDnZapStOpDcK")
    public Integer getPDnZapStOpDcK() { return pDnZapStOpDcK; }
    public void setPDnZapStOpDcK(Integer v) { this.pDnZapStOpDcK = v; }

    private Integer pDnStvPrerOper;
    @Column(name = "PDnStvPrerOper")
    public Integer getPDnStvPrerOper() { return pDnStvPrerOper; }
    public void setPDnStvPrerOper(Integer v) { this.pDnStvPrerOper = v; }

    private Integer pDnStatPlan;
    @Column(name = "PDnStatPlan")
    public Integer getPDnStatPlan() { return pDnStatPlan; }
    public void setPDnStatPlan(Integer v) { this.pDnStatPlan = v; }

    private Integer pDnStvStrojev;
    @Column(name = "PDnStvStrojev")
    public Integer getPDnStvStrojev() { return pDnStvStrojev; }
    public void setPDnStvStrojev(Integer v) { this.pDnStvStrojev = v; }

    private String pDnVuSifra;
    @Column(name = "PDnVuSifra")
    public String getPDnVuSifra() { return pDnVuSifra; }
    public void setPDnVuSifra(String v) { this.pDnVuSifra = v; }

    private String pDnStrojDC;
    @Column(name = "PDnStrojDC")
    public String getPDnStrojDC() { return pDnStrojDC; }
    public void setPDnStrojDC(String v) { this.pDnStrojDC = v; }

    private String pDnTeh;
    @Column(name = "PDnTeh")
    public String getPDnTeh() { return pDnTeh; }
    public void setPDnTeh(String v) { this.pDnTeh = v; }

    private String pDnVarianta;
    @Column(name = "PDnVarianta")
    public String getPDnVarianta() { return pDnVarianta; }
    public void setPDnVarianta(String v) { this.pDnVarianta = v; }

    private String pDnOzAlter;
    @Column(name = "PDnOzAlter")
    public String getPDnOzAlter() { return pDnOzAlter; }
    public void setPDnOzAlter(String v) { this.pDnOzAlter = v; }

    private Integer pDnStatDelo;
    @Column(name = "PDnStatDelo")
    public Integer getPDnStatDelo() { return pDnStatDelo; }
    public void setPDnStatDelo(Integer v) { this.pDnStatDelo = v; }
}

package com.workorder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA entiteta za tabelo Evidencaur.
 */
@Entity
@Table(name = "Evidencaur")
public class Evidencaur {

    @Id
    @Column(name = "EuStZapisa")
    private Integer euStZapisa;
    public Integer getEuStZapisa() { return euStZapisa; }
    public void setEuStZapisa(Integer v) { this.euStZapisa = v; }

    @Column(name = "NameOper")
    private String nameOper;
    public String getNameOper() { return nameOper; }
    public void setNameOper(String v) { this.nameOper = v; }

    @Column(name = "Datum")
    private java.time.LocalDateTime datum;
    public java.time.LocalDateTime getDatum() { return datum; }
    public void setDatum(java.time.LocalDateTime v) { this.datum = v; }

    @Column(name = "EuSifDeVnos")
    private Integer euSifDeVnos;
    public Integer getEuSifDeVnos() { return euSifDeVnos; }
    public void setEuSifDeVnos(Integer v) { this.euSifDeVnos = v; }

    @Column(name = "EuDatum")
    private java.time.LocalDateTime euDatum;
    public java.time.LocalDateTime getEuDatum() { return euDatum; }
    public void setEuDatum(java.time.LocalDateTime v) { this.euDatum = v; }

    @Column(name = "EuSifDe")
    private Integer euSifDe;
    public Integer getEuSifDe() { return euSifDe; }
    public void setEuSifDe(Integer v) { this.euSifDe = v; }

    @Column(name = "EuSifVrUre")
    private Integer euSifVrUre;
    public Integer getEuSifVrUre() { return euSifVrUre; }
    public void setEuSifVrUre(Integer v) { this.euSifVrUre = v; }

    @Column(name = "EuStTock")
    private Integer euStTock;
    public Integer getEuStTock() { return euStTock; }
    public void setEuStTock(Integer v) { this.euStTock = v; }

    @Column(name = "EuStUr")
    private Integer euStUr;
    public Integer getEuStUr() { return euStUr; }
    public void setEuStUr(Integer v) { this.euStUr = v; }

    @Column(name = "EuFaktor")
    private Double euFaktor;
    public Double getEuFaktor() { return euFaktor; }
    public void setEuFaktor(Double v) { this.euFaktor = v; }

    @Column(name = "EuFaktorRez")
    private Double euFaktorRez;
    public Double getEuFaktorRez() { return euFaktorRez; }
    public void setEuFaktorRez(Double v) { this.euFaktorRez = v; }

    @Column(name = "EuSifObrPre")
    private Integer euSifObrPre;
    public Integer getEuSifObrPre() { return euSifObrPre; }
    public void setEuSifObrPre(Integer v) { this.euSifObrPre = v; }

    @Column(name = "EuStObrLista")
    private Integer euStObrLista;
    public Integer getEuStObrLista() { return euStObrLista; }
    public void setEuStObrLista(Integer v) { this.euStObrLista = v; }

    @Column(name = "EuDatPrenosa")
    private java.time.LocalDateTime euDatPrenosa;
    public java.time.LocalDateTime getEuDatPrenosa() { return euDatPrenosa; }
    public void setEuDatPrenosa(java.time.LocalDateTime v) { this.euDatPrenosa = v; }

    @Column(name = "EuStZapDelNaloga")
    private Integer euStZapDelNaloga;
    public Integer getEuStZapDelNaloga() { return euStZapDelNaloga; }
    public void setEuStZapDelNaloga(Integer v) { this.euStZapDelNaloga = v; }

    @Column(name = "EuStDelNaloga")
    private Integer euStDelNaloga;
    public Integer getEuStDelNaloga() { return euStDelNaloga; }
    public void setEuStDelNaloga(Integer v) { this.euStDelNaloga = v; }

    @Column(name = "EuStPosDelNaloga")
    private Integer euStPosDelNaloga;
    public Integer getEuStPosDelNaloga() { return euStPosDelNaloga; }
    public void setEuStPosDelNaloga(Integer v) { this.euStPosDelNaloga = v; }

    @Column(name = "EuStZapPotekaDN")
    private Integer euStZapPotekaDN;
    public Integer getEuStZapPotekaDN() { return euStZapPotekaDN; }
    public void setEuStZapPotekaDN(Integer v) { this.euStZapPotekaDN = v; }

    @Column(name = "EuStZapOperacije")
    private Integer euStZapOperacije;
    public Integer getEuStZapOperacije() { return euStZapOperacije; }
    public void setEuStZapOperacije(Integer v) { this.euStZapOperacije = v; }

    @Column(name = "EuKolDobrih")
    private Integer euKolDobrih;
    public Integer getEuKolDobrih() { return euKolDobrih; }
    public void setEuKolDobrih(Integer v) { this.euKolDobrih = v; }

    @Column(name = "EuKolIzmeta")
    private Integer euKolIzmeta;
    public Integer getEuKolIzmeta() { return euKolIzmeta; }
    public void setEuKolIzmeta(Integer v) { this.euKolIzmeta = v; }

    @Column(name = "EuSifDelCentra")
    private Integer euSifDelCentra;
    public Integer getEuSifDelCentra() { return euSifDelCentra; }
    public void setEuSifDelCentra(Integer v) { this.euSifDelCentra = v; }

    @Column(name = "EuZadnjaOp")
    private Integer euZadnjaOp;
    public Integer getEuZadnjaOp() { return euZadnjaOp; }
    public void setEuZadnjaOp(Integer v) { this.euZadnjaOp = v; }

    @Column(name = "EuSkupina")
    private Integer euSkupina;
    public Integer getEuSkupina() { return euSkupina; }
    public void setEuSkupina(Integer v) { this.euSkupina = v; }

    @Column(name = "EuVrstaIzm")
    private Integer euVrstaIzm;
    public Integer getEuVrstaIzm() { return euVrstaIzm; }
    public void setEuVrstaIzm(Integer v) { this.euVrstaIzm = v; }

    @Column(name = "EuOznSled")
    private Integer euOznSled;
    public Integer getEuOznSled() { return euOznSled; }
    public void setEuOznSled(Integer v) { this.euOznSled = v; }

    @Column(name = "EuVredDela")
    private Double euVredDela;
    public Double getEuVredDela() { return euVredDela; }
    public void setEuVredDela(Double v) { this.euVredDela = v; }

    @Column(name = "EuPartija")
    private String euPartija;
    public String getEuPartija() { return euPartija; }
    public void setEuPartija(String v) { this.euPartija = v; }

    @Column(name = "EuIUSif")
    private Integer euIUSif;
    public Integer getEuIUSif() { return euIUSif; }
    public void setEuIUSif(Integer v) { this.euIUSif = v; }

    @Column(name = "EuStNorUr")
    private Double euStNorUr;
    public Double getEuStNorUr() { return euStNorUr; }
    public void setEuStNorUr(Double v) { this.euStNorUr = v; }

    @Column(name = "EuTipDela")
    private Integer euTipDela;
    public Integer getEuTipDela() { return euTipDela; }
    public void setEuTipDela(Integer v) { this.euTipDela = v; }

    @Column(name = "EuTip")
    private Integer euTip;
    public Integer getEuTip() { return euTip; }
    public void setEuTip(Integer v) { this.euTip = v; }

    @Column(name = "EuStevDel")
    private Integer euStevDel;
    public Integer getEuStevDel() { return euStevDel; }
    public void setEuStevDel(Integer v) { this.euStevDel = v; }

    @Column(name = "EuDatDeRez")
    private java.time.LocalDateTime euDatDeRez;
    public java.time.LocalDateTime getEuDatDeRez() { return euDatDeRez; }
    public void setEuDatDeRez(java.time.LocalDateTime v) { this.euDatDeRez = v; }

    @Column(name = "EuRaz_StrDel")
    private String euRaz_StrDel;
    public String getEuRaz_StrDel() { return euRaz_StrDel; }
    public void setEuRaz_StrDel(String v) { this.euRaz_StrDel = v; }

    @Column(name = "EuKvaliteta")
    private String euKvaliteta;
    public String getEuKvaliteta() { return euKvaliteta; }
    public void setEuKvaliteta(String v) { this.euKvaliteta = v; }

    @Column(name = "EuObr")
    private Integer euObr;
    public Integer getEuObr() { return euObr; }
    public void setEuObr(Integer v) { this.euObr = v; }

    @Column(name = "EuStMpStoritev")
    private Integer euStMpStoritev;
    public Integer getEuStMpStoritev() { return euStMpStoritev; }
    public void setEuStMpStoritev(Integer v) { this.euStMpStoritev = v; }

    @Column(name = "EuZnesek")
    private Double euZnesek;
    public Double getEuZnesek() { return euZnesek; }
    public void setEuZnesek(Double v) { this.euZnesek = v; }

    @Column(name = "EuSifStroskMesta")
    private Integer euSifStroskMesta;
    public Integer getEuSifStroskMesta() { return euSifStroskMesta; }
    public void setEuSifStroskMesta(Integer v) { this.euSifStroskMesta = v; }

    @Column(name = "EuOpomba")
    private String euOpomba;
    public String getEuOpomba() { return euOpomba; }
    public void setEuOpomba(String v) { this.euOpomba = v; }

    @Column(name = "EuDeSifStat")
    private Integer euDeSifStat;
    public Integer getEuDeSifStat() { return euDeSifStat; }
    public void setEuDeSifStat(Integer v) { this.euDeSifStat = v; }

    @Column(name = "EuMPSifProdSkup")
    private Integer euMPSifProdSkup;
    public Integer getEuMPSifProdSkup() { return euMPSifProdSkup; }
    public void setEuMPSifProdSkup(Integer v) { this.euMPSifProdSkup = v; }

    @Column(name = "EuFaktor2")
    private Double euFaktor2;
    public Double getEuFaktor2() { return euFaktor2; }
    public void setEuFaktor2(Double v) { this.euFaktor2 = v; }

    @Column(name = "EuFaktor3")
    private Double euFaktor3;
    public Double getEuFaktor3() { return euFaktor3; }
    public void setEuFaktor3(Double v) { this.euFaktor3 = v; }

    @Column(name = "EuSifVrDok")
    private Integer euSifVrDok;
    public Integer getEuSifVrDok() { return euSifVrDok; }
    public void setEuSifVrDok(Integer v) { this.euSifVrDok = v; }

    @Column(name = "EuSkupIzd")
    private Integer euSkupIzd;
    public Integer getEuSkupIzd() { return euSkupIzd; }
    public void setEuSkupIzd(Integer v) { this.euSkupIzd = v; }

    @Column(name = "EuPostNapake")
    private Integer euPostNapake;
    public Integer getEuPostNapake() { return euPostNapake; }
    public void setEuPostNapake(Integer v) { this.euPostNapake = v; }

    @Column(name = "EuNosilStroska")
    private Integer euNosilStroska;
    public Integer getEuNosilStroska() { return euNosilStroska; }
    public void setEuNosilStroska(Integer v) { this.euNosilStroska = v; }

    @Column(name = "EuVrstaNeProizv")
    private Integer euVrstaNeProizv;
    public Integer getEuVrstaNeProizv() { return euVrstaNeProizv; }
    public void setEuVrstaNeProizv(Integer v) { this.euVrstaNeProizv = v; }

    @Column(name = "EuVzrokIzmeta")
    private Integer euVzrokIzmeta;
    public Integer getEuVzrokIzmeta() { return euVzrokIzmeta; }
    public void setEuVzrokIzmeta(Integer v) { this.euVzrokIzmeta = v; }

    @Column(name = "EuSled")
    private Integer euSled;
    public Integer getEuSled() { return euSled; }
    public void setEuSled(Integer v) { this.euSled = v; }

    @Column(name = "EuIdentIzmeta")
    private String euIdentIzmeta;
    public String getEuIdentIzmeta() { return euIdentIzmeta; }
    public void setEuIdentIzmeta(String v) { this.euIdentIzmeta = v; }

    @Column(name = "EuMasaIzmeta")
    private Double euMasaIzmeta;
    public Double getEuMasaIzmeta() { return euMasaIzmeta; }
    public void setEuMasaIzmeta(Double v) { this.euMasaIzmeta = v; }

    @Column(name = "EuSklIzmeta")
    private Integer euSklIzmeta;
    public Integer getEuSklIzmeta() { return euSklIzmeta; }
    public void setEuSklIzmeta(Integer v) { this.euSklIzmeta = v; }

    @Column(name = "EuLokIzmeta")
    private String euLokIzmeta;
    public String getEuLokIzmeta() { return euLokIzmeta; }
    public void setEuLokIzmeta(String v) { this.euLokIzmeta = v; }

    @Column(name = "EuKontrolor")
    private String euKontrolor;
    public String getEuKontrolor() { return euKontrolor; }
    public void setEuKontrolor(String v) { this.euKontrolor = v; }

    @Column(name = "EuRazlogDod")
    private String euRazlogDod;
    public String getEuRazlogDod() { return euRazlogDod; }
    public void setEuRazlogDod(String v) { this.euRazlogDod = v; }

    @Column(name = "EuPovzrocitelj")
    private String euPovzrocitelj;
    public String getEuPovzrocitelj() { return euPovzrocitelj; }
    public void setEuPovzrocitelj(String v) { this.euPovzrocitelj = v; }

    @Column(name = "EuNacin")
    private String euNacin;
    public String getEuNacin() { return euNacin; }
    public void setEuNacin(String v) { this.euNacin = v; }

    @Column(name = "EuCustom1")
    private String euCustom1;
    public String getEuCustom1() { return euCustom1; }
    public void setEuCustom1(String v) { this.euCustom1 = v; }

    @Column(name = "EuCustom2")
    private String euCustom2;
    public String getEuCustom2() { return euCustom2; }
    public void setEuCustom2(String v) { this.euCustom2 = v; }

    @Column(name = "EuCustom3")
    private String euCustom3;
    public String getEuCustom3() { return euCustom3; }
    public void setEuCustom3(String v) { this.euCustom3 = v; }

    @Column(name = "EuCustom4")
    private String euCustom4;
    public String getEuCustom4() { return euCustom4; }
    public void setEuCustom4(String v) { this.euCustom4 = v; }

    @Column(name = "EuCustom5")
    private String euCustom5;
    public String getEuCustom5() { return euCustom5; }
    public void setEuCustom5(String v) { this.euCustom5 = v; }

    @Column(name = "EuCustom6")
    private String euCustom6;
    public String getEuCustom6() { return euCustom6; }
    public void setEuCustom6(String v) { this.euCustom6 = v; }

    @Column(name = "EuCustom7")
    private String euCustom7;
    public String getEuCustom7() { return euCustom7; }
    public void setEuCustom7(String v) { this.euCustom7 = v; }

    @Column(name = "EuProjekt")
    private String euProjekt;
    public String getEuProjekt() { return euProjekt; }
    public void setEuProjekt(String v) { this.euProjekt = v; }
}
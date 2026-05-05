package com.nalogapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Evidencaur {

    @Id
    @Column(name = "EuStZapisa")
    private Integer euStZapisa;
    public Integer getEuStZapisa() {return euStZapisa;}
    public void setEuStZapisa(Integer v) {this.euStZapisa = v;}

    private String nameOper;
    @Column(name = "NameOper")
    public String getNameOper() { return nameOper; }
    public void setNameOper(String v) { this.nameOper = v; }

    private java.time.LocalDateTime datum;
    @Column(name = "Datum")
    public java.time.LocalDateTime getDatum() { return datum; }
    public void setDatum(java.time.LocalDateTime v) { this.datum = v; }

    private Integer euSifDeVnos;
    @Column(name = "EuSifDeVnos")
    public Integer getEuSifDeVnos() { return euSifDeVnos; }
    public void setEuSifDeVnos(Integer v) { this.euSifDeVnos = v; }

    private java.time.LocalDateTime euDatum;
    @Column(name = "EuDatum")
    public java.time.LocalDateTime getEuDatum() { return euDatum; }
    public void setEuDatum(java.time.LocalDateTime v) { this.euDatum = v; }

    private Integer euSifDe;
    @Column(name = "EuSifDe")
    public Integer getEuSifDe() { return euSifDe; }
    public void setEuSifDe(Integer v) { this.euSifDe = v; }

    private Integer euSifVrUre;
    @Column(name = "EuSifVrUre")
    public Integer getEuSifVrUre() { return euSifVrUre; }
    public void setEuSifVrUre(Integer v) { this.euSifVrUre = v; }

    private Integer euStTock;
    @Column(name = "EuStTock")
    public Integer getEuStTock() { return euStTock; }
    public void setEuStTock(Integer v) { this.euStTock = v; }

    private Integer euStUr;
    @Column(name = "EuStUr")
    public Integer getEuStUr() { return euStUr; }
    public void setEuStUr(Integer v) { this.euStUr = v; }

    private Double euFaktor;
    @Column(name = "EuFaktor")
    public Double getEuFaktor() { return euFaktor; }
    public void setEuFaktor(Double v) { this.euFaktor = v; }

    private Double euFaktorRez;
    @Column(name = "EuFaktorRez")
    public Double getEuFaktorRez() { return euFaktorRez; }
    public void setEuFaktorRez(Double v) { this.euFaktorRez = v; }

    private Integer euSifObrPre;
    @Column(name = "EuSifObrPre")
    public Integer getEuSifObrPre() { return euSifObrPre; }
    public void setEuSifObrPre(Integer v) { this.euSifObrPre = v; }

    private Integer euStObrLista;
    @Column(name = "EuStObrLista")
    public Integer getEuStObrLista() { return euStObrLista; }
    public void setEuStObrLista(Integer v) { this.euStObrLista = v; }

    private java.time.LocalDateTime euDatPrenosa;
    @Column(name = "EuDatPrenosa")
    public java.time.LocalDateTime getEuDatPrenosa() { return euDatPrenosa; }
    public void setEuDatPrenosa(java.time.LocalDateTime v) { this.euDatPrenosa = v; }

    private Integer euStZapDelNaloga;
    @Column(name = "EuStZapDelNaloga")
    public Integer getEuStZapDelNaloga() { return euStZapDelNaloga; }
    public void setEuStZapDelNaloga(Integer v) { this.euStZapDelNaloga = v; }

    private Integer euStDelNaloga;
    @Column(name = "EuStDelNaloga")
    public Integer getEuStDelNaloga() { return euStDelNaloga; }
    public void setEuStDelNaloga(Integer v) { this.euStDelNaloga = v; }

    private Integer euStPosDelNaloga;
    @Column(name = "EuStPosDelNaloga")
    public Integer getEuStPosDelNaloga() { return euStPosDelNaloga; }
    public void setEuStPosDelNaloga(Integer v) { this.euStPosDelNaloga = v; }

    private Integer euStZapPotekaDN;
    @Column(name = "EuStZapPotekaDN")
    public Integer getEuStZapPotekaDN() { return euStZapPotekaDN; }
    public void setEuStZapPotekaDN(Integer v) { this.euStZapPotekaDN = v; }

    private Integer euStZapOperacije;
    @Column(name = "EuStZapOperacije")
    public Integer getEuStZapOperacije() { return euStZapOperacije; }
    public void setEuStZapOperacije(Integer v) { this.euStZapOperacije = v; }

    private Integer euKolDobrih;
    @Column(name = "EuKolDobrih")
    public Integer getEuKolDobrih() { return euKolDobrih; }
    public void setEuKolDobrih(Integer v) { this.euKolDobrih = v; }

    private Integer euKolIzmeta;
    @Column(name = "EuKolIzmeta")
    public Integer getEuKolIzmeta() { return euKolIzmeta; }
    public void setEuKolIzmeta(Integer v) { this.euKolIzmeta = v; }

    private Integer euSifDelCentra;
    @Column(name = "EuSifDelCentra")
    public Integer getEuSifDelCentra() { return euSifDelCentra; }
    public void setEuSifDelCentra(Integer v) { this.euSifDelCentra = v; }

    private Integer euZadnjaOp;
    @Column(name = "EuZadnjaOp")
    public Integer getEuZadnjaOp() { return euZadnjaOp; }
    public void setEuZadnjaOp(Integer v) { this.euZadnjaOp = v; }

    private Integer euSkupina;
    @Column(name = "EuSkupina")
    public Integer getEuSkupina() { return euSkupina; }
    public void setEuSkupina(Integer v) { this.euSkupina = v; }

    private Integer euVrstaIzm;
    @Column(name = "EuVrstaIzm")
    public Integer getEuVrstaIzm() { return euVrstaIzm; }
    public void setEuVrstaIzm(Integer v) { this.euVrstaIzm = v; }

    private Integer euOznSled;
    @Column(name = "EuOznSled")
    public Integer getEuOznSled() { return euOznSled; }
    public void setEuOznSled(Integer v) { this.euOznSled = v; }

    private Double euVredDela;
    @Column(name = "EuVredDela")
    public Double getEuVredDela() { return euVredDela; }
    public void setEuVredDela(Double v) { this.euVredDela = v; }

    private String euPartija;
    @Column(name = "EuPartija")
    public String getEuPartija() { return euPartija; }
    public void setEuPartija(String v) { this.euPartija = v; }

    private Integer euIUSif;
    @Column(name = "EuIUSif")
    public Integer getEuIUSif() { return euIUSif; }
    public void setEuIUSif(Integer v) { this.euIUSif = v; }

    private Double euStNorUr;
    @Column(name = "EuStNorUr")
    public Double getEuStNorUr() { return euStNorUr; }
    public void setEuStNorUr(Double v) { this.euStNorUr = v; }

    private Integer euTipDela;
    @Column(name = "EuTipDela")
    public Integer getEuTipDela() { return euTipDela; }
    public void setEuTipDela(Integer v) { this.euTipDela = v; }

    private Integer euTip;
    @Column(name = "EuTip")
    public Integer getEuTip() { return euTip; }
    public void setEuTip(Integer v) { this.euTip = v; }

    private Integer euStevDel;
    @Column(name = "EuStevDel")
    public Integer getEuStevDel() { return euStevDel; }
    public void setEuStevDel(Integer v) { this.euStevDel = v; }

    private java.time.LocalDateTime euDatDeRez;
    @Column(name = "EuDatDeRez")
    public java.time.LocalDateTime getEuDatDeRez() { return euDatDeRez; }
    public void setEuDatDeRez(java.time.LocalDateTime v) { this.euDatDeRez = v; }

    private String euRaz_StrDel;
    @Column(name = "EuRaz_StrDel")
    public String getEuRaz_StrDel() { return euRaz_StrDel; }
    public void setEuRaz_StrDel(String v) { this.euRaz_StrDel = v; }

    private String euKvaliteta;
    @Column(name = "EuKvaliteta")
    public String getEuKvaliteta() { return euKvaliteta; }
    public void setEuKvaliteta(String v) { this.euKvaliteta = v; }

    private Integer euObr;
    @Column(name = "EuObr")
    public Integer getEuObr() { return euObr; }
    public void setEuObr(Integer v) { this.euObr = v; }

    private Integer euStMpStoritev;
    @Column(name = "EuStMpStoritev")
    public Integer getEuStMpStoritev() { return euStMpStoritev; }
    public void setEuStMpStoritev(Integer v) { this.euStMpStoritev = v; }

    private Double euZnesek;
    @Column(name = "EuZnesek")
    public Double getEuZnesek() { return euZnesek; }
    public void setEuZnesek(Double v) { this.euZnesek = v; }

    private Integer euSifStroskMesta;
    @Column(name = "EuSifStroskMesta")
    public Integer getEuSifStroskMesta() { return euSifStroskMesta; }
    public void setEuSifStroskMesta(Integer v) { this.euSifStroskMesta = v; }

    private String euOpomba;
    @Column(name = "EuOpomba")
    public String getEuOpomba() { return euOpomba; }
    public void setEuOpomba(String v) { this.euOpomba = v; }

    private Integer euDeSifStat;
    @Column(name = "EuDeSifStat")
    public Integer getEuDeSifStat() { return euDeSifStat; }
    public void setEuDeSifStat(Integer v) { this.euDeSifStat = v; }

    private Integer euMPSifProdSkup;
    @Column(name = "EuMPSifProdSkup")
    public Integer getEuMPSifProdSkup() { return euMPSifProdSkup; }
    public void setEuMPSifProdSkup(Integer v) { this.euMPSifProdSkup = v; }

    private Double euFaktor2;
    @Column(name = "EuFaktor2")
    public Double getEuFaktor2() { return euFaktor2; }
    public void setEuFaktor2(Double v) { this.euFaktor2 = v; }

    private Double euFaktor3;
    @Column(name = "EuFaktor3")
    public Double getEuFaktor3() { return euFaktor3; }
    public void setEuFaktor3(Double v) { this.euFaktor3 = v; }

    private Integer euSifVrDok;
    @Column(name = "EuSifVrDok")
    public Integer getEuSifVrDok() { return euSifVrDok; }
    public void setEuSifVrDok(Integer v) { this.euSifVrDok = v; }

    private Integer euSkupIzd;
    @Column(name = "EuSkupIzd")
    public Integer getEuSkupIzd() { return euSkupIzd; }
    public void setEuSkupIzd(Integer v) { this.euSkupIzd = v; }

    private Integer euPostNapake;
    @Column(name = "EuPostNapake")
    public Integer getEuPostNapake() { return euPostNapake; }
    public void setEuPostNapake(Integer v) { this.euPostNapake = v; }

    private Integer euNosilStroska;
    @Column(name = "EuNosilStroska")
    public Integer getEuNosilStroska() { return euNosilStroska; }
    public void setEuNosilStroska(Integer v) { this.euNosilStroska = v; }

    private Integer euVrstaNeProizv;
    @Column(name = "EuVrstaNeProizv")
    public Integer getEuVrstaNeProizv() { return euVrstaNeProizv; }
    public void setEuVrstaNeProizv(Integer v) { this.euVrstaNeProizv = v; }

    private Integer euVzrokIzmeta;
    @Column(name = "EuVzrokIzmeta")
    public Integer getEuVzrokIzmeta() { return euVzrokIzmeta; }
    public void setEuVzrokIzmeta(Integer v) { this.euVzrokIzmeta = v; }

    private Integer euSled;
    @Column(name = "EuSled")
    public Integer getEuSled() { return euSled; }
    public void setEuSled(Integer v) { this.euSled = v; }

    private String euIdentIzmeta;
    @Column(name = "EuIdentIzmeta")
    public String getEuIdentIzmeta() { return euIdentIzmeta; }
    public void setEuIdentIzmeta(String v) { this.euIdentIzmeta = v; }

    private Double euMasaIzmeta;
    @Column(name = "EuMasaIzmeta")
    public Double getEuMasaIzmeta() { return euMasaIzmeta; }
    public void setEuMasaIzmeta(Double v) { this.euMasaIzmeta = v; }

    private Integer euSklIzmeta;
    @Column(name = "EuSklIzmeta")
    public Integer getEuSklIzmeta() { return euSklIzmeta; }
    public void setEuSklIzmeta(Integer v) { this.euSklIzmeta = v; }

    private String euLokIzmeta;
    @Column(name = "EuLokIzmeta")
    public String getEuLokIzmeta() { return euLokIzmeta; }
    public void setEuLokIzmeta(String v) { this.euLokIzmeta = v; }

    private String euKontrolor;
    @Column(name = "EuKontrolor")
    public String getEuKontrolor() { return euKontrolor; }
    public void setEuKontrolor(String v) { this.euKontrolor = v; }

    private String euRazlogDod;
    @Column(name = "EuRazlogDod")
    public String getEuRazlogDod() { return euRazlogDod; }
    public void setEuRazlogDod(String v) { this.euRazlogDod = v; }

    private String euPovzrocitelj;
    @Column(name = "EuPovzrocitelj")
    public String getEuPovzrocitelj() { return euPovzrocitelj; }
    public void setEuPovzrocitelj(String v) { this.euPovzrocitelj = v; }

    private String euNacin;
    @Column(name = "EuNacin")
    public String getEuNacin() { return euNacin; }
    public void setEuNacin(String v) { this.euNacin = v; }

    private String euCustom1;
    @Column(name = "EuCustom1")
    public String getEuCustom1() { return euCustom1; }
    public void setEuCustom1(String v) { this.euCustom1 = v; }

    private String euCustom2;
    @Column(name = "EuCustom2")
    public String getEuCustom2() { return euCustom2; }
    public void setEuCustom2(String v) { this.euCustom2 = v; }

    private String euCustom3;
    @Column(name = "EuCustom3")
    public String getEuCustom3() { return euCustom3; }
    public void setEuCustom3(String v) { this.euCustom3 = v; }

    private String euCustom4;
    @Column(name = "EuCustom4")
    public String getEuCustom4() { return euCustom4; }
    public void setEuCustom4(String v) { this.euCustom4 = v; }

    private String euCustom5;
    @Column(name = "EuCustom5")
    public String getEuCustom5() { return euCustom5; }
    public void setEuCustom5(String v) { this.euCustom5 = v; }

    private String euCustom6;
    @Column(name = "EuCustom6")
    public String getEuCustom6() { return euCustom6; }
    public void setEuCustom6(String v) { this.euCustom6 = v; }

    private String euCustom7;
    @Column(name = "EuCustom7")
    public String getEuCustom7() { return euCustom7; }
    public void setEuCustom7(String v) { this.euCustom7 = v; }

    private String euProjekt;
    @Column(name = "EuProjekt")
    public String getEuProjekt() { return euProjekt; }
    public void setEuProjekt(String v) { this.euProjekt = v; }
}
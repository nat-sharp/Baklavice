package Klase;

import java.util.ArrayList;
import java.util.List;

public class Recept {

	private String nazivRec;
	private String opisPripreme;
	private Tezina tezina;
	private int duzinaMin;
	private String imgPath;		//da li cemo ovo uopste implementirati
	private String videoLink;
	private int brMedalja;
	private KorisnickiNalog autor;	//veza 1..1 
	private ArrayList<KorisnickiNalog> komentatori;	//veza 0..*
	private ArrayList<Kategorija> kategorije;
	private List<Alati>kuhinjskaOprema;
	private List<Ocena>ocene;
	private List<Kolicina>kolicineSastojaka;
	private Recenzija recenzija;
	
	
	
	public List<Alati> getKuhinskaOprema() {
		return kuhinjskaOprema;
	}
	public void setKuhinskaOprema(List<Alati> kuhinskaOprema) {
		this.kuhinjskaOprema = kuhinskaOprema;
	}
	public String getNazivRec() {
		return nazivRec;
	}
	public void setNazivRec(String nazivRec) {
		this.nazivRec = nazivRec;
	}
	
	public String getOpisPripreme() {
		return opisPripreme;
	}
	public void setOpisPripreme(String opisPripreme) {
		this.opisPripreme = opisPripreme;
	}
	
	public Tezina getTezina() {
		return tezina;
	}
	public void setTezina(Tezina tezina) {
		this.tezina = tezina;
	}
	
	public int getDuzinaMin() {
		return duzinaMin;
	}
	public void setDuzinaMin(int duzinaMin) {
		this.duzinaMin = duzinaMin;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	
	public int getBrMedalja() {
		return brMedalja;
	}
	public void setBrMedalja(int brMedalja) {
		this.brMedalja = brMedalja;
	}
	
	public KorisnickiNalog getAutor() {
		return autor;
	}
	public void setAutor(KorisnickiNalog autor) {
		this.autor = autor;
	}
	
	//za liste treba dodajElement, izbrisiElement i reatOnly verzija
	
	public ArrayList<KorisnickiNalog> getKomentatori() {
		return komentatori;
	}
	public void setKomentatori(ArrayList<KorisnickiNalog> komentatori) {
		this.komentatori = komentatori;
	}
	
	public ArrayList<Kategorija> getKategorije() {
		return kategorije;
	}
	public void setKategorije(ArrayList<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
	
}

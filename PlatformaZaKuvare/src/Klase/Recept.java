package Klase;

import java.util.ArrayList;
import java.util.List;

public class Recept {
	private List<Alat> oprema;
	private String nazivRec;
	private String opisPripreme;
	private Tezina tezina;
	private int duzinaMin;
	private String imgPath;
	private String videoLink;
	private int brMedalja = 0;
	private KorisnickiNalog autor;
	private Recenzija recenzija;
	private List<Ocena> ocene;
	private List<Kolicina> kolicineSastojaka;
	private List<Kategorija> kategorije;
	
	public Recept() {
		this.oprema = new ArrayList<Alat>();
		this.nazivRec = "";
		this.opisPripreme = "";
		this.duzinaMin = 0;
		this.imgPath = "";
		this.videoLink = "";
		this.ocene = new ArrayList<Ocena>();
		this.kolicineSastojaka = new ArrayList<Kolicina>();
		this.kategorije = new ArrayList<Kategorija>();
	}
	
	public Recept(List<Alat> oprema, String nazivRec, String opisPripreme, Tezina tezina, int duzinaMin, String imgPath,
			String videoLink, int brMedalja, KorisnickiNalog autor, Recenzija recenzija, List<Ocena> ocene,
			List<Kolicina> kolicineSastojaka, List<Kategorija> kategorije) {
		super();
		this.oprema = oprema;
		this.nazivRec = nazivRec;
		this.opisPripreme = opisPripreme;
		this.tezina = tezina;
		this.duzinaMin = duzinaMin;
		this.imgPath = imgPath;
		this.videoLink = videoLink;
		this.brMedalja = brMedalja;
		this.autor = autor;
		this.recenzija = recenzija;
		this.ocene = ocene;
		this.kolicineSastojaka = kolicineSastojaka;
		this.kategorije = kategorije;
	}

	public List<Alat> getOprema() {
		return oprema;
	}
	
	public void setOprema(List<Alat> oprema) {
		this.oprema = oprema;
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
	
	public Recenzija getRecenzija() {
		return recenzija;
	}
	
	public void setRecenzija(Recenzija recenzija) {
		this.recenzija = recenzija;
	}
	
	public List<Ocena> getOcene() {
		return ocene;
	}
	
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public List<Kolicina> getKolicineSastojaka() {
		return kolicineSastojaka;
	}
	
	public void setKolicineSastojaka(List<Kolicina> kolicineSastojaka) {
		this.kolicineSastojaka = kolicineSastojaka;
	}
	
	public List<Kategorija> getKategorije() {
		return kategorije;
	}
	
	public void setKategorije(List<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
}

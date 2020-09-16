package Klase;

import java.util.ArrayList;
import java.util.Collections;
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
		this.nazivRec = "";
		this.oprema = new ArrayList<Alat>();
		this.opisPripreme = "";
		this.duzinaMin = 0;
		this.imgPath = "";
		this.videoLink = "";
		this.ocene = new ArrayList<Ocena>();
		this.kolicineSastojaka = new ArrayList<Kolicina>();
		this.kategorije = new ArrayList<Kategorija>();
	}
	
	public Recept(String nazivRec, List<Alat> oprema, String opisPripreme, Tezina tezina, int duzinaMin, String imgPath,
			String videoLink, int brMedalja, KorisnickiNalog autor, Recenzija recenzija, List<Ocena> ocene,
			List<Kolicina> kolicineSastojaka, List<Kategorija> kategorije) {
		this.nazivRec = nazivRec;
		this.oprema = oprema;
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
	
	public String getNazivRec() {
		return nazivRec;
	}
	
	public void setNazivRec(String nazivRec) {
		this.nazivRec = nazivRec;
	}

	public List<Alat> getNepromenljivuOprema() {
		return Collections.unmodifiableList(oprema);
	}
	
	public void setOprema(List<Alat> oprema) {
		this.oprema = oprema;
	}
	
	public void dodajAlat(Alat a) {
		this.oprema.add(a);
	}
	
	public boolean izbrisiAlat(Alat a) {
		return this.oprema.remove(a);
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
	
	public List<Ocena> getNepromenljiveOcene() {
		return Collections.unmodifiableList(ocene);
	}
	
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public void dodajOcenu(Ocena o) {
		this.ocene.add(o);
	}
	
	public boolean izbrisiOcenu(Ocena o) {
		return this.ocene.remove(o);
	}
	
	public List<Kolicina> getNepromenljiveKolicineSastojaka() {
		return Collections.unmodifiableList(kolicineSastojaka);
	}
	
	public void setKolicineSastojaka(List<Kolicina> kolicineSastojaka) {
		this.kolicineSastojaka = kolicineSastojaka;
	}
	
	public void dodajKolicinuSastojka(Kolicina ks) {
		this.kolicineSastojaka.add(ks);
	}
	
	public boolean izbrisiKolicinuSastojka(Kolicina ks) {
		return this.kolicineSastojaka.remove(ks);
	}
	
	public List<Kategorija> getNepromenljiveKategorije() {
		return Collections.unmodifiableList(kategorije);
	}
	
	public void setKategorije(List<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
	public void dodajKategoriju(Kategorija k) {
		this.kategorije.add(k);
	}
	
	public boolean izbrisiKategoriju(Kategorija k) {
		return this.kategorije.remove(k);
	}

	public List<Alat> getOprema() {
		return oprema;
	}

	public List<Ocena> getOcene() {
		return ocene;
	}

	public List<Kolicina> getKolicineSastojaka() {
		return kolicineSastojaka;
	}

	public List<Kategorija> getKategorije() {
		return kategorije;
	}
	
	
}

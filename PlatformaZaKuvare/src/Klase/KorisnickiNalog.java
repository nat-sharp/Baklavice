package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KorisnickiNalog {

	private String korIme;
	private String lozinka;
	private TipKorisnika vrstaKorisnika;
	private Osoba korisnik;		//veza 1..1 prema Osobi
	
	private int brPratioca;
	private int brMedalja = 0;
	private List<KorisnickiNalog> zapraceniKor;	//veza 0..* = praceni
	private List<Kategorija> praceneKat;	//veza 0..*
	private List<Recept> autorskiRecepti;	//veza 0..* ka receptima = knjigaRecepata
	private List<Recept> obelezeniRecepti;	//veza 0..* ka receptima = obelezeni
	private List<Ocena> ocenjeniRecepti;	//da li ce imati listu ovu? ili ide preko asocijativne klase?
	private List<Sastojak> sastojci;
	private List<Alati> kuhinjskiAlati;
	
	
	public KorisnickiNalog() {
		//todo dodati obelezja jos koja su bila samo od Kor Naloga
		this.autorskiRecepti = new ArrayList<Recept>();
		this.zapraceniKor = new ArrayList<KorisnickiNalog>();
		this.praceneKat = new ArrayList<Kategorija>();
		this.obelezeniRecepti = new ArrayList<Recept>();
		this.ocenjeniRecepti = new ArrayList<Ocena>();
		this.sastojci = new ArrayList<Sastojak>();
		this.kuhinjskiAlati = new ArrayList<Alati>();
	}
	
	
	
	
	
	
	public int getBrPratioca() {
		return brPratioca;
	}
	public void setBrPratioca(int brPratioca) {
		this.brPratioca = brPratioca;
	}
	
	public int getBrMedalja() {
		return brMedalja;
	}
	public void setBrMedalja(int brMedalja) {
		this.brMedalja = brMedalja;
	}
	
	//ovo je za liste
	public List<Sastojak> getSastojci() {
		return Collections.unmodifiableList(sastojci);
	}
	public void setSastojci(ArrayList<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}
	public void dodajSastojak(Sastojak s) {
		sastojci.add(s);
	}
	public boolean izbrisiSastojak(Sastojak s) {
		return sastojci.remove(s);
	}
	
	public List<KorisnickiNalog> getZapraceniKor() {
		return Collections.unmodifiableList(zapraceniKor);
	}
	public void setZapraceniKor(ArrayList<KorisnickiNalog> zapraceniKor) {
		this.zapraceniKor = zapraceniKor;
	}
	public void dodajZapracenogKor(KorisnickiNalog k) {
		zapraceniKor.add(k);
	}
	public boolean izbrisiZapracenogKor(KorisnickiNalog k) {
		return zapraceniKor.remove(k);
	}
	
	public List<Kategorija> getPraceneKat() {
		return Collections.unmodifiableList(praceneKat);
	}
	public void setPraceneKat(ArrayList<Kategorija> praceneKat) {
		this.praceneKat = praceneKat;
	}
	public void dodajPracenuKat(Kategorija k) {
		praceneKat.add(k);
	}
	public boolean izbrisiZapracenogKor(Kategorija k) {
		return praceneKat.remove(k);
	}
	
	public List<Recept> getAutorskiRecepti() {
		return Collections.unmodifiableList(autorskiRecepti);
	}
	public void setAutorskiRecepti(ArrayList<Recept> autorskiRecepti) {
		this.autorskiRecepti = autorskiRecepti;
	}
	public void dodajAutorskiRec(Recept r) {
		autorskiRecepti.add(r);
	}
	public boolean izbrisiAutorskiRec(Recept r) {
		return autorskiRecepti.remove(r);
	}
	
	public List<Recept> getObelezeniRecepti() {
		return Collections.unmodifiableList(obelezeniRecepti);
	}
	public void setObelezeniRecepti(ArrayList<Recept> obelezeniRecepti) {
		this.obelezeniRecepti = obelezeniRecepti;
	}
	public void dodajObelezenRec(Recept r) {
		obelezeniRecepti.add(r);
	}
	public boolean izbrisiObelezenRec(Recept r) {
		return obelezeniRecepti.remove(r);
	}
	
	public List<Ocena> getOcenjeniRecepti() {
		return Collections.unmodifiableList(ocenjeniRecepti);
	}
	public void setOcenjeniRecepti(ArrayList<Ocena> ocenjeniRecepti) {
	}
	public void dodajOcenjenRec(Ocena o) {
		ocenjeniRecepti.add(o);
	}
	public boolean izbrisiOcenjenRec(Ocena o) {
		return ocenjeniRecepti.remove(o);
	}
	
	public List<Alati> getKuhinjskiAlati() {
		return Collections.unmodifiableList(kuhinjskiAlati);
	}
	public void setKuhinjskiAlati(ArrayList<Alati> kuhinjskiAlati) {
		this.kuhinjskiAlati = kuhinjskiAlati;
	}
	public void dodajAlat(Alati a) {
		this.kuhinjskiAlati.add(a);
	}
	public boolean izbrisiAlat(Alati a) {
		return this.kuhinjskiAlati.remove(a);
	}
	
	//novododate metode
	
	//gde su parametriii???
	public boolean kreirajRecept(String naziv, String opis, Tezina t, int brMin, String imgPut, String vidPut, 
			ArrayList<Kategorija> kat, ArrayList<Alati> alati, ArrayList<Kolicina> kolicine) {
		for (Recept r : this.autorskiRecepti) if (r.getNazivRec().equals(naziv)) return false;
		Recept rec = new Recept();
		rec.setNazivRec(naziv);
		rec.setAutor(this);
		rec.setDuzinaMin(brMin);
		rec.setImgPath(imgPut);
		rec.setVideoLink(vidPut);
		rec.setKategorije(kat);
		rec.setKuhinskaOprema(alati);
		rec.setOpisPripreme(opis);
		rec.setTezina(t);
		return true;
	}

	//sta menjaaas????
	public boolean izmeniRecept(Recept rec, String naziv, String opis, Tezina t, int brMin, String imgPut, String vidPut, 
			ArrayList<Kategorija> kat, ArrayList<Alati> alati, ArrayList<Kolicina> kolicine) {
		if (naziv != null) for (Recept r : this.autorskiRecepti) if (r.getNazivRec().equals(naziv)) return false;	//provera da li ime postoji
		if (naziv != null) rec.setNazivRec(naziv);
		if (brMin != 0) rec.setDuzinaMin(brMin);
		if (imgPut != null) rec.setImgPath(imgPut);
		if (vidPut != null) rec.setVideoLink(vidPut);
		if (!kat.isEmpty()) rec.setKategorije(kat); //recept mora biti u nekog kategoriji?
		rec.setKuhinskaOprema(alati);
		if (imgPut != null) rec.setOpisPripreme(opis);
		rec.setTezina(t);
		return true;
	}
	
	//moram proci kroz korisnikeKreatore i izbrisati sve ocene i reference na ovaj recept?!
	//boolean
	/*
	//*public boolean izbrisiRecept(Recept rec) {
		if (!this.autorskiRecepti.remove(rec)) return false;	//nije izbrisao, greska neka
		PlatformaZaKuvare pZk = PlatformaZaKuvare.getInstance();
		for (Osoba os: pZk.getOsobe()) {
			if (os instanceof KorisnikKreator) {
				KorisnikKreator k = (KorisnikKreator) os;
				k.izbrisiObelezenRec(rec);				//za slucaj da je u obelezenim
				Ocena ocena = k.pretraziOcene(rec);
				if (ocena != null) k.izbrisiOcenjenRec(ocena);	//za slucaj da je ocenio
			}
		}
		for (Kategorija k : pZk.getKategorija()) k.izbrisiRecept(rec);
		return true;
	}todo*/
	
	//odlajkivanje
	public void svidjanjeRecepta(Recept rec) {
		Ocena ocena = pretraziOcene(rec);
		if (ocena == null) {
			ocena = new Ocena();
			ocena.setAutor(this);
			ocena.setRecept(rec);
			ocena.setSvidjanje(true);
			this.ocenjeniRecepti.add(ocena);
		}
		else ocena.setSvidjanje(!ocena.isSvidjanje());
	}
	
	//tekst komentara
	public void komentarisi(Recept rec, String text) {
		Komentar k = new Komentar();
		k.setTekst(text);
		Ocena oc;
		oc = pretraziOcene(rec);
		if (oc == null) {
			oc = new Ocena();
			oc.setAutor(this);
			oc.setRecept(rec);
			this.ocenjeniRecepti.add(oc);
		}
		oc.dodajKomentar(k);
	}
	
	public void obrisiKomentar(Komentar kom) {
		for (Ocena oc : this.ocenjeniRecepti) {
			for (Komentar k : oc.getKomentari()) {
				if (k.equals(kom)) {
					ArrayList<Komentar> komi = new ArrayList<Komentar>();
					for (Komentar pom : oc.getKomentari()) komi.add(pom);
					komi.remove(kom);
					oc.setKomentari(komi);
					return;
				}
			}
		}
	}
	
	//fale zvezdice;  VOID
	public void oceniZvezde(Recept rec, int brZvezdica) {
		Ocena oc;
		oc = pretraziOcene(rec);
		if (oc == null) {
			oc = new Ocena();
			oc.setAutor(this);
			oc.setRecept(rec);
			this.ocenjeniRecepti.add(oc);
		}
		oc.setZvezdice(brZvezdica);
	}
	
	//BOOLEAN
	public boolean zapratiKategoriju(Kategorija kat) {
		if (-1 != praceneKat.indexOf(kat)) return false;
		kat.dodajPratioca(this);
		praceneKat.add(kat);
		return true;
	}
	public boolean otpratiKategoriju(Kategorija kat) {
		if (-1 == praceneKat.indexOf(kat)) return false;
		kat.izbrisiPratioca(this);
		praceneKat.remove(kat);
		return true;
	}
	
	public boolean zapratiKuvara(KorisnickiNalog kuvar) {
		if (-1 != zapraceniKor.indexOf(kuvar)) return false;
		kuvar.brPratioca += 1;
		zapraceniKor.add(kuvar);
		return true;
	}
	public boolean otpratiKuvara(KorisnickiNalog kuvar) {
		if (-1 == zapraceniKor.indexOf(kuvar)) return false;
		kuvar.brPratioca -= 1;
		zapraceniKor.remove(kuvar);
		return true;
	}

	private Ocena pretraziOcene(Recept r) {
		for (Ocena oc : this.ocenjeniRecepti) if (oc.getRecept() == r) return oc;
		return null;
	}
	

	public String getKorIme() {
		return korIme;
	}
	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public TipKorisnika getVrstaKorisnika() {
		return vrstaKorisnika;
	}
	public void setVrstaKorisnika(TipKorisnika vrstaKorisnika) {
		this.vrstaKorisnika = vrstaKorisnika;
	}
	
	public Osoba getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Osoba korisnik) {
		this.korisnik = korisnik;
	}
	
	
	public void brisanjeProfila() {
		//telo funkcije, brisi komentare, recepte, njega iz liste
	}
	
	
	
}

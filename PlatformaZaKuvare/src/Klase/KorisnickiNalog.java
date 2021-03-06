package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KorisnickiNalog {
	private String korIme;
	private String lozinka;
	private TipKorisnika vrstaKorisnika;	
	private int brPratioca = 0;
	private int brMedalja = 0;
	private ArrayList<Alat> oprema;
	private Osoba korisnik;
	private List<KorisnickiNalog> praceniKorisnici;	
	private List<Kategorija> praceneKategorije;
	private List<Recept> obelezeniRecepti;	
	private List<Recept> autorskiRecepti; //knjiga recepata korisnika		
	private List<Ocena> ocenjeniRecepti;	
	private ArrayList<Sastojak> sastojci;
	
	public KorisnickiNalog() {
		this.korIme = "";
		this.lozinka = "";
		this.oprema = new ArrayList<Alat>();
		this.praceniKorisnici = new ArrayList<KorisnickiNalog>();
		this.praceneKategorije = new ArrayList<Kategorija>();
		this.obelezeniRecepti = new ArrayList<Recept>();
		this.autorskiRecepti = new ArrayList<Recept>();
		this.ocenjeniRecepti = new ArrayList<Ocena>();
		this.sastojci = new ArrayList<Sastojak>();
	}
	
	public KorisnickiNalog(String korIme, String lozinka, TipKorisnika vrstaKorisnika, int brPratioca, int brMedalja,
			ArrayList<Alat> oprema, Osoba korisnik, ArrayList<KorisnickiNalog> praceniKorisnici,
			ArrayList<Kategorija> praceneKategorije,ArrayList<Recept> obelezeniRecepti, List<Recept> autorskiRecepti,
			ArrayList<Ocena> ocenjeniRecepti, ArrayList<Sastojak> sastojci) {
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.vrstaKorisnika = vrstaKorisnika;
		this.brPratioca = brPratioca;
		this.brMedalja = brMedalja;
		this.oprema = oprema;
		this.korisnik = korisnik;
		this.praceniKorisnici = praceniKorisnici;
		this.praceneKategorije = praceneKategorije;
		this.obelezeniRecepti = obelezeniRecepti;
		this.autorskiRecepti = autorskiRecepti;
		this.ocenjeniRecepti = ocenjeniRecepti;
		this.sastojci = sastojci;
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


	public void setOprema(ArrayList<Alat> oprema) {
		this.oprema = oprema;
	}
	
	public void dodajAlat(Alat a) {
		this.oprema.add(a);
	}
	
	public boolean izbrisiAlat(Alat a) {
		return this.oprema.remove(a);
	}

	public Osoba getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Osoba korisnik) {
		this.korisnik = korisnik;
	}

	public List<KorisnickiNalog> getNepromenljivePraceniKorisnici() {
		return Collections.unmodifiableList(praceniKorisnici);
	}

	public void setPraceniKorisnici(List<KorisnickiNalog> praceniKorisnici) {
		this.praceniKorisnici = praceniKorisnici;
	}
	
	public void dodajPracenogKorisnika(KorisnickiNalog kn) {
		kn.setBrPratioca(kn.getBrPratioca() + 1);
		this.praceniKorisnici.add(kn);
	}
	
	public boolean izbrisiPracenogKorisnika(KorisnickiNalog kn) {
		return this.praceniKorisnici.remove(kn);
	}

	public List<Kategorija> getNepromenljivePraceneKategorije() {
		return Collections.unmodifiableList(praceneKategorije);
	}

	public void setPraceneKategorije(List<Kategorija> praceneKategorije) {
		this.praceneKategorije = praceneKategorije;
	}
	
	public void dodajPracenuKategoriju(Kategorija k) {
		k.dodajPratioca(this);
		this.praceneKategorije.add(k);
	}
	
	public boolean izbrisiPracenuKategoriju(Kategorija k) {
		return this.praceneKategorije.remove(k);
	}

	public List<Recept> getNepromenljiviObelezeniRecepti() {
		return Collections.unmodifiableList(obelezeniRecepti);
	}

	public void setObelezeniRecepti(List<Recept> obelezeniRecepti) {
		this.obelezeniRecepti = obelezeniRecepti;
	}

	public void dodajObelezeniRecept(Recept r) {
		this.obelezeniRecepti.add(r);
	}
	
	public boolean izbrisiObelezeniRecept(Recept r) {
		return this.obelezeniRecepti.remove(r);
	}
	
	public List<Recept> getNepromenljiviAutorskiRecepti() {
		return Collections.unmodifiableList(autorskiRecepti);
	}

	public void setAutorskiRecepti(List<Recept> autorskiRecepti) {
		this.autorskiRecepti = autorskiRecepti;
	}

	public void dodajAutorskiRecept(Recept r) {
		this.autorskiRecepti.add(r);
	}
	
	//*** Trebalo bi dodati brisanje iz svih delova platforme ***
	public boolean izbrisiAutorskiRecept(Recept r) {
		return this.autorskiRecepti.remove(r);
	}
	
	public List<Ocena> getNepromenljiviOcenjeniRecepti() {
		return Collections.unmodifiableList(ocenjeniRecepti);
	}

	public void setOcenjeniRecepti(List<Ocena> ocenjeniRecepti) {
		this.ocenjeniRecepti = ocenjeniRecepti;
	}

	public void dodajOcenjeniRecept(Ocena o) {
		this.ocenjeniRecepti.add(o);
	}


	public void setSastojci(ArrayList<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}
	
	public void dodajSastojak(Sastojak s) {
		this.sastojci.add(s);
	}
	
	public boolean izbrisiSastojak(Sastojak s) {
		return this.sastojci.remove(s);
	}

	//*** promenaLozinke je zapravo samo set metoda
	
	//*** kreirajKategoriju i brisanjeProfila treba da bude u platformi, a ne ovde
	
	//*** ostaviRecenziju, odobriRecept
	
	//*** izmeniKomentar je samo kom.setTekst

	//*** Zasto je private u klasnom? *** I zasto postoje dve funkcije? ***
	public boolean izmenaRecepta(Recept r, String nazivRec, ArrayList<Alat> oprema, String opisPripreme, Tezina tezina, int duzinaMin, String imgPath,
			String videoLink, int brMedalja, KorisnickiNalog autor, Recenzija recenzija, List<Ocena> ocene,
			List<Kolicina> kolicineSastojaka, List<Kategorija> kategorije) {
		//provera da li su uneta sva obavezna polja
		if (nazivRec == "" || opisPripreme == "" || tezina == null || duzinaMin == 0 || kolicineSastojaka.isEmpty()) {
			return false;
		}
		
		//provera da li je ime jedinstveno medju autorskim receptima
		for (Recept ar : autorskiRecepti) {
			if (ar.getNazivRec().equals(nazivRec)) { 
				return false; 
			}
		}
		r.setNazivRec(nazivRec);
		r.setOpisPripreme(opisPripreme);
		r.setTezina(tezina);
		r.setDuzinaMin(duzinaMin);
		r.setKolicineSastojaka(kolicineSastojaka);
		
		if (!oprema.isEmpty()) {
			r.setOprema(oprema);
		}
		
		if (imgPath != "") {
			r.setImgPath(imgPath);
		}
		
		if (videoLink != "") {
			r.setVideoLink(videoLink);
		}
		
		if (brMedalja != 0) {
			r.setBrMedalja(brMedalja);
		}
		
		if (!kategorije.isEmpty()) {
			r.setKategorije(kategorije);
		}
		
		return true;
	}
		
	
	public boolean kreirajRecept(String nazivRec, ArrayList<Alat> oprema, String opisPripreme, Tezina tezina, int duzinaMin, String imgPath,
			String videoLink, int brMedalja, KorisnickiNalog autor, Recenzija recenzija, List<Ocena> ocene,
			List<Kolicina> kolicineSastojaka, List<Kategorija> kategorije) {
		//provera da li su uneta sva obavezna polja
		if (nazivRec == "" || opisPripreme == "" || tezina == null || duzinaMin == 0 || kolicineSastojaka.isEmpty()) {
			return false;
		}
		
		//provera da li je ime jedinstveno medju autorskim receptima
		for (Recept ar : autorskiRecepti) {
			if (ar.getNazivRec().equals(nazivRec)) { 
				return false; 
			}
		}
		Recept r = new Recept();
		r.setNazivRec(nazivRec);
		r.setOpisPripreme(opisPripreme);
		r.setAutor(this);
		r.setTezina(tezina);
		r.setDuzinaMin(duzinaMin);
		r.setKolicineSastojaka(kolicineSastojaka);
		
		if (!oprema.isEmpty()) {
			r.setOprema(oprema);
		}
		
		if (imgPath != "") {
			r.setImgPath(imgPath);
		}
		
		if (videoLink != "") {
			r.setVideoLink(videoLink);
		}
		
		if (brMedalja != 0) {
			r.setBrMedalja(brMedalja);
		}
		
		if (!kategorije.isEmpty()) {
			r.setKategorije(kategorije);
		}
		
		dodajAutorskiRecept(r);
		
		return true;
	}

	private Ocena pretraziOcene(Recept r) {
		for (Ocena o : ocenjeniRecepti) {
			if (o.getRecept() == r) {
				return o;
			}
		}
		return null;
	}
	
	public void svidjanjeRecepta(Recept r) {
		Ocena o = pretraziOcene(r);
		if (o == null) {
			o = new Ocena();
			o.setAutor(this);
			o.setRecept(r);
			o.setSvidjanje(true);
			ocenjeniRecepti.add(o);
		}
		else o.setSvidjanje(!o.isSvidjanje());
	}
	
	public void komentarisi(Recept r, String text) {
		Komentar k = new Komentar(text);
		Ocena o = pretraziOcene(r);
		if (o == null) {
			o = new Ocena();
			o.setAutor(this);
			o.setRecept(r);
			ocenjeniRecepti.add(o);
		}
		o.dodajKomentar(k);
		k.setOcena(o);
		r.dodajOcenu(o);
	}
	
	public void izmeniKomentar(String stari, String novi) {
		for (Ocena o : ocenjeniRecepti) {
			for (Komentar k1 : o.getKomentari()) {
				if (k1.getTekst().equals(stari)) {
					k1.setTekst(novi);
					return;
				}
			}
		}
	}
	
	public void obrisiKomentar(String text) {
		for (Ocena o : ocenjeniRecepti) {
			for (Komentar k1 : o.getKomentari()) {
				if (k1.getTekst().equals(text)) {
					ArrayList<Komentar> komentari = new ArrayList<Komentar>();
					for (Komentar k2 : o.getKomentari()) {
						komentari.add(k2);
					}
					komentari.remove(k1);
					o.setKomentari(komentari);
					return;
				}
			}
		}
	}
	
	public void oceniZvezde(Recept r, int brZvezdica) {
		Ocena o;
		o = pretraziOcene(r);
		if (o == null) {
			o = new Ocena();
			o.setAutor(this);
			o.setRecept(r);
			ocenjeniRecepti.add(o);
		}
		o.setZvezdice(brZvezdica);
	}
	
	public boolean zapratiKategoriju(Kategorija k) {
		if (-1 != praceneKategorije.indexOf(k)) {
			return false;
		}
		k.dodajPratioca(this);
		praceneKategorije.add(k);
		return true;
	}
	
	public boolean otpratiKategoriju(Kategorija k) {
		if (-1 == praceneKategorije.indexOf(k)) {
			return false;
		}
		k.izbrisiPratioca(this);
		praceneKategorije.remove(k);
		return true;
	}
	
	public boolean zapratiKuvara(KorisnickiNalog kuvar) {
		if (-1 != praceniKorisnici.indexOf(kuvar)) {
			return false;
		}
		kuvar.brPratioca += 1;
		praceniKorisnici.add(kuvar);
		return true;
	}
	
	public boolean otpratiKuvara(KorisnickiNalog kuvar) {
		if (-1 == praceniKorisnici.indexOf(kuvar)) {
			return false;
		}
		kuvar.brPratioca -= 1;
		praceniKorisnici.remove(kuvar);
		return true;
	}

	public ArrayList<Alat> getOprema() {
		return oprema;
	}

	public List<KorisnickiNalog> getPraceniKorisnici() {
		return praceniKorisnici;
	}

	public List<Kategorija> getPraceneKategorije() {
		return praceneKategorije;
	}

	public List<Recept> getObelezeniRecepti() {
		return obelezeniRecepti;
	}

	public List<Recept> getAutorskiRecepti() {
		return autorskiRecepti;
	}

	public List<Ocena> getOcenjeniRecepti() {
		return ocenjeniRecepti;
	}

	public ArrayList<Sastojak> getSastojci() {
		return sastojci;
	}
	
	
}

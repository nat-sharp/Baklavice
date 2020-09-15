package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PlatformaZaKuvare {
	private List<Sastojak>sastojci;
	private List<TopListaKreatora>topListaKreatora;
	private List<TopListaRecepata>topListaRecepata;
	private List<KorisnickiNalog> korisnickiNalog;
	private List<Osoba>osobe;
	private List<Recept>receptiNaCekanju;
	private List<Recept>recepti;
	private List<Kategorija>kategorije;
	
	
	
	private PlatformaZaKuvare() {
		this.sastojci = new ArrayList<Sastojak>();
		this.topListaKreatora = new ArrayList<TopListaKreatora>();
		this.topListaRecepata = new ArrayList<TopListaRecepata>();
		this.korisnickiNalog = new ArrayList<KorisnickiNalog>();
		this.osobe = new ArrayList<Osoba>();
		this.receptiNaCekanju = new ArrayList<Recept>();
		this.recepti = new ArrayList<Recept>();
		this.kategorije = new ArrayList<Kategorija>();
	}
	
	public static PlatformaZaKuvare instance = null;


	public static PlatformaZaKuvare getInstance() {
		if(instance == null) {
			return new PlatformaZaKuvare();
		}
		return instance;
	}
	
	
	
	public List<Sastojak> getSastojci() {
		return Collections.unmodifiableList(sastojci);
	}
	public void setSastojci(List<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}
	public List<TopListaKreatora> getTopListaKreatora() {
		return Collections.unmodifiableList(topListaKreatora);
	}
	public void setTopListaKreatora(List<TopListaKreatora> topListaKreatora) {
		this.topListaKreatora = topListaKreatora;
	}
	public List<TopListaRecepata> getTopListaRecepata() {
		return Collections.unmodifiableList(topListaRecepata);
	}
	public void setTopListaRecepata(List<TopListaRecepata> topListaRecepata) {
		this.topListaRecepata = topListaRecepata;
	}
	public List<KorisnickiNalog> getKorisnickiNalog() {
		return Collections.unmodifiableList(korisnickiNalog);
	}
	public void setKorisnickiNalog(List<KorisnickiNalog> korisnickiNalog) {
		this.korisnickiNalog = korisnickiNalog;
	}
	public List<Osoba> getOsobe() {
		return Collections.unmodifiableList(osobe);
	}
	public void setOsobe(List<Osoba> osobe) {
		this.osobe = osobe;
	}
	public List<Recept> getReceptiNaCekanju() {
		return Collections.unmodifiableList(receptiNaCekanju);
	}
	public void setReceptiNaCekanju(List<Recept> receptiNaCekanju) {
		this.receptiNaCekanju = receptiNaCekanju;
	}
	public List<Recept> getRecepti() {
		return Collections.unmodifiableList(recepti);
	}
	public void setRecepti(List<Recept> recepti) {
		this.recepti = recepti;
	}
	public List<Kategorija> getKategorija() {
		return Collections.unmodifiableList(kategorije);
	}
	public void setKategorija(List<Kategorija> kategorija) {
		this.kategorije = kategorija;
	}
	
	
	//DODAJ/IZBRISI
	public void dodajSastojak(Sastojak sastojak) {
		this.sastojci.add(sastojak);
	}
	public boolean izbrisiSastojak(Sastojak sastojak) {
		if(!this.sastojci.contains(sastojak)) {
			return false;
		}
		this.sastojci.remove(sastojak);
		return true;
	}
	
	
	
	public void dodajTopListuKreatora(TopListaKreatora lista) {
		this.topListaKreatora.add(lista);
	}
	public boolean izbrisiTopListuKreatora(TopListaKreatora lista) {
		if(!this.topListaKreatora.contains(lista)) {
			return false;
		}
		this.topListaKreatora.remove(lista);
		return true;
	}
	
	
	public void dodajTopListuRecepata(TopListaRecepata lista) {
		this.topListaRecepata.add(lista);
	}
	public boolean izbrisiTopListuRecepata(TopListaRecepata lista) {
		if(!this.topListaRecepata.contains(lista)) {
			return false;
		}
		this.topListaRecepata.remove(lista);
		return true;
	}
	
	
	
	public void dodajKorisnickiNalog(KorisnickiNalog kNalog) {
		this.korisnickiNalog.add(kNalog);
	}
	public boolean izbrisiKorisnickiNalog(KorisnickiNalog kNalog) {
		if(!this.korisnickiNalog.contains(kNalog)) {
			return false;
		}
		this.korisnickiNalog.remove(kNalog);
		kNalog.getKorisnik().getKorNalozi().remove(kNalog); //trebao bi ovdje biti korisnickiNalog;
		/*korisnicki nalog se pojavljuje u recenziji jos, recenzija se pojavljuje u receptima, sto bi znacilo 
		da trebamo izbrisati sve receznije napravljenen sa tog naloga
		*/
		for(Recept r : recepti) {
			if(r.getRecenzija().getModerator().equals(kNalog)) {
				r.getRecenzija().setModerator(null); //znaci trebala bi se postavitit recenzija na null i onda poslati na cekanje
			}
		}
		
		//korisnik kreator se koristi korisnickim nalogom
		//vidi kako je odradjen korisnik kreator, tj njegovo brisanje i zalijepi tu ili vidi u osobama
		return true;
	}
	
	
	
	//u kategoriji moras izbrisati taj recept takodje
	public void dodajRecept(Recept recept) {
		this.recepti.add(recept);
	}
	public boolean izbrisiRecept(Recept recept) {
		if(!this.recepti.contains(recept)) {
			return false;
		}
		this.recepti.remove(recept);
		
		for(Kategorija k : kategorije) {
			if(k.getRecepti().contains(recept)) {
				k.getRecepti().remove(recept); //brisemo recepte iz date katerije
			}
		}

		/*
		for(Osoba o : osobe) {
			if(o instanceof KorisnikKreator) {
				KorisnikKreator kk = (KorisnikKreator)o;
				if(kk.getAutorskiRecepti().contains(recept)) {
					kk.getAutorskiRecepti().remove(recept);
				}
				if(kk.getObelezeniRecepti().contains(recept)) {
					kk.getObelezeniRecepti().remove(recept);
				}
				List<Ocena>klonirani = new ArrayList<Ocena>();
				for(Ocena oc : kk.getOcenjeniRecepti()) {
					if(!oc.getRecept().equals(recept)) {
						klonirani.add(oc);
					}
				}recept.getAutor().setOcenjeniRecepti(klonirani);
			}
		}*/
		
		
		for(KorisnickiNalog kn: korisnickiNalog) {
			if(kn.getAutorskiRecepti().contains(recept)) {
				kn.getAutorskiRecepti().remove(recept);
			}
			if(kn.getObelezeniRecepti().contains(recept)) {
				kn.getObelezeniRecepti().remove(recept);
			}
			ArrayList<Ocena>klonirani = new ArrayList<Ocena>();
			for(Ocena oc : kn.getOcenjeniRecepti()) {
				if(!oc.getRecept().equals(recept)) {
					klonirani.add(oc);
				}
			}recept.getAutor().setOcenjeniRecepti(klonirani);
		}
		
		
		//mislim da iz top liste recepata ne treba da brisemo, ne znam kako cemo ih prikazivati, mozda po datumima
		return true;
	}
	
	
	
	//mislim da se ovo ne treba nalaziiti nigdje drugo 
	public void dodajReceptNaCekanju(Recept recept) {
		receptiNaCekanju.add(recept);
	}
	public boolean izbrisiReceptNaCekanju(Recept recept) {
		if(!receptiNaCekanju.contains(recept)) {
			return false;
		}
		receptiNaCekanju.remove(recept);
		return true;
	}
	
	
	
	public void dodajOsobu(Osoba o) {
		osobe.add(o);
	}
	public boolean obrisiOsobu(Osoba o) {
		if(!osobe.contains(o)) {
			return false;
		}
		osobe.remove(o);
		//mislim da moramo obrisati i njegove korisnicke naloge ukoliko ima
		if(!o.getKorNalozi().isEmpty()) {
			for(KorisnickiNalog kn:o.getKorNalozi()) {
				izbrisiKorisnickiNalog(kn);
			}
		}	
		return true;
	}
	
	
	public void dodajKategoriju(Kategorija k) {
		kategorije.add(k);
	}
	public boolean obrisiKategoriju(Kategorija k) {
		if(!kategorije.contains(k)){
			return false;
		}
		//sad trebamo izbrisati kategorije iz njegovih pratilaca
		for(KorisnickiNalog kk: k.getPratioci()) {
			kk.getPraceneKategorije().remove(k);
		}
		
		for(Recept r: recepti) {
			if(r.getKategorije().contains(k)) {
				r.getKategorije().remove(k);
			}
		}
		
		return true;
	}
	
	//ako sam promasila sta ---> ZAPISI ISPOD!
	
	
	
	//ovo trebamo dodatno razraditi
	//generisanje top liste kreatora, na osnovu broja postavljenih recepata, komentara, nesto na taj fazon
	public TopListaKreatora generisanjeTLK(int brojBiranja) {
		HashMap<Integer, Double> mapa = new HashMap<Integer, Double>();
		
		for(KorisnickiNalog kk : korisnickiNalog) {
			int indeks = korisnickiNalog.indexOf(kk);
			double broj1 = kk.getBrPratioca() + kk.getPraceniKorisnici().size()/3 + kk.getPraceneKategorije().size()/0.3;
			broj1 += kk.getAutorskiRecepti().size()*2 + kk.getObelezeniRecepti().size() + kk.getOcenjeniRecepti().size() * 3;
			mapa.put(indeks, broj1);
		}
		
		
		
		//e sad trebamo naci max
		double max = Double.NEGATIVE_INFINITY;
		int indeks2 = 0;
		
		
		
		List<KorisnickiNalog>topLista = new ArrayList<KorisnickiNalog>();
		for(int j = 0; j<brojBiranja; j++) {
			for(int i = 0; i<mapa.size(); i++) {
				if(max<mapa.get(i)) {
					max = mapa.get(i);
					indeks2 = i;
				}
			}mapa.remove(indeks2);
			//ovdje bilo za medalje
			korisnickiNalog.get(indeks2).setBrMedalja(korisnickiNalog.get(indeks2).getBrMedalja()+1);
			topLista.add(korisnickiNalog.get(indeks2));
		}
		TopListaKreatora vrati = new TopListaKreatora(topLista);
		
		return vrati;
	}
	
	
	
	//generisanje top liste recepata
	//ovo bi trebalo na osnovu ocjena, mozda broja komentara nesto iskombinovati
	public TopListaRecepata generisanjeTLR(int brojBiranja) {
		HashMap<Integer, Double>mapa = new HashMap<Integer, Double>();
		
		for(Recept r :recepti) {
			int indeks = recepti.indexOf(r);
			int brZvjezdica = 0;
			int brOcjena = r.getOcene().size();
			int lajk = 0;
			int dislajk = 0;
			int komentari = 0;
			double oModeratora = r.getRecenzija().getOcena() * 45.43;
			for(Ocena o : r.getOcene()) {
				brZvjezdica += o.getZvezdice();
				if(o.isSvidjanje()) {
					lajk++;
				}else {
					dislajk++;
				}komentari+=o.getKomentari().size();
			}
			double finalnaSlika = brZvjezdica/brOcjena + lajk - dislajk + komentari +oModeratora;
			mapa.put(indeks, finalnaSlika);
		}
		
		//e sad trebamo naci max
		double max = Double.NEGATIVE_INFINITY;
		int indeks2 = 0;
		
		List<Recept>topLista = new ArrayList<Recept>();
		for(int j = 0; j<brojBiranja; j++) {
			for(int i = 0; i<mapa.size(); i++) {
				if(max<mapa.get(i)) {
					max = mapa.get(i);
					indeks2 = i;
				}
			}mapa.remove(indeks2);
			recepti.get(indeks2).setBrMedalja(recepti.get(indeks2).getBrMedalja()+1);
			topLista.add(recepti.get(indeks2));
		}
		TopListaRecepata vrati = new TopListaRecepata(topLista);
		return vrati;
		
	}
	
	
	/////////////////////////////////////////  PRETRAGE  ////////////////////////////////////////////////
	public List<Recept> pretraga(List<Alat>kuhinjskaOprema, String naziv, Tezina tezina, int duzina, List<Sastojak>sastojci){
		List<Recept> vrati = new ArrayList<Recept>();
		
		if(kuhinjskaOprema != null) {
			for(Recept r: recepti) {
				boolean imaSve = true;
				for(Alat a: r.getOprema()) {
					if(kuhinjskaOprema.contains(a)) {
						continue;
					}else {
						imaSve = false;
						break;
					}
				}if(imaSve == true) {
					if(!vrati.contains(r)) {
						vrati.add(r);
					}
				}
			}
		}
		
		
		
		if(!naziv.equals("")) {
			for(Recept r:recepti) {
				if(r.getNazivRec().equalsIgnoreCase(naziv)) {
					if(!vrati.contains(r)) {
						vrati.add(r);
					}
				}
			}
		}
		
		
		if(tezina != null) {
			for(Recept r:recepti) {
				if(r.getTezina().equals(tezina)) {
					if(!vrati.contains(r)) {
						vrati.add(r);
					}
				}
			}
		}
		
		
		
		if(duzina == 0) {
			for(Recept r:recepti) {
				if(r.getDuzinaMin()<=duzina) {
					if(!vrati.contains(r)) {
						vrati.add(r);
					}
				}
			}
		}
		
		
		//samo je fazon ako sadrzi recept sve sastojke navedene
		if(sastojci != null) {
			for(Recept r: recepti) {
				int imaSastojaka = sastojci.size();
				for(Sastojak s: sastojci) {
					for(Kolicina k : r.getKolicineSastojaka()) {
						if(s.equals(k.getSastojak())) {
							imaSastojaka--;
						}	
					}
				}if(imaSastojaka == 0) {
					if(!vrati.contains(r)) {
						vrati.add(r);
					}
				}	
			}			
		}
		
		return vrati;
	}	
}

package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Menadzeri.MenadzerKNaloga;
import Menadzeri.MenadzerRecepta;

public class PlatformaZaKuvare {
	
	private KorisnickiNalog ulogovaniKorisnik;
	
	private PlatformaZaKuvare() {
	}
	
	public static PlatformaZaKuvare instance = null;


	public static PlatformaZaKuvare getInstance() {
		if(instance == null) {
			instance = new PlatformaZaKuvare();
		}
		return instance;
	}
	
	public KorisnickiNalog getUlogovaniKorisnik() {
		return ulogovaniKorisnik;
	}
	public void setUlogovaniKorisnik(KorisnickiNalog ulogovaniKorisnik) {
		this.ulogovaniKorisnik = ulogovaniKorisnik;
	}

	//ovo trebamo dodatno razraditi
	//generisanje top liste kreatora, na osnovu broja postavljenih recepata, komentara, nesto na taj fazon
	public TopListaKreatora generisanjeTLK(int brojBiranja) {
		HashMap<Integer, Double> mapa = new HashMap<Integer, Double>();
		
		for(KorisnickiNalog kk : MenadzerKNaloga.getInstance().getKorNalozi()) {
			int indeks = MenadzerKNaloga.getInstance().getKorNalozi().indexOf(kk);
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
			MenadzerKNaloga.getInstance().getKorNalozi().get(indeks2).setBrMedalja(MenadzerKNaloga.getInstance().getKorNalozi().get(indeks2).getBrMedalja()+1);
			topLista.add(MenadzerKNaloga.getInstance().getKorNalozi().get(indeks2));
		}
		TopListaKreatora vrati = new TopListaKreatora(topLista);
		
		return vrati;
	}
	
	
	
	//generisanje top liste recepata
	//ovo bi trebalo na osnovu ocjena, mozda broja komentara nesto iskombinovati
	public TopListaRecepata generisanjeTLR(int brojBiranja) {
		HashMap<Integer, Double>mapa = new HashMap<Integer, Double>();
		ArrayList<Recept> recepti = (ArrayList<Recept>) MenadzerRecepta.getInstance().getRecepti();
		for(Recept r : recepti) {
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
		List<Recept> recepti = MenadzerRecepta.getInstance().getRecepti();
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
		
		
		
		
		int minDuz = 0;
		int maxDuz = 0;
		if(duzina == 1) {
			minDuz = 1;
			maxDuz = 15;
		}else if(duzina == 15) {
			minDuz = 15;
			maxDuz = 30;
		}else if(duzina == 30) {
			minDuz = 30;
			maxDuz = 45;
		}else if(duzina == 45) {
			minDuz = 45;
			maxDuz = 60;
		}else if(duzina == 60) {
			minDuz = 60;
			maxDuz = 1000;
		}
		if(duzina != 0) {
			for(Recept r:recepti) {
				if(r.getDuzinaMin()<=maxDuz && r.getDuzinaMin()>= minDuz) {
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
		
		return (ArrayList<Recept>) vrati;
	}	
}

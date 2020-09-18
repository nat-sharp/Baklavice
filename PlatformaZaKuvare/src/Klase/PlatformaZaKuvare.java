package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Menadzeri.MenadzerKNaloga;
import Menadzeri.MenadzerRecepta;

public class PlatformaZaKuvare {
	
	private KorisnickiNalog ulogovaniKorisnik;
	private List<Mesto> mesta;
	
	private PlatformaZaKuvare() {
		mesta = new ArrayList<Mesto>();
	}
	
	public static PlatformaZaKuvare instance = null;


	public static PlatformaZaKuvare getInstance() {
		if(instance == null) {
			instance = new PlatformaZaKuvare();
		}
		return instance;
	}

	public List<Mesto> getMesta() {
		return mesta;
	}

	public void setMesta(List<Mesto> mesta) {
		this.mesta = mesta;
	}
	
	public void dodajMesto(Mesto m) {
		this.mesta.add(m);
	}

	
	public KorisnickiNalog getUlogovaniKorisnik() {
		return ulogovaniKorisnik;
	}
	public void setUlogovaniKorisnik(KorisnickiNalog ulogovaniKorisnik) {
		this.ulogovaniKorisnik = ulogovaniKorisnik;
	}

	//ovo trebamo dodatno razraditi
	//generisanje top liste kreatora, na osnovu broja postavljenih recepata, komentara, nesto na taj fazon
	public void generisanjeTLK(int brojBiranja) {
		HashMap<Integer, Double> mapa = new HashMap<Integer, Double>();
		
		for(KorisnickiNalog kk : MenadzerKNaloga.getInstance().getKorNalozi()) {
			if(kk.getVrstaKorisnika() == Klase.TipKorisnika.MODERATOR) {
				continue;
			}
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
			for( Map.Entry<Integer, Double> e : mapa.entrySet()) {
				if(max < e.getValue()) {
					max = e.getValue();
					indeks2 = e.getKey();
				}
			}
			max = Double.NEGATIVE_INFINITY;
			mapa.remove(indeks2);
			MenadzerKNaloga.getInstance().getKorNalozi().get(indeks2).setBrMedalja(MenadzerKNaloga.getInstance().getKorNalozi().get(indeks2).getBrMedalja()+1);
			topLista.add(MenadzerKNaloga.getInstance().getKorNalozi().get(indeks2));
		}
		
		TopListaKreatora vrati = new TopListaKreatora(topLista);
		Menadzeri.MenadzerTLK.getInstance().dodajTopListuKreatora(vrati);
		
	}
	
	
	
	//generisanje top liste recepata
	//ovo bi trebalo na osnovu ocjena, mozda broja komentara nesto iskombinovati
	public void generisanjeTLR(int brojBiranja) {
		HashMap<Integer, Double>mapa = new HashMap<Integer, Double>();
		ArrayList<Recept> recepti = (ArrayList<Recept>) MenadzerRecepta.getInstance().getRecepti();
		int indeks;
		for(Recept r : recepti) {
			System.out.print(r.getNazivRec());
			indeks = recepti.indexOf(r);
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
			//System.out.println("INT " + indeks + " DOUBLE "+ finalnaSlika);
			mapa.put(indeks, finalnaSlika);
		}
		for( Map.Entry<Integer, Double> e : mapa.entrySet()) {
			System.out.println( "Poc" + e.getKey() + " INTEGER" + e.getValue() + "DOULBEEE");
		}
		//e sad trebamo naci max
		double max = Double.NEGATIVE_INFINITY;
		int indeks2 = 0;
		
		
	//	System.out.println("POCETNA" +mapa.size());
		List<Recept>topLista = new ArrayList<Recept>();
		for(int j = 0; j<brojBiranja; j++) {
		//	System.out.println("IZMEDJU " + mapa.size());
			for( Map.Entry<Integer, Double> e : mapa.entrySet()) {
				
				if(max < e.getValue()) {
					max = e.getValue();
					indeks2 = e.getKey();
					//System.out.println(indeks2 + " IND");
				}
				
				
			}
			max = Double.NEGATIVE_INFINITY;
		//	System.out.print(indeks2);
			mapa.remove(indeks2);
			
		//	System.out.println(mapa.size());
			recepti.get(indeks2).setBrMedalja(recepti.get(indeks2).getBrMedalja()+1);
			if(!topLista.contains(recepti.get(indeks2))) {
				topLista.add(recepti.get(indeks2));
			}
			
		}
		for (Recept r : topLista) {
			System.out.println("\n\nEEJ " + r.getNazivRec());
		}
		TopListaRecepata vrati = new TopListaRecepata(topLista);
		Menadzeri.MenadzerTLR.getInstance().dodajTopListuRecepata(vrati);
		
	}
	
	
	/////////////////////////////////////////  PRETRAGE  ////////////////////////////////////////////////
	public List<Recept> pretraga(List<Alat>kuhinjskaOprema, String naziv, Tezina tezina, int duzina, List<Sastojak>sastojci){
		ArrayList<Recept> vrati = new ArrayList<Recept>();
		ArrayList<Recept> recepti = MenadzerRecepta.getInstance().getRecepti();
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
				if(r.getDuzinaMin() >= minDuz && r.getDuzinaMin()<= maxDuz ) {
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

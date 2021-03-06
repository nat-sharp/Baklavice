package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.Kategorija;
import Klase.KorisnickiNalog;
import Klase.Recept;

public class MenadzerKategorija {
	//recept, korNalog, pzk
	public static MenadzerKategorija instanca;
	private List<Kategorija> kategorije;
	
	private MenadzerKategorija() {
		kategorije = new ArrayList<Kategorija>();
	}
	
	public static MenadzerKategorija getInstance() {
		if (instanca == null) {
			instanca = new MenadzerKategorija();
		}
		return instanca;
	}
	
	public List<Kategorija> getKategorije() {
		return kategorije;
	}

	public List<Kategorija> getNepromenljiveKategorije() {
		return Collections.unmodifiableList(kategorije);
	}
	
	public void setKategorije(List<Kategorija> k) {
		this.kategorije = k;
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
		
		for(Recept r : MenadzerRecepta.getInstance().getRecepti()) {
			if(r.getKategorije().contains(k)) {
				r.getKategorije().remove(k);
			}
		}
		kategorije.remove(k);
		return true;
	}
}

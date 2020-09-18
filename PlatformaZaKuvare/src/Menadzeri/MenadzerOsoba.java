package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.KorisnickiNalog;
import Klase.Osoba;

public class MenadzerOsoba {
	//PZK
	public Osoba NN = new Osoba("NN", "", null, null, null, null, new ArrayList<KorisnickiNalog>());
	public static MenadzerOsoba instanca;
	private List<Osoba> osobe;
	
	private MenadzerOsoba() {
		osobe = new ArrayList<Osoba>();
	}
	public static MenadzerOsoba getInstance() {
		if (instanca == null) {
			instanca = new MenadzerOsoba();
		}
		return instanca;
	}
	
	public List<Osoba> getOsobe() {
		return osobe;
	}
	public List<Osoba> getNepromenljiveOsobe() {
		return Collections.unmodifiableList(osobe);
	}
	public void setOsobe(List<Osoba> osobe) {
		this.osobe = osobe;
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
				MenadzerKNaloga.getInstance().izbrisiKorisnickiNalog(kn);
			}
		}	
		return true;
	}
}

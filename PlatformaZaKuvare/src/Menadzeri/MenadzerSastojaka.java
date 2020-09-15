package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.Sastojak;

public class MenadzerSastojaka {
	//sastojak, korNalog, PZK
	private static MenadzerSastojaka instanca;
	private List<Sastojak> sastojci;
	
	private MenadzerSastojaka() {
		sastojci = new ArrayList<Sastojak>();
	}
	public static MenadzerSastojaka getInstance() {
		if (instanca == null) {
			instanca = new MenadzerSastojaka();
		}
		return instanca;
	}
	
	public List<Sastojak> getSastojci() {
		return Collections.unmodifiableList(sastojci);
	}
	public void setSastojci(List<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}
	public void dodajSastojak(Sastojak s) {
		this.sastojci.add(s);
	}
	public boolean izbrisiSastojak(Sastojak s) {
		if(!this.sastojci.contains(s)) {
			return false;
		}
		this.sastojci.remove(s);
		return true;
	}
	
}

package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kategorija {
	private String nazivKat;
	private String opis;
	private List<KorisnickiNalog> pratioci;
	private List<Recept> recepti;
	
	public Kategorija(String nazivKategorije, String opis) {
		this.nazivKat = nazivKategorije;
		this.opis = opis;
		pratioci = new ArrayList<KorisnickiNalog>();
		recepti = new ArrayList<Recept>();
	}
	
	public Kategorija(String nazivKategorije, String opis, List<KorisnickiNalog> pratioci, List<Recept> recepti) {
		this.nazivKat = nazivKategorije;
		this.opis = opis;
		this.pratioci = pratioci;
		this.recepti = recepti;
	}
	
	public List<KorisnickiNalog> getNepromenljiviPratioci() {
		return Collections.unmodifiableList(pratioci);
	}
	
	public List<KorisnickiNalog> getPratioci() {
		return pratioci;
	}

	public void setPratioci(List<KorisnickiNalog> pratioci) {
		this.pratioci = pratioci;
	}

	public List<Recept> getNepromenljiviRecepti() {
		return Collections.unmodifiableList(recepti);
	}
	
	public List<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(List<Recept> recepti) {
		this.recepti = recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}

	public String getNazivKat() {
		return nazivKat;
	}
	
	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
		
	public void dodajPratioca(KorisnickiNalog k) {
		this.pratioci.add(k);
	}
	
	public boolean izbrisiPratioca(KorisnickiNalog k) {
		if(!this.pratioci.contains(k)) {
			return false;
		}
		this.pratioci.remove(k);
		return true;
	}
	
	public void dodajRecept(Recept recept) {
		this.recepti.add(recept);
	}
	
	public boolean izbrisiRecept(Recept recept) {
		if(!this.recepti.contains(recept)) {
			return false;
		}
		this.recepti.remove(recept);
		return true;
	}
}

package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sastojak {
	private String naziv;
	private List<Sastojak>zamjenski;
	private List<Kolicina>kolicine; //da bi znao u kojim se receptima nalazi

	public Sastojak() {
		naziv = "";
		zamjenski = new ArrayList<Sastojak>();
		kolicine = new ArrayList<Kolicina>();
	}
	public Sastojak(String naz) {
		naziv = naz;
		zamjenski = new ArrayList<Sastojak>();
		kolicine = new ArrayList<Kolicina>();
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Sastojak> getZamjenski() {
		return Collections.unmodifiableList(zamjenski);
	}
	public void setZamjenski(List<Sastojak> zamjenski) {
		this.zamjenski = zamjenski;
	}
	public List<Kolicina> getKolicine() {
		return Collections.unmodifiableList(kolicine);
	}
	public void setKolicine(List<Kolicina> kolicine) {
		this.kolicine = kolicine;
	}
	
	public void dodajKolicinu(Kolicina k) {
		kolicine.add(k);
	}
	public Boolean izbrisiKolicinu(Kolicina k) {
		return kolicine.remove(k);
	}
	public void dodajZamjenski(Sastojak s) {
		zamjenski.add(s);
	}
	public Boolean izbrisiZamjenski(Sastojak s) {
		return zamjenski.remove(s);
	}
	
	public ArrayList<Recept> getReceptiSastojka(){
		ArrayList<Recept> rec = new ArrayList<Recept>();
		for (Kolicina k : kolicine) {
			rec.add(k.getRecept());
		}
		return rec;
	}
	
	
	
}

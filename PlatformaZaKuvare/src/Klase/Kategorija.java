package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Kategorija {

	private String nazivKat;
	private String opis;
	private ArrayList<KorisnickiNalog> pratioci;	//veza 0..*
	private ArrayList<Recept> recepti;
	//primjer, pokusavati kod kucee :P
	private List<KorisnickiNalog>p;
	
	private Kategorija() {
		p = new ArrayList<KorisnickiNalog>();
	}
	public List<KorisnickiNalog> getP() {
		return Collections.unmodifiableList(p);
		//return (List<KorisnikKreator>) Collections.unmodifiableCollection(p);
		
	}
	//pravi svuda gdje imamo arraylist




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
	public ArrayList<KorisnickiNalog> getPratioci() {
		return pratioci;
	}
	public void setPratioci(ArrayList<KorisnickiNalog> pratioci) {
		this.pratioci = pratioci;
	}
	public ArrayList<Recept> getRecepti() {
		return recepti;
	}
	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}
	public void izbrisiRecept(Recept r) {}
	
	
	public void dodajPratioca(KorisnickiNalog k) {
		this.pratioci.add(k);
	}
	
	public boolean izbrisiPratioca(KorisnickiNalog k) {
		return false;
		//znaci provjeri da li postoji, ako postoji izbrisi i vrati true;
		//ako ne postoji, vrati false
	}
	
	//liste treba da imaju dodajElement, izbrisiElement, readOnly verzija
	
	
	
	
}

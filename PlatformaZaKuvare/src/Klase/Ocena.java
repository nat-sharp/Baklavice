package Klase;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ocena {
	
	private boolean svidjanje = false;
	private int zvezdice = 0;
	private List<Komentar> komentari;
	private KorisnickiNalog autor;
	private Recept recept;
		
	public boolean isSvidjanje() {
		return svidjanje;
	}
	public void setSvidjanje(boolean svidjanje) {
		this.svidjanje = svidjanje;
	}
	
	public int getZvezdice() {
		return zvezdice;
	}
	public void setZvezdice(int zvezdice) {
		this.zvezdice = zvezdice;
	}
	
	public KorisnickiNalog getAutor() {
		return autor;
	}
	public void setAutor(KorisnickiNalog autor) {
		this.autor = autor;
	}
	
	public Recept getRecept() {
		return recept;
	}
	public void setRecept(Recept recept) {
		this.recept = recept;
	}
	
	
	public List<Komentar> getKomentari() {
		return Collections.unmodifiableList(komentari);
	}
	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}
	public void dodajKomentar(Komentar kom) {
		this.komentari.add(kom);
	}
	public boolean izbrisiKomentar(Komentar kom) {
		return this.komentari.remove(kom);
	}
	
	public Ocena() {
		this.komentari = new ArrayList<Komentar>();
	}
	public Ocena(boolean svidja, int zvezdi, ArrayList<Komentar> komi, KorisnickiNalog kreator, Recept rec) {
		this.svidjanje = svidja;
		this.zvezdice = zvezdi;
		this.komentari = komi;
		this.autor = kreator;
		this.recept = rec;
	}
}

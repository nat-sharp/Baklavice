package Klase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Osoba {

	private String ime;
	private String prezime;
	private LocalDate datumRodjenja;
	private long brojTelefona;
	private Pol pol;
	private Mesto boraviste;	//posto je veza 1..1 ka mestu
	private List<KorisnickiNalog> korNalozi; //posto je veza 0..* ka korisnickom nalogu
	private PlatformaZaKuvare platforma;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public long getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(long brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	
	public Pol getPol() {
		return pol;
	}
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	public Mesto getBoraviste() {
		return boraviste;
	}
	public void setBoraviste(Mesto boraviste) {
		this.boraviste = boraviste;
	}
	
	public List<KorisnickiNalog> getKorNalozi() {
		return Collections.unmodifiableList(korNalozi);
	}
	public void setKorNalozi(ArrayList<KorisnickiNalog> korNalozi) {
		this.korNalozi = korNalozi;
	}
	
	public void dodajKorNalog(KorisnickiNalog novi) {
		korNalozi.add(novi);
	}
	public boolean izbrisiKorNalog(KorisnickiNalog stari) {
		return this.korNalozi.remove(stari);
	}
	
	public PlatformaZaKuvare getPlatforma() {
		return platforma;
	}
	public void setPlatforma(PlatformaZaKuvare platforma) {
		this.platforma = platforma;
	}
	
	public Osoba() {
		this.korNalozi = new ArrayList<KorisnickiNalog>();
		this.platforma = PlatformaZaKuvare.getInstance();
	}
	public Osoba(String i, String prz, LocalDate dat, long brT, Pol p, Mesto m, ArrayList<KorisnickiNalog> nal) {
		this.ime = i;
		this.prezime = prz;
		this.datumRodjenja = dat;
		this.brojTelefona = brT;
		this.pol = p;
		this.boraviste = m;
		this.korNalozi = nal;
		this.platforma = PlatformaZaKuvare.getInstance();
	}
	
}

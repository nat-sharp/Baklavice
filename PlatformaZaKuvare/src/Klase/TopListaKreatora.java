package Klase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Menadzeri.MenadzerKNaloga;
import Menadzeri.MenadzerRecepta;

public class TopListaKreatora {
	private LocalDate datum;
	private List<KorisnickiNalog>korisnici;
	
	public TopListaKreatora() {
		korisnici = new ArrayList<KorisnickiNalog>();
		datum = LocalDate.now();
	}
	public TopListaKreatora(List<KorisnickiNalog> kor) {
		korisnici = kor;
		datum = LocalDate.now();
	}
	
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public List<KorisnickiNalog> getKorisnici() {
		return Collections.unmodifiableList(korisnici);
	}
	public void setKorisnici(List<KorisnickiNalog> korisnici) {
		this.korisnici = korisnici;
	}
	//tostring, brisi , sadrzan
	public boolean sadrzan(KorisnickiNalog kn) {
		for(KorisnickiNalog k : korisnici) {
			if(k.equals(kn)) {
				return true;
			}
		}
		return false;
	}
	public boolean izbrisi(KorisnickiNalog kn) {
		int i = 0;
		for (KorisnickiNalog k : korisnici) {
			if (k.equals(kn)) break;
			i++;
		}
		if (i == korisnici.size()) return false;
		korisnici.remove(i);
		korisnici.add(i, MenadzerKNaloga.getInstance().NN);
		return true;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TOP LISTA KORISNIKA KREATORA\t\tDATUM: "+datum.toString()+ "\n\n");
		for(KorisnickiNalog kn : korisnici) {
			sb.append(korisnici.indexOf(kn)+1);
			sb.append("\t" + kn.getKorIme()+ "\n");
		}
		return sb.toString();
	}
	
}

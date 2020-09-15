package Klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenadzerKNaloga {
	
	public static MenadzerKNaloga instanca;
	private List<KorisnickiNalog> korNalozi;
	
	private MenadzerKNaloga() {
		korNalozi = new ArrayList<KorisnickiNalog>();
		//telo
	}
	public MenadzerKNaloga getInstance() {
		if (instanca == null) {
			instanca = new MenadzerKNaloga();
		}
		return instanca;
	}
	
	public List<KorisnickiNalog> getKorNalozi() {
		return Collections.unmodifiableList(korNalozi);
	}
	public void setKorNalozi(List<KorisnickiNalog> korNalozi) {
		this.korNalozi = korNalozi;
	}
	public void dodajNalog(KorisnickiNalog novi) {
		this.korNalozi.add(novi);
	}
	public boolean izbrisiKorisnickiNalog(KorisnickiNalog kNalog) {
		return true;
	}
}

package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.Kategorija;
import Klase.KorisnickiNalog;
import Klase.Recept;
import Klase.TipKorisnika;
import Klase.TopListaKreatora;

public class MenadzerKNaloga {
	//osoba, TLK, kategorija, korNalog, PZK
	public static MenadzerKNaloga instanca;
	private List<KorisnickiNalog> korNalozi;
	public KorisnickiNalog NN = new KorisnickiNalog("NN", "", TipKorisnika.NN, 0, 0,
			null, MenadzerOsoba.getInstance().NN, null, null, null, null, null, null);
	
	private MenadzerKNaloga() {
		korNalozi = new ArrayList<KorisnickiNalog>();
	}
	public static MenadzerKNaloga getInstance() {
		if (instanca == null) {
			instanca = new MenadzerKNaloga();
		}
		return instanca;
	}
	
	public List<KorisnickiNalog> getKorNalozi() {
		return korNalozi;
	}
	public List<KorisnickiNalog> getNepromenljiveKorNaloge() {
		return Collections.unmodifiableList(korNalozi);
	}
	public void setKorNalozi(List<KorisnickiNalog> korNalozi) {
		this.korNalozi = korNalozi;
	}
	public void dodajNalog(KorisnickiNalog novi) {
		this.korNalozi.add(novi);
	}
	public boolean izbrisiKorisnickiNalog(KorisnickiNalog kNalog) {
		if(!this.korNalozi.contains(kNalog)) {
			return false;
		}
		this.korNalozi.remove(kNalog);
		kNalog.getKorisnik().getKorNalozi().remove(kNalog); //trebao bi ovdje biti korisnickiNalog;
		/*korisnicki nalog se pojavljuje u recenziji jos, recenzija se pojavljuje u receptima, sto bi znacilo 
		da trebamo izbrisati sve receznije napravljenen sa tog naloga
		*/
		for(Recept r : MenadzerRecepta.getInstance().getRecepti()) {
			if(r.getRecenzija().getModerator().equals(kNalog)) {
				r.getRecenzija().setModerator(MenadzerKNaloga.getInstance().NN); //znaci trebala bi se postavitit recenzija na null i onda poslati na cekanje
			}
		}
		for (TopListaKreatora tlk : MenadzerTLK.getInstance().getTopListeKreatora()) {
			tlk.izbrisi(kNalog);
		}
		for(Kategorija l : MenadzerKategorija.getInstance().getKategorije()) l.izbrisiPratioca(kNalog);
		for (KorisnickiNalog kn : MenadzerKNaloga.getInstance().getKorNalozi()) kn.izbrisiPracenogKorisnika(kNalog);
		//korisnik kreator se koristi korisnickim nalogom
		//vidi kako je odradjen korisnik kreator, tj njegovo brisanje i zalijepi tu ili vidi u osobama
		return true;
	}
}

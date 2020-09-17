package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.Kategorija;
import Klase.KorisnickiNalog;
import Klase.Ocena;
import Klase.Recept;

public class MenadzerRecepta {
	//TLR, kategorija, recept*2, pzk*2
	private static MenadzerRecepta instanca;
	private List<Recept> receptiNaCekanju;
	private List<Recept> recepti;
	
	private MenadzerRecepta() {
		this.recepti = new ArrayList<Recept>();
		//telo
	}
	public static MenadzerRecepta getInstance() {
		if (instanca == null) instanca = new MenadzerRecepta();
		return instanca;
	}
	
	public List<Recept> getReceptiNaCekanju() {
		return receptiNaCekanju;
	}
	
	public List<Recept> getNepromenljiviReceptiNaCekanju() {
		return Collections.unmodifiableList(receptiNaCekanju);
	}
	
	public void setReceptiNaCekanju(List<Recept> r) {
		this.recepti = r;
	}
	
	public void dodajReceptNaCekanju(Recept novi) {
		this.receptiNaCekanju.add(novi);
	}
	
	public boolean izbrisiReceptNaCekanju(Recept recept) {
		if(!receptiNaCekanju.contains(recept)) {
			return false;
		}
		receptiNaCekanju.remove(recept);
		return true;
	}
	
	public List<Recept> getRecepti() {
		return recepti;
	}
	public List<Recept> getNepromenljiviRecepti() {
		return Collections.unmodifiableList(recepti);
	}
	
	public void setRecepti(List<Recept> recepti) {
		this.recepti = recepti;
	}
	
	public void dodajRecept(Recept novi) {
		this.recepti.add(novi);
	}
	
	public boolean izbrisiRecept(Recept recept) {
		if(!this.recepti.contains(recept)) {
			return false;
		}
		this.recepti.remove(recept);
		
		for(Kategorija k : MenadzerKategorija.getInstance().getKategorije()) {
			if(k.getRecepti().contains(recept)) {
				k.getRecepti().remove(recept); //brisemo recepte iz date katerije
			}
		}

		/*
		for(Osoba o : osobe) {
			if(o instanceof KorisnikKreator) {
				KorisnikKreator kk = (KorisnikKreator)o;
				if(kk.getAutorskiRecepti().contains(recept)) {
					kk.getAutorskiRecepti().remove(recept);
				}
				if(kk.getObelezeniRecepti().contains(recept)) {
					kk.getObelezeniRecepti().remove(recept);
				}
				List<Ocena>klonirani = new ArrayList<Ocena>();
				for(Ocena oc : kk.getOcenjeniRecepti()) {
					if(!oc.getRecept().equals(recept)) {
						klonirani.add(oc);
					}
				}recept.getAutor().setOcenjeniRecepti(klonirani);
			}
		}*/
		
		
		for(KorisnickiNalog kn: MenadzerKNaloga.getInstance().getKorNalozi()) {
			if(kn.getAutorskiRecepti().contains(recept)) {
				kn.getAutorskiRecepti().remove(recept);
			}
			if(kn.getObelezeniRecepti().contains(recept)) {
				kn.getObelezeniRecepti().remove(recept);
			}
			ArrayList<Ocena>klonirani = new ArrayList<Ocena>();
			for(Ocena oc : kn.getOcenjeniRecepti()) {
				if(!oc.getRecept().equals(recept)) {
					klonirani.add(oc);
				}
			}recept.getAutor().setOcenjeniRecepti(klonirani);
		}
		
		
		//mislim da iz top liste recepata ne treba da brisemo, ne znam kako cemo ih prikazivati, mozda po datumima
		return true;
	}
		public Recept getReceptByInfo(String naz, String korIme) {
		for (Recept r: recepti ) {
			if(r.getNazivRec().equals(naz) && r.getAutor().getKorIme().equals(korIme)) {
				return r;
			}
		}
		return null;
	}
	
}

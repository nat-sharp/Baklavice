package Klase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Menadzeri.MenadzerRecepta;

public class TopListaRecepata {
	private LocalDate datum;
	private List<Recept>recepti;

	public TopListaRecepata() {
		recepti = new ArrayList<Recept>();
		datum = LocalDate.now();
	}
	public TopListaRecepata(List<Recept> rec) {
		recepti = rec;
		datum = LocalDate.now();
	}
	
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public List<Recept> getRecepti() {
		return Collections.unmodifiableList(recepti);
	}
	//delete zbog brisanja recepata
	public Boolean sadrzan(Recept r) {
		for(Recept rec : recepti) {
			if(r.equals(rec)) {
				return true;
			}
		}
		return false;
	}
	public Boolean izbrisi(Recept reci) {
		int i = 0;
		for (Recept r : recepti) {
			if (r.equals(reci)) break;
			i++;
		}
		if (i == recepti.size()) return false;
		recepti.remove(i);
		recepti.add(i, MenadzerRecepta.getInstance().getNNRecept());
		return true;
	}

	public void setRecepti(List<Recept> recepti) {
		this.recepti = recepti;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TOP LISTA RECEPATA\t\tDATUM: "+datum.toString()+"\n\n");
		for (Recept r : recepti) {
			sb.append(recepti.indexOf(r)+1);
			sb.append("\t"+ r.getNazivRec() + "\t"+ "Autor:"+ r.getAutor().getKorIme()); //todo
			sb.append("\n");
		}
		return sb.toString();
	}
}

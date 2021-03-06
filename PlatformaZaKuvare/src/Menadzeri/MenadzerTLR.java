package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.Recept;
import Klase.TopListaRecepata;

public class MenadzerTLR {
	//PZK
	public static MenadzerTLR instanca;
	private List<TopListaRecepata> topListeRecepata;
	
	private MenadzerTLR() {
		topListeRecepata = new ArrayList<TopListaRecepata>();
	}
	public static MenadzerTLR getInstance() {
		if (instanca == null) {
			instanca = new MenadzerTLR();
		}
		return instanca;
	}
	
	public List<TopListaRecepata> getNeTopListeKreatora() {
		return Collections.unmodifiableList(topListeRecepata);
	}
	
	
	public List<TopListaRecepata> getTopListeRecepata() {
		return topListeRecepata;
	}
	
	public void setTopListeKreatora(ArrayList<TopListaRecepata> topListeR) {
		this.topListeRecepata = topListeR;
	}

	public void dodajTopListuRecepata(TopListaRecepata lista) {
		this.topListeRecepata.add(lista);
	}
	public boolean izbrisiTopListuRecepata(TopListaRecepata lista) {
		if(!this.topListeRecepata.contains(lista)) {
			return false;
		}
		this.topListeRecepata.remove(lista);
		return true;
	}
	
	
}

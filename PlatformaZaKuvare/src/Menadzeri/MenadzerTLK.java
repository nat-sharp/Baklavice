package Menadzeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Klase.TopListaKreatora;

public class MenadzerTLK {
	//PZK
	public static MenadzerTLK instanca;
	private List<TopListaKreatora> topListeKreatora;
	
	private MenadzerTLK() {
		topListeKreatora = new ArrayList<TopListaKreatora>();
		//tello
	}
	public static MenadzerTLK getInstance() {
		if (instanca == null) {
			instanca = new MenadzerTLK();
		}
		return instanca;
	}
	
	public List<TopListaKreatora> getTopListeKreatora() {
		return Collections.unmodifiableList(topListeKreatora);
	}
	public void setTopListeKreatora(ArrayList<TopListaKreatora> topListeKreatora) {
		this.topListeKreatora = topListeKreatora;
	}

	public void dodajTopListuKreatora(TopListaKreatora lista) {
		this.topListeKreatora.add(lista);
	}
	public boolean izbrisiTopListuKreatora(TopListaKreatora lista) {
		if(!this.topListeKreatora.contains(lista)) {
			return false;
		}
		this.topListeKreatora.remove(lista);
		return true;
	}
	
}

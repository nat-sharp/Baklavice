package Klase;

public class Komentar {
	private String tekst;
	private Ocena ocena;
	private boolean aktivan = true;
	
	public Komentar() {
		tekst = "";
		aktivan = true;
	}
	public Komentar(String t) {
		tekst = t;
		aktivan = true;
	}
	
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public Ocena getOcena() {
		return ocena;
	}
	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}
	
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
}

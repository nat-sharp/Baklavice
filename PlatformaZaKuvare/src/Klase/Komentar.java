package Klase;

public class Komentar {
	private String tekst;
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
	
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
}

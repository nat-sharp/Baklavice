package Klase;

public class Mesto {
	
	private String naziv;
	private int pttBroj;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public int getPttBroj() {
		return pttBroj;
	}
	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}
	
	@Override
	public String toString() {
		return "" + pttBroj + ", " + naziv + "\n";
	}
	
}

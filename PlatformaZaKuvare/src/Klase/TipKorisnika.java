package Klase;

public enum TipKorisnika {
	
	KREATOR (1), ADMINISTRATOR(2), MODERATOR(3);
	int pol;
	
	private TipKorisnika() {}
	private TipKorisnika(int broj) {
		this.pol = broj;
	}
	
	private String[] opisi = {"Kreator", "Administrator", "Moderator"};
	
	@Override
	public String toString() {
		return opisi[this.ordinal()];
	}
	
}

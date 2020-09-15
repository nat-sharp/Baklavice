package Klase;

public enum TipKorisnika {
	
	KREATOR (1), ADMINISTRATOR(2), MODERATOR(3), NN(4);
	int pol;
	
	private TipKorisnika() {}
	private TipKorisnika(int broj) {
		this.pol = broj;
	}
	
	private String[] opisi = {"Kreator", "Administrator", "Moderator", "NN"};
	
	@Override
	public String toString() {
		return opisi[this.ordinal()];
	}
	
}

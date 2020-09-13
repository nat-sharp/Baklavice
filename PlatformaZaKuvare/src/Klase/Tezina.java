package Klase;

public enum Tezina {
	
	LAKO (1), SREDNJE(2), TESKO(3);
	int pol;
	
	private Tezina() {}
	private Tezina(int broj) {
		this.pol = broj;
	}
	
	private String[] opisi = {"Lako", "Srednje", "Tesko"};
	
	@Override
	public String toString() {
		return opisi[this.ordinal()];
	}
	
}

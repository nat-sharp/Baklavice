package Klase;

public enum Pol {
	
	MUSKI (1), ZENSKI(2);
	int pol;
	
	private Pol() {}
	private Pol(int broj) {
		this.pol = broj;
	}
	
	private String[] opisi = {"Muski", "Zenski"};
	
	
	@Override
	public String toString() {
		return opisi[this.ordinal()];
	}
	
}

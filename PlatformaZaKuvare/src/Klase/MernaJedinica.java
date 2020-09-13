package Klase;

public enum MernaJedinica {
	KG(0), G(1), MG(2), L(3), ML(4), PRSTOHVAT(5), KOMAD(6), PAKOVANJE(7), KASIKA(8), KASICICA(9), SOLJA(10), SOLJICA(11);

	private int jedinica;

	private MernaJedinica(int jedinica) {
		this.jedinica = jedinica;
	}
	
	
	private String[] jed = {"kg", "g", "mg", "l", "ml", "prstohvat", "komad", "pakovanje", "kasika", "kasicica", "solja", "soljica"};
	
	
	@Override
	public String toString() {
		return jed[this.ordinal()];
	}

}

package Klase;

public enum Alat {
	MIKSER(0), KALUP(1), BLENDER(2), SOKOVNIK(3), TOSTER(4), MIKROTALASNA(5);
	
	private int alat;

	private Alat(int alat) {
		this.alat = alat;
	}
	
	public int getAlat() {
		return alat;
	}
	public void setAlat(int alat) {
		this.alat = alat;
	}
	
	
	private String[] alati = {"Mikser", "Kalup", "Blender", "Sokovnik", "Toster", "Mikrotalasna"};
	
	
	@Override
	public String toString() {
		return alati[this.ordinal()];
	}
	
	
}

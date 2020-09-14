package Klase;

public class Recenzija {
	private int ocena = 1; 
	private KorisnickiNalog moderator;
	private Recept recept;
	
	public Recenzija() {
	}
	
	public Recenzija(int ocena, KorisnickiNalog moderator, Recept recept) {
		this.ocena = ocena;
		this.moderator = moderator;
		this.recept = recept;
	}

	public Recept getRecept() {
		return recept;
	}
	
	public void setRecept(Recept recept) {
		this.recept = recept;
	}
	
	public int getOcena() {
		return ocena;
	}
	
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	public KorisnickiNalog getModerator() {
		return moderator;
	}
	
	public void setModerator(KorisnickiNalog moderator) {
		this.moderator = moderator;
	}
}

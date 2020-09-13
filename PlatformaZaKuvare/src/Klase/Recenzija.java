package Klase;

public class Recenzija {
	private int ocena = 1; //ko da 1, kreten, sram ga bilo, svaki recept koji ima cokoladu u sebi, zasluzuje 5
	private KorisnickiNalog moderator; //ovo bi znacilo ko ju je napisao
	private Recept recept;
	
	
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
	
	
	public Recenzija(int ocena, KorisnickiNalog moderator) {
		super();
		this.ocena = ocena;
		this.moderator = moderator;
	}
	
	
	
	
}

package Klase;

public class Kolicina {
	private MernaJedinica mernaJedinica;
	private int kolicina;
	private boolean obavezan;
	private Sastojak sastojak;
	private Recept recept;
	
	
	public Kolicina(MernaJedinica mernaJedinica, int kolicina, boolean obavezan, Sastojak sastojak, Recept recept) {
		this.mernaJedinica = mernaJedinica;
		this.kolicina = kolicina;
		this.obavezan = obavezan;
		this.sastojak = sastojak;
		this.recept = recept;
	}
	
	
	public Sastojak getSastojak() {
		return sastojak;
	}
	public void setSastojak(Sastojak sastojak) {
		this.sastojak = sastojak;
	}
	public Recept getRecept() {
		return recept;
	}
	public void setRecept(Recept recept) {
		this.recept = recept;
	}
	public MernaJedinica getMernaJedinica() {
		return mernaJedinica;
	}
	public void setMernaJedinica(MernaJedinica mernaJedinica) {
		this.mernaJedinica = mernaJedinica;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public boolean isObavezan() {
		return obavezan;
	}
	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("          - " + kolicina + " " + mernaJedinica.toString() + " " + sastojak.getNaziv());
		if (!sastojak.getZamjenski().isEmpty()) {
			str.append(" (");
			for (Sastojak s : sastojak.getZamjenski()) {
				str.append(s.getNaziv());
				if (!s.equals(sastojak.getZamjenski().get(sastojak.getZamjenski().size() - 1))) {
					str.append(", ");
				}
			}
			str.append(")");
		}
		return str.toString();
	}
	
	
	
}

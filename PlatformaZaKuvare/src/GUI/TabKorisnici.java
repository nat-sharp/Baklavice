package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Klase.KorisnickiNalog;

public class TabKorisnici extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<KorisnickiNalog> korisnici;
	private String[] columnNames = {"Korisnicko ime", "Broj recepata", "Broj pratioca"};
	public TabKorisnici(List<KorisnickiNalog> korisnici) {
		this.korisnici = korisnici;
	}
	
	@Override
	public int getRowCount() {
		return this.korisnici.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		KorisnickiNalog kn = this.korisnici.get(rowIndex);
		switch(columnIndex) {
		case 0: return kn.getKorIme();
		case 1: return kn.getAutorskiRecepti().size();
		case 2: return kn.getBrPratioca();
		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}

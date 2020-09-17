package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Klase.Kategorija;
import Klase.KorisnickiNalog;

public class TabKategorije extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<Kategorija> kategorije;
	private String[] columnNames = {"Naziv", "Broj recepata", "Broj pratioca"};
	
	public TabKategorije(List<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
	@Override
	public int getRowCount() {
		return this.kategorije.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kategorija k = this.kategorije.get(rowIndex);
		switch(columnIndex) {
		case 0: return k.getNazivKat();
		case 1: return k.getNepromenljiviRecepti().size();
		case 2: return k.getPratioci().size();
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

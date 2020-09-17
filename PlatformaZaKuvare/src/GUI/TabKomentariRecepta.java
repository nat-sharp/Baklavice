package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Klase.Kategorija;
import Klase.Komentar;
import Klase.Ocena;
import Klase.Recept;

public class TabKomentariRecepta extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private List<Komentar> komentari;
	private String[] columnNames = {"Autor", "Tekst"};
	
	public TabKomentariRecepta(List<Komentar> k) {
		this.komentari = k;
	}
	
	@Override
	public int getRowCount() {
		return this.komentari.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Komentar k = this.komentari.get(rowIndex);
		switch(columnIndex) {
		case 0: return k.getOcena().getAutor().getKorIme();
		case 1: return k.getTekst();
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

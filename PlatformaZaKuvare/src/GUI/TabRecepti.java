package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Klase.Kategorija;
import Klase.Recept;

public class TabRecepti extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Recept> listaRecepata;
	private String[] columnNames = {"Naziv", "Autor", "Kategorija", "Vreme spremanja", "Tezina spremanja"};
	
	public TabRecepti(List<Recept> l) {
		this.listaRecepata = l;
	}
	
	@Override
	public int getRowCount() {
		return this.listaRecepata.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Recept r = this.listaRecepata.get(rowIndex);
		switch(columnIndex) {
		case 0: return r.getNazivRec();
		case 1: return r.getAutor().getKorIme();
		case 2:
			String str = "";
			for (Kategorija k: r.getKategorije()) {
				str+= k.getNazivKat() + " ";
			}
			return str;
		case 3: return r.getDuzinaMin();
		case 4: return r.getTezina().toString();
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

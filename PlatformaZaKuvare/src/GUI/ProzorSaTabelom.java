package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Klase.Recept;

public abstract class ProzorSaTabelom extends JFrame {
	
	private static final long serialVersionUID = 1L;
	protected JPanel pani;
	protected ArrayList<Recept> recepti;
	protected JTable tabela;

	public ProzorSaTabelom(ArrayList<Recept> receptiii) {
		setSize(600,600);
		this.recepti = receptiii;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("");
		
		pani = new JPanel(new GridLayout(1, 5));
		add(pani, BorderLayout.NORTH);
		
		TabRecepti tabR = new TabRecepti(recepti);
		tabela = new JTable(tabR);
		tabela.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(tabela);
		
		add(sp, BorderLayout.CENTER);
		setVisible(true);
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Klase.Kategorija;

public class PrikazKategorija extends JFrame {
	private JTable tabela;
	private JPanel panel;
	private JButton prikazi;

	public PrikazKategorija(List<Kategorija> kategorije) {
		setTitle("Zapraćene kategorije");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setLocationRelativeTo(null);
	
		TabKategorije tabK = new TabKategorije(kategorije);
		tabela = new JTable(tabK);
		tabela.setAutoCreateRowSorter(true);
		tabela.setRowSelectionInterval(0, 0);
		JScrollPane sp = new JScrollPane(tabela);
		add(sp);		
		
		prikazi = new JButton("Prikaži");
		panel = new JPanel(new GridLayout(1,3));
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(prikazi);
		this.add(panel, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
		this.setVisible(true);
		
		prikazi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tabela.getSelectedRow();
				ProfilKategorije p = new ProfilKategorije();	
			}
		});
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Klase.Komentar;
import Klase.KorisnickiNalog;
import Klase.Ocena;

public class ZapraceniKorisnici extends JFrame {
	private JTable tabela;
	private JPanel panel;
	private JButton prikazi;

	public ZapraceniKorisnici(KorisnickiNalog kn) {
		setTitle("Zapraceni korisnici");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setLocationRelativeTo(null);
	
		TabKorisnici tabK = new TabKorisnici(kn.getNepromenljivePraceniKorisnici());
		tabela = new JTable(tabK);
		tabela.setAutoCreateRowSorter(true);
		tabela.setRowSelectionInterval(0, 0);
		JScrollPane sp = new JScrollPane(tabela);
		add(sp);		
		
		prikazi = new JButton("Prikazi");
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
				ProfilZaPracenje p = new ProfilZaPracenje(kn.getPraceniKorisnici().get(row));	
			}
		});
	}
}

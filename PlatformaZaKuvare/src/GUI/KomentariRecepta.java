package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Klase.Komentar;
import Klase.Ocena;
import Klase.PlatformaZaKuvare;
import Klase.Recept;

public class KomentariRecepta extends JFrame {
	private JTable tabela;
	private JPanel panelStari;
	private JButton izmeni;
	private JButton izbrisi;
	private JPanel panelNovi;
	private JTextField tekst;
	private JButton posalji;
	
	public KomentariRecepta(Recept r) {
		setTitle("Komentari recepta - " + r.getNazivRec());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setLocationRelativeTo(null);
		
		panelStari = new JPanel(new FlowLayout());
		izmeni = new JButton("Izmeni");
		panelStari.add(izmeni);
		izbrisi = new JButton("Izbriši");
		panelStari.add(izbrisi);
		add(panelStari, BorderLayout.NORTH);

		ArrayList<Komentar> komentari = new ArrayList<Komentar>();
		for (Ocena o : r.getOcene()) {
			komentari.addAll(o.getKomentari());
		}
	
		TabKomentariRecepta tabKR = new TabKomentariRecepta(komentari);
		tabela = new JTable(tabKR);
		tabela.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(tabela);
		add(sp);
		
		panelNovi = new JPanel(new GridLayout(1, 2));
		tekst = new JTextField("Novi komentar...");
		posalji = new JButton("Pošalji");
		panelNovi.add(tekst);
		panelNovi.add(posalji);
		add(panelNovi, BorderLayout.SOUTH);
		
		izmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = KomentariRecepta.this.tabela.getSelectedRow();
				String korIme = (String)KomentariRecepta.this.tabela.getValueAt(red, 0);
				String prijavljeni = PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().getKorIme();
				if (!korIme.equals(prijavljeni)) { 
					JOptionPane.showMessageDialog(KomentariRecepta.this, "Ne možete izmeniti komentar koji nije Vaš!", "Greška", JOptionPane.ERROR_MESSAGE);
				} else {
					String stari = (String)KomentariRecepta.this.tabela.getValueAt(red, 1);
					String novi = JOptionPane.showInputDialog(KomentariRecepta.this, "", stari);
					PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().izmeniKomentar(stari, novi);
					KomentariRecepta.this.dispose();
					new KomentariRecepta(r);
				}
			}
		});
		
		izbrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = KomentariRecepta.this.tabela.getSelectedRow();
				String korIme = (String)KomentariRecepta.this.tabela.getValueAt(red, 0);
				String prijavljeni = PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().getKorIme();
				if (!korIme.equals(prijavljeni)) { 
					JOptionPane.showMessageDialog(KomentariRecepta.this, "Ne možete izbrisati komentar koji nije Vaš!", "Greška", JOptionPane.ERROR_MESSAGE);
				} else {
					int odgovor = JOptionPane.showConfirmDialog(KomentariRecepta.this, "Da li ste sigurni da želite izbrisati komentar?", "Izbriši komentar", JOptionPane.YES_NO_OPTION);
					if (odgovor == 0) {
						String komentar = (String)KomentariRecepta.this.tabela.getValueAt(red, 1);
						PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().obrisiKomentar(komentar);
						KomentariRecepta.this.dispose();
						new KomentariRecepta(r);
					}
				}
			}
		});
		
		tekst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tekst.setText("");	
			}
		});
		
		posalji.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().komentarisi(r, tekst.getText());
				tekst.setText("Novi komentar...");
				KomentariRecepta.this.dispose();
				new KomentariRecepta(r);
			}
		});
		
		setVisible(true);		
	}
}

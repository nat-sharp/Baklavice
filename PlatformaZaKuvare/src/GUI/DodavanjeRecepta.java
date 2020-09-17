package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.Kolicina;
import Klase.KorisnickiNalog;
import Klase.PlatformaZaKuvare;
import Klase.Recept;
import Klase.Sastojak;
import Menadzeri.MenadzerRecepta;

public class DodavanjeRecepta extends JFrame {

	private static final long serialVersionUID = 1L;
	private KorisnickiNalog kreator;
	private Recept recept;
	private KorisnickiNalog pomocniZaAlat;

	public DodavanjeRecepta() {
		this.kreator = PlatformaZaKuvare.getInstance().getUlogovaniKorisnik();
		this.recept = new Recept();
		this.recept.setAutor(this.kreator);
		this.pomocniZaAlat = new KorisnickiNalog();
		
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Izmena recepta");
		
		setLayout(new GridLayout(10, 2));
		add(new JLabel("   Korisnicko ime: " + this.kreator.getKorIme()));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(new JLabel("   Naziv recepta:"));
		JTextField ime = new JTextField(20);
		add(ime);
		
		add(new JLabel("   Obavezni sastojci:"), BorderLayout.WEST);
		JButton dugmeObSastojci = new JButton("Odabir");
		dugmeObSastojci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirKolicina(DodavanjeRecepta.this.recept, true, true, new ArrayList<Sastojak>());
			}
		});
		JPanel panObSastojci = new JPanel(new GridLayout(1, 2));
		panObSastojci.add(new JLabel());
		panObSastojci.add(dugmeObSastojci);
		add(panObSastojci);
		
		add(new JLabel("   Opcioni sastojci:"), BorderLayout.WEST);
		JButton dugmeOpSastojci = new JButton("Odabir");
		dugmeOpSastojci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Sastojak> lis = new ArrayList<Sastojak>();
				for (Kolicina k : DodavanjeRecepta.this.recept.getKolicineSastojaka()) lis.add(k.getSastojak());
				new OdabirKolicina(DodavanjeRecepta.this.recept, true, false, lis);
			}
		});
		JPanel panOpSastojci = new JPanel(new GridLayout(1, 2));
		panOpSastojci.add(dugmeOpSastojci);
		panOpSastojci.add(new JLabel());
		add(panOpSastojci);

		add(new JLabel("   Nacin pripreme:"), BorderLayout.WEST);
		JTextField priprema = new JTextField(20);
		add(priprema);

		add(new JLabel("   Kategorija:"), BorderLayout.WEST);
		JButton dugmeKat = new JButton("Odabir");
		dugmeKat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirKategorije(DodavanjeRecepta.this.recept, true);
			}
		});
		JPanel panKat = new JPanel(new GridLayout(1, 2));
		panKat.add(new JLabel());
		panKat.add(dugmeKat);
		add(panKat);

		add(new JLabel("   Potrebni alati:"), BorderLayout.WEST);
		JButton dugmeAlati = new JButton("Odabir");
		dugmeAlati.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirAlata(DodavanjeRecepta.this, DodavanjeRecepta.this.pomocniZaAlat);
			}
		});
		JPanel panAlat = new JPanel(new GridLayout(1, 2));
		panAlat.add(dugmeAlati);
		panAlat.add(new JLabel());
		add(panAlat);

		add(new JLabel("   Vreme pripreme (u minutima):"), BorderLayout.WEST);
		JTextField vreme = new JTextField(10);
		add(vreme);
		
		add(new JLabel());
		JPanel kraj = new JPanel(new GridLayout(1, 2));
		kraj.add(new JLabel());
		JButton sacuvaj = new JButton("Sacuvaj");
		sacuvaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!DodavanjeRecepta.this.recept.setNazivRec(ime.getText())) {
					JOptionPane.showMessageDialog(DodavanjeRecepta.this, "Odabali ste iskoriscen naziv recepta", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				else {
					DodavanjeRecepta.this.recept.setDuzinaMin(Integer.parseInt(vreme.getText()));
					DodavanjeRecepta.this.recept.setOpisPripreme(priprema.getText());
					DodavanjeRecepta.this.recept.setOprema(DodavanjeRecepta.this.pomocniZaAlat.getOprema());
//					video link i image link????
					MenadzerRecepta.getInstance().dodajReceptNaCekanju(DodavanjeRecepta.this.recept);
					DodavanjeRecepta.this.dispose();
				}
			}
		});
		kraj.add(sacuvaj);
		add(kraj);
		
		setVisible(true);
	}
	
}

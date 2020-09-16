package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.KorisnickiNalog;

public class RegistracijaKreatora extends JFrame {
	private KorisnickiNalog kn;
	private JTextField ime = new JTextField();
	private JTextField prezime = new JTextField();
	private JTextField datumRodjenja = new JTextField();
	private JTextField telefon = new JTextField();
	private JComboBox<Klase.Pol> pol;
	
	private JComboBox<Klase.Mesto> mesto; 
	
	private JTextField korisickoIme = new JTextField();
	private JTextField sifra = new JTextField();

	private JButton birajAlate;
	private JButton birajSastojke;
	
	private JPanel panel;
	
	private JPanel panelOK;
	private JButton ok;
	private JPanel panelOdustani;
	private JButton odustani;
	
	public RegistracijaKreatora() {
		this.kn = new KorisnickiNalog();
		this.pol = new JComboBox<Klase.Pol>();
		this.pol.addItem(Klase.Pol.MUSKI);
		this.pol.addItem(Klase.Pol.ZENSKI);
		
		this.mesto = new JComboBox<Klase.Mesto>();
		
		this.setTitle("Registracija korisnika kreatora");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700, 800);
		this.setLocationRelativeTo(null);		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(25, 2));
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Ime:"));
		panel.add(this.ime);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Prezime:"));
		panel.add(this.prezime);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Korisnicko ime:"));
		panel.add(this.korisickoIme);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Sifra:"));
		panel.add(this.sifra);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Datum rodjenja:"));
		panel.add(this.datumRodjenja);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Pol:"));
		panel.add(this.pol);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Telefon:"));
		panel.add(this.telefon);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Mesto:"));
		panel.add(this.mesto);
		
		this.birajAlate = new JButton("Biraj");
		this.birajSastojke = new JButton("Biraj");
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Alati:"));
		panel.add(this.birajAlate);
		
		panel.add(new JLabel());
		panel.add(new JLabel());		
		panel.add(new JLabel("                           Sastojci:"));
		panel.add(this.birajSastojke);
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		ok = new JButton("OK");

		panelOK = new JPanel();
		panelOK.setLayout(new GridLayout(1, 2));
		
		panelOK.add(new JLabel());
		panelOK.add(ok);
		
		panel.add(panelOK);
		
		odustani = new JButton("Odustani");

		panelOdustani = new JPanel();
		panelOdustani.setLayout(new GridLayout(1, 2));
		
		panelOdustani.add(odustani);
		panelOdustani.add(new JLabel());
		
		panel.add(panelOdustani);
		panel.add(new JLabel());
		
		this.add(panel);
	
		birajAlate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirAlata o = new OdabirAlata(RegistracijaKreatora.this, kn);				
			}
		});
		
		birajSastojke.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirSastojaka o = new OdabirSastojaka(RegistracijaKreatora.this, kn);			
			}
		});
		
		odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				GlavniProzor g = new GlavniProzor();			
			}
		});			
	
		setVisible(true);
	}
}

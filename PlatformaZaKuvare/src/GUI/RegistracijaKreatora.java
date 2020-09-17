package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.KorisnickiNalog;
import Klase.Osoba;
import Klase.Pol;
import Klase.TipKorisnika;
import Menadzeri.MenadzerKNaloga;

public class RegistracijaKreatora extends JFrame {
	
	private static final long serialVersionUID = -2504356391605407340L;
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
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistracijaKreatora.this.kraj();
			}
		});

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
				new OdabirAlata(RegistracijaKreatora.this, kn);				
			}
		});
		
		birajSastojke.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirSastojaka(RegistracijaKreatora.this, kn,null);
			}
		});
		
		odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GlavniProzor();			
			}
		});			
	
		setVisible(true);
	}
	
	private void kraj() {
		if (!MenadzerKNaloga.getInstance().proveraKorImena(korisickoIme.getText())) 
			JOptionPane.showMessageDialog(RegistracijaKreatora.this, "Korisnicko ime je zauzeto", "Greska", JOptionPane.ERROR_MESSAGE);
		else {
			if(!provjeraDatuma(datumRodjenja.getText())) {
				JOptionPane.showMessageDialog(RegistracijaKreatora.this, 
						  "Datum nije dobro unesen. Molim, izmenite ga. :)", "Greska", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String dijeloviDatuma[] = datumRodjenja.getText().split(Pattern.quote("-"));
				LocalDate ld = LocalDate.of(Integer.parseInt(dijeloviDatuma[2]), Integer.parseInt(dijeloviDatuma[1]), Integer.parseInt(dijeloviDatuma[0]));
				
				Klase.Mesto m = new Klase.Mesto(mesto.getSelectedItem().toString(), 12);
				Osoba o = new Osoba(ime.getText(), prezime.getText(), ld, telefon.getText(), (Pol) pol.getSelectedItem(), m, new ArrayList<KorisnickiNalog>());
				kn.setKorIme(korisickoIme.getText());
				kn.setKorisnik(o);
				kn.setLozinka(sifra.getText());
				kn.setVrstaKorisnika(TipKorisnika.KREATOR);
				kn.getKorisnik().dodajKorNalog(kn);
				
				MenadzerKNaloga.getInstance().dodajNalog(kn);	
				new ProfilKorisnika(kn);
				this.dispose();
			}			
		}
		
	}
	
	private boolean provjeraDatuma(String datum) {
		String dijeloviDatuma[] = datum.split(Pattern.quote("-"));
		try {
			LocalDate.of(Integer.parseInt(dijeloviDatuma[2]), Integer.parseInt(dijeloviDatuma[1]), Integer.parseInt(dijeloviDatuma[0]));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}

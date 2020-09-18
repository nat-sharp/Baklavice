package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.Alat;
import Klase.Kategorija;
import Klase.KorisnickiNalog;
import Klase.Mesto;
import Klase.Ocena;
import Klase.Osoba;
import Klase.PlatformaZaKuvare;
import Klase.Pol;
import Klase.Recept;
import Klase.Sastojak;
import Klase.TipKorisnika;

public class RegistracijaModeratora extends JFrame {
	private JTextField ime = new JTextField();
	private JTextField prezime = new JTextField();
	private JTextField datumRodjenja = new JTextField();
	private JTextField telefon = new JTextField();
	private JComboBox<Klase.Pol> pol;
	
	private JComboBox<Klase.Mesto> mesto; 
	Menadzeri.MenadzerKNaloga mkn = Menadzeri.MenadzerKNaloga.getInstance();
	
	private JTextField korisickoIme = new JTextField();
	private JTextField sifra = new JTextField();

	private JPanel panel;
	
	private JPanel panelOK;
	private JButton ok;
	
	
	
	
	public RegistracijaModeratora() {
		this.pol = new JComboBox<Klase.Pol>();
		this.pol.addItem(Klase.Pol.MUSKI);
		this.pol.addItem(Klase.Pol.ZENSKI);
		
		this.mesto = new JComboBox<Klase.Mesto>();
		
		this.setTitle("Registracija korisnika kreatora");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		

		this.mesto = new JComboBox<Klase.Mesto>();
		for(Mesto m : PlatformaZaKuvare.getInstance().getMesta()) mesto.addItem(m);
			
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(20, 2));
		
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
		
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		
		ok = new JButton("OK");
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kis = korisickoIme.getText().trim();
				String lozs = sifra.getText().trim();
				String imes = ime.getText().trim();
				String przs = prezime.getText().trim();
				String datums = datumRodjenja.getText().trim();
				//String pols = textField_5.getText().trim();
				Klase.Pol pols = (Pol) pol.getSelectedItem();
				String mjs = (String) mesto.getSelectedItem();
				String tels = telefon.getText().trim();
				
				
				
				//provjera korisnickog imena
				if(!provjeraKImena(kis, mkn)) {
					JOptionPane.showMessageDialog(RegistracijaModeratora.this, 
							  "Korisnicko ime postoji. Molim, izmenite ga. :)", "Greska", JOptionPane.ERROR_MESSAGE);
				}else {
					//provjera datuma
					if(!provjeraDatuma(datums)) {
						JOptionPane.showMessageDialog(RegistracijaModeratora.this, 
								  "Datum nije dobro unesen. Molim, izmenite ga. :)", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					else {
						LocalDate ld = LocalDate.parse(datums, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						
						
						Klase.Mesto m = new Klase.Mesto(mjs, 12);
						Osoba o = new Osoba(imes, przs, ld, tels, pols, m, new ArrayList<KorisnickiNalog>());
						Klase.KorisnickiNalog pp = new Klase.KorisnickiNalog(kis, lozs, Klase.TipKorisnika.MODERATOR, 0, 0, new ArrayList<Alat>(), 
								  o, new ArrayList<KorisnickiNalog>(),new ArrayList<Kategorija>(),
								 new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Ocena>(), new ArrayList<Sastojak>());
						pp.getKorisnik().getKorNalozi().add(pp);
						
						Menadzeri.MenadzerKNaloga.getInstance().dodajNalog(pp);		
						new ProfilModer(pp);
						RegistracijaModeratora.this.dispose();
					}
				}
			}
			
		
				 
		};
		panelOK = new JPanel();
		panelOK.setLayout(new GridLayout(1, 4));
		
		panelOK.add(ok);
		panelOK.add(new JLabel());
		panelOK.add(new JLabel());
		panelOK.add(new JLabel());
		
		
		panel.add(new JLabel());
		panel.add(panelOK);
		
		this.add(panel);
		
		
		this.setVisible(true);	
	};
	


	private boolean provjeraKImena(String ime, Menadzeri.MenadzerKNaloga mkn) {
		for(Klase.KorisnickiNalog kn : mkn.getKorNalozi()) {
			if(kn.getKorIme().equals(ime)){
				break;
			}
			return false;
		}
		return true;
	}
	
	
	
	private boolean provjeraDatuma(String datum) {
		String dijeloviDatuma[] = datum.split(Pattern.quote("-"));
		try {
			LocalDate.parse(datum, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate.of(Integer.parseInt(dijeloviDatuma[2]), Integer.parseInt(dijeloviDatuma[1]), Integer.parseInt(dijeloviDatuma[0]));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}

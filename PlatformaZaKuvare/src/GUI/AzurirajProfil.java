package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AzurirajProfil {
	JFrame frameA;
	private Image slika;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	
	Menadzeri.MenadzerKNaloga mkn = Menadzeri.MenadzerKNaloga.getInstance();
	
	public AzurirajProfil(Klase.KorisnickiNalog kn){
		frameA = new JFrame();
		frameA.setBounds(100, 100, 450, 694);
		frameA.setLocationRelativeTo(null);
		frameA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameA.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\person.png"));
		lblNewLabel_9.setBounds(149, 21,  140, 125);
		frameA.getContentPane().add(lblNewLabel_9);
		
		
		textField = new JTextField();
		textField.setText(kn.getKorIme());
		textField.setBounds(215, 150, 139, 20);
		frameA.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(kn.getLozinka());
		textField_1.setBounds(215, 190, 139, 20);
		frameA.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(kn.getKorisnik().getIme());
		textField_2.setBounds(215, 230, 139, 20);
		frameA.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(kn.getKorisnik().getPrezime());
		textField_3.setBounds(215, 270, 139, 20);
		frameA.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText(kn.getKorisnik().getDatumRodjenja().toString());
		textField_4.setBounds(215, 310, 139, 20);
		frameA.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText(kn.getKorisnik().getPol().toString());
		textField_5.setBounds(215, 350, 139, 20);
		frameA.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText(kn.getKorisnik().getBoraviste().toString());
		textField_6.setBounds(215, 390, 139, 20);
		frameA.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText(kn.getKorisnik().getBrojTelefona());
		textField_7.setBounds(215, 430, 139, 20);
		frameA.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Korisnicko ime");
		lblNewLabel_10.setBounds(83, 150, 79, 14);
		frameA.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Lozinka");
		lblNewLabel_11.setBounds(83, 190, 48, 14);
		frameA.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ime");
		lblNewLabel_12.setBounds(83, 230, 48, 14);
		frameA.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Prezime");
		lblNewLabel_13.setBounds(83, 270, 48, 14);
		frameA.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Datum rodjenja");
		lblNewLabel_14.setBounds(83, 310, 79, 14);
		frameA.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Pol");
		lblNewLabel_15.setBounds(83, 350, 48, 14);
		frameA.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Mjesto");
		lblNewLabel_16.setBounds(83, 390, 48, 14);
		frameA.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Telefon");
		lblNewLabel_17.setBounds(83, 430, 48, 14);
		frameA.getContentPane().add(lblNewLabel_17);
		
		
		JButton btnNewButton_3 = new JButton("Promjena alata");
		btnNewButton_3.setBounds(47, 521, 150, 23);
		frameA.getContentPane().add(btnNewButton_3);
		ActionListener pa = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirAlata o = new OdabirAlata(AzurirajProfil.this.frameA ,kn, kn.getOprema() );
			}
		};btnNewButton_3.addActionListener(pa);
		
		
		JButton btnNewButton_4 = new JButton("Promjena sastojaka");
		btnNewButton_4.setBounds(232, 521, 150, 23);
		frameA.getContentPane().add(btnNewButton_4);
		ActionListener ps = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirSastojaka o = new OdabirSastojaka(AzurirajProfil.this.frameA, kn, kn.getSastojci());
			}
		};btnNewButton_4.addActionListener(ps);
		
		
		
		
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.setBounds(241, 617, 89, 23);
		frameA.getContentPane().add(btnNewButton_5);
		ActionListener ok = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kis = textField.getText().trim();
				String lozs = textField_1.getText().trim();
				String imes = textField_2.getText().trim();
				String przs = textField_3.getText().trim();
				String datums = textField_4.getText().trim();
				String pols = textField_5.getText().trim();
				String mjs = textField_6.getText().trim();
				String tels = textField_7.getText().trim();
				
				
				
				//provjera korisnickog imena
				if(!provjeraKImena(kis, mkn)) {
					JOptionPane.showMessageDialog(frameA, 
							  "Korisnicko ime postoji. Molim, izmenite ga. :)", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				//provjera datuma
				if(!provjeraDatuma(datums)) {
					JOptionPane.showMessageDialog(frameA, 
							  "Datum nije dobro unesen. Molim, izmenite ga. :)", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				String dijeloviDatuma[] = datums.split(Pattern.quote("-"));
				LocalDate ld = LocalDate.of(Integer.parseInt(dijeloviDatuma[2]), Integer.parseInt(dijeloviDatuma[1]), Integer.parseInt(dijeloviDatuma[0]));
				
				//provjera pola
				if(!provjeraPola(pols)) {
					JOptionPane.showMessageDialog(frameA, 
							  "Nije unesen pravilan pol. Molim, izmenite ga (musko/zensko) :)", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				Klase.Pol p;
				if(pols.contains("z") || pols.contains("e")) {
					p = Klase.Pol.ZENSKI;
				}else{
					p = Klase.Pol.MUSKI;
				}
				
				Klase.Mesto m = new Klase.Mesto(mjs, kn.getKorisnik().getBoraviste().getPttBroj());
		
				kn.setKorIme(kis);
				kn.setLozinka(lozs);
				kn.getKorisnik().setIme(imes);
				kn.getKorisnik().setPrezime(przs);
				kn.getKorisnik().setBrojTelefona(tels);
				kn.getKorisnik().setBoraviste(m);
				kn.getKorisnik().setDatumRodjenja(ld);
				kn.getKorisnik().getKorNalozi().add(kn);
				kn.getKorisnik().setPol(p);
			}
		};btnNewButton_5.addActionListener(ok);
		
		
		
		
		JButton btnNewButton_6 = new JButton("Nazad");
		ActionListener nazad = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameA.dispose();
				ProfilKorisnika p = new ProfilKorisnika(kn);
			}
		};btnNewButton_6.addActionListener(nazad);
		btnNewButton_6.setBounds(339, 617, 89, 23);
		frameA.getContentPane().add(btnNewButton_6);
		
		
		
		frameA.setVisible(true);
	}
	
	
	
	
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
			LocalDate ld = LocalDate.of(Integer.parseInt(dijeloviDatuma[2]), Integer.parseInt(dijeloviDatuma[1]), Integer.parseInt(dijeloviDatuma[0]));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	private boolean provjeraPola(String pols) {
		if(pols.contains("z") || pols.contains("e")) {
			return true;
		}else if(pols.contains("m") || pols.contains("u")){
			return true;
		}else {
			return false;
		}
	}
}

package GUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.PlatformaZaKuvare;

import java.awt.BorderLayout;

public class ProfilModer {

	private JFrame frame;
	JLabel lblNewLabel;
	private Image slika;

	LocalDate lk = LocalDate.now();
	Klase.Mesto m = new Klase.Mesto("NS", 12);
	Klase.Osoba o = new Klase.Osoba("Ante", "Antic", lk, "123", Klase.Pol.MUSKI, m, null);
	//Klase.KorisnickiNalog kn = new Klase.KorisnickiNalog("Ante", "Antic", lk, "123", Klase.Pol.MUSKI, m, null);

	Klase.KorisnickiNalog kn = new Klase.KorisnickiNalog("ante22", "1234", Klase.TipKorisnika.MODERATOR, 22, 10, null, o, null, null, null, null, null,null);
	
	
	
	public ProfilModer(Klase.KorisnickiNalog kn) {
		initialize(kn);
	}

	
	private void initialize(Klase.KorisnickiNalog kn) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel();
		slika = new ImageIcon(getClass().getResource("person.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(slika));
		lblNewLabel.setBounds(145, 11, 140, 125);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Korisnicko ime ");
		lblNewLabel_1.setBounds(100, 153, 94, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(kn.getKorIme());
		lblNewLabel_2.setBounds(235, 153, 94, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ime  ");
		lblNewLabel_3.setBounds(100, 193, 94, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(kn.getKorisnik().getIme());
		lblNewLabel_4.setBounds(235, 193, 94, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prezime ");
		lblNewLabel_5.setBounds(100, 233, 94, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(kn.getKorisnik().getPrezime());
		lblNewLabel_6.setBounds(235, 233, 94, 18);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Datum rodjenja ");
		lblNewLabel_7.setBounds(100, 273, 94, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(kn.getKorisnik().getDatumRodjenja().toString());
		lblNewLabel_8.setBounds(235, 278, 94, 18);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Pol ");
		lblNewLabel_9.setBounds(100, 318, 94, 18);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(kn.getKorisnik().getPol().toString());
		lblNewLabel_10.setBounds(235, 318, 94, 18);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Telefon  ");
		lblNewLabel_11.setBounds(100, 348, 94, 18);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(kn.getKorisnik().getBrojTelefona());
		lblNewLabel_12.setBounds(235, 348, 94, 18);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Mjesto ");
		lblNewLabel_13.setBounds(100, 388, 94, 18);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(kn.getKorisnik().getBoraviste().getNaziv());
		lblNewLabel_14.setBounds(235, 388, 94, 18);
		frame.getContentPane().add(lblNewLabel_14);
		
		JButton btnNewButton = new JButton("Recepti na cekanju");
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				//PrikazRecepataNaCekanju p = new PrikazRecepataNaCekanju();
			}
		};
		btnNewButton.addActionListener(a);
		btnNewButton.setBounds(21, 462, 149, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Top lista korisnika");
		btnNewButton_1.setBounds(58, 513, 149, 23);
		ActionListener a1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(false);
				PlatformaZaKuvare.getInstance().getInstance().generisanjeTLK(3);
				JOptionPane.showMessageDialog(ProfilModer.this.frame, 
						  "Izgenerisali ste top listu korisnika. :)", "", JOptionPane.INFORMATION_MESSAGE);
			
			}
		};
		btnNewButton_1.addActionListener(a1);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		JButton btnNewButton_2 = new JButton("Top lista recepata");
		btnNewButton_2.setBounds(214, 513, 149, 23);
		ActionListener a2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(false);
				PlatformaZaKuvare.getInstance().generisanjeTLR(3);
				JOptionPane.showMessageDialog(ProfilModer.this.frame, 
						  "Izgenerisali ste top listu recepata. :)", "", JOptionPane.INFORMATION_MESSAGE);
			}
		};btnNewButton_2.addActionListener(a2);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		
		JButton btnNewButton_3 = new JButton("Pretraga");
		btnNewButton_3.setBounds(263, 462, 149, 23);
		ActionListener a3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PretragaProzor p = new PretragaProzor();
			}
		};btnNewButton_3.addActionListener(a3);
		frame.getContentPane().add(btnNewButton_3);
		
		
		
		
		
		JButton btnNewButton_4 = new JButton("Odjava");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Prijava p = new Prijava();
			}
		});
		btnNewButton_4.setBounds(168, 570, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		
		frame.setVisible(true);
		
	}
	
	

	
}

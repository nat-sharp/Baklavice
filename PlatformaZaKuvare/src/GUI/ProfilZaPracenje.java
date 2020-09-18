package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Klase.PlatformaZaKuvare;

public class ProfilZaPracenje  {
		JFrame frameZ;
		JLabel lblNewLabel;
		Image slika;
		
		Menadzeri.MenadzerKNaloga mkn = Menadzeri.MenadzerKNaloga.getInstance();
		/*
		LocalDate lk = LocalDate.now();
		Klase.Mesto m = new Klase.Mesto("NS", 12);
		Klase.Osoba o = new Klase.Osoba("Ante", "Antic", lk, "123", Klase.Pol.MUSKI, m, null);
		Klase.KorisnickiNalog kn = new Klase.KorisnickiNalog("ante22", "1234", Klase.TipKorisnika.MODERATOR, 22, 10, null, o, null, null, null, null, null,null);
		*/
		
		
	public ProfilZaPracenje(Klase.KorisnickiNalog kn){
		frameZ = new JFrame();
		frameZ.setBounds(100, 100, 450, 496);
		frameZ.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameZ.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(25, 25, 140, 125);
		slika = new ImageIcon(getClass().getResource("person.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(slika));
		frameZ.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(kn.getKorIme());;
		lblNewLabel_2.setBounds(265, 70, 89, 14);
		frameZ.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(kn.getKorisnik().getIme());
		lblNewLabel_3.setBounds(265, 110, 89, 14);
		frameZ.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(kn.getKorisnik().getPrezime());
		lblNewLabel_4.setBounds(265, 150, 89, 14);
		frameZ.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(kn.getKorisnik().getDatumRodjenja().toString());
		lblNewLabel_5.setBounds(265, 190, 103, 14);
		frameZ.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(kn.getKorisnik().getPol().toString());
		lblNewLabel_6.setBounds(265, 230, 89, 14);
		frameZ.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(kn.getKorisnik().getBoraviste().toString());
		lblNewLabel_7.setBounds(265, 270, 89, 14);
		frameZ.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(kn.getKorisnik().getBrojTelefona());
		lblNewLabel_8.setBounds(265, 310, 89, 14);
		frameZ.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Recepti");
		btnNewButton.setBounds(52, 146, 89, 23);
		frameZ.getContentPane().add(btnNewButton);
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AutorskiRecepti a = new AutorskiRecepti(kn);
			}
		};btnNewButton.addActionListener(a);
		
		
		
		JButton btnNewButton_1 = new JButton("Zaprati");
		btnNewButton_1.setBounds(245, 427, 89, 23);
		frameZ.getContentPane().add(btnNewButton_1);
		ActionListener a1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().zapratiKuvara(kn);
				JOptionPane.showMessageDialog(null, 
						  "Zapratili ste korisnika :)", "", JOptionPane.INFORMATION_MESSAGE);
			}
		};btnNewButton_1.addActionListener(a1);
		
		
		
		JButton btnNewButton_2 = new JButton("Otprati");
		btnNewButton_2.setBounds(339, 427, 89, 23);
		frameZ.getContentPane().add(btnNewButton_2);
		ActionListener a2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().otpratiKuvara(kn);
				JOptionPane.showMessageDialog(null, 
						  "Otpratili ste korisnika :)", "", JOptionPane.INFORMATION_MESSAGE);
			}
		};btnNewButton_2.addActionListener(a2);
		
		
		frameZ.setVisible(true);
	}
}

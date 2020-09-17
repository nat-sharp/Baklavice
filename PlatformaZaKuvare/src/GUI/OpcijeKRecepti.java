package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;

public class OpcijeKRecepti {

	private JFrame frame;
	Klase.KorisnickiNalog kn;

	Menadzeri.MenadzerKategorija mmk = Menadzeri.MenadzerKategorija.getInstance();
	public OpcijeKRecepti(Klase.KorisnickiNalog kn) {
		this.kn = kn;
		initialize(kn);
	}

	
	private void initialize(Klase.KorisnickiNalog kn) {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\knjiga.jpg"));
		lblNewLabel.setText("");
		lblNewLabel.setBounds(0, -35, 500, 500);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("Moji recepti");
		btnNewButton.setBounds(60, 120, 170, 30);
		frame.getContentPane().add(btnNewButton);
		ActionListener a1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AutorskiRecepti a = new AutorskiRecepti(kn);
			}
		};btnNewButton.addActionListener(a1);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Sacuvani recepti");
		btnNewButton_1.setBounds(270, 120, 170, 30);
		frame.getContentPane().add(btnNewButton_1);
		ActionListener a2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrikazObelezenihRecepata p = new PrikazObelezenihRecepata(kn);
			}
		};btnNewButton_1.addActionListener(a2);
		
		
		JButton btnNewButton_3 = new JButton("Dodaj recept");
		btnNewButton_3.setBounds(60, 320, 170, 30);
		frame.getContentPane().add(btnNewButton_3);
		ActionListener a3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DodavanjeRecepta d = new DodavanjeRecepta();
			}
		};btnNewButton_3.addActionListener(a3);
		
		
		
		JButton btnNewButton_5 = new JButton("Zapraceni korisnici");
		btnNewButton_5.setBounds(270, 220, 170, 30);
		frame.getContentPane().add(btnNewButton_5);
		ActionListener a4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//ZapraceniKorisnici k = new ZapraceniKorisnici(kn); otkome
			}
		};btnNewButton_5.addActionListener(a4);
		
		
		
		JButton btnNewButton_6 = new JButton("Nazad");
		btnNewButton_6.setBounds(390, 431, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		ActionListener a5 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ProfilKorisnika p = new ProfilKorisnika(kn);
			}
		};btnNewButton_6.addActionListener(a5);
		
		
		
		JButton btnNewButton_4 = new JButton("Pretraga");
		btnNewButton_4.setBounds(150, 20, 170, 30);
		frame.getContentPane().add(btnNewButton_4);
		ActionListener a6 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//natalija
			}
		};btnNewButton_4.addActionListener(a6);
		
		
		
		JButton btnNewButton_2 = new JButton("Zapracene kategorije");
		btnNewButton_2.setBounds(60, 220, 170, 30);
		frame.getContentPane().add(btnNewButton_2);
		ActionListener a8 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//ZapraceneKategorije z = new ZapraceneKategorije(kn);
			}
		};btnNewButton_2.addActionListener(a8);
		
		
		JButton btnNewButton_7 = new JButton("Zaprati kategoriju");
		btnNewButton_7.setBounds(270, 320, 170, 30);
		frame.getContentPane().add(btnNewButton_7);
		ActionListener a7 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//PrikazKategorije p = new PrikazKategorije(mmk.getKategorije());
			}
		};btnNewButton_7.addActionListener(a7);
		
		frame.setVisible(true);
	}
}

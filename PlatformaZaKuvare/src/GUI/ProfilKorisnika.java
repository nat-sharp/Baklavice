package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProfilKorisnika {

	private JFrame frame;
	JLabel lblNewLabel;
	private Image slika;
	
	
	LocalDate lk = LocalDate.now();
	Klase.Mesto m = new Klase.Mesto("NS", 12);
	Klase.Osoba o = new Klase.Osoba("Ante", "Antic", lk, "123", Klase.Pol.MUSKI, m, null);
	//Klase.KorisnickiNalog kn = new Klase.KorisnickiNalog("Ante", "Antic", lk, "123", Klase.Pol.MUSKI, m, null);

	Klase.KorisnickiNalog kn = new Klase.KorisnickiNalog("ante22", "1234", Klase.TipKorisnika.MODERATOR, 22, 10, null, o, null, null, null, null, null,null);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	
	

	public ProfilKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 741);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblNewLabel = new JLabel("New label");
		slika = new ImageIcon(getClass().getResource("person.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(slika));
		lblNewLabel.setBounds(145, 11, 139, 98);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Korisnicko ime ");
		lblNewLabel_1.setBounds(100, 133, 94, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(kn.getKorIme());
		lblNewLabel_2.setBounds(235, 133, 94, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ime  ");
		lblNewLabel_3.setBounds(100, 173, 94, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(kn.getKorisnik().getIme());
		lblNewLabel_4.setBounds(235, 173, 94, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prezime ");
		lblNewLabel_5.setBounds(100, 213, 94, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(kn.getKorisnik().getPrezime());
		lblNewLabel_6.setBounds(235, 213, 94, 18);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Datum rodjenja ");
		lblNewLabel_7.setBounds(100, 253, 94, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(kn.getKorisnik().getDatumRodjenja().toString());
		lblNewLabel_8.setBounds(235, 253, 94, 18);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Pol ");
		lblNewLabel_9.setBounds(100, 293, 94, 18);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(kn.getKorisnik().getPol().toString());
		lblNewLabel_10.setBounds(235, 293, 94, 18);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Telefon  ");
		lblNewLabel_11.setBounds(100, 333, 94, 18);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(kn.getKorisnik().getBrojTelefona());
		lblNewLabel_12.setBounds(235, 333, 94, 18);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Mjesto ");
		lblNewLabel_13.setBounds(100, 373, 94, 18);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(kn.getKorisnik().getBoraviste().getNaziv());
		lblNewLabel_14.setBounds(235, 373, 94, 18);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Alati");
		lblNewLabel_15.setBounds(100, 413, 48, 14);
		frame.getContentPane().add(lblNewLabel_15);
		
		JButton btnNewButton = new JButton("Alati");
		btnNewButton.setBounds(235, 413, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_16 = new JLabel("Sastojci");
		lblNewLabel_16.setBounds(100, 453, 48, 14);
		frame.getContentPane().add(lblNewLabel_16);
		
		JButton btnNewButton_1 = new JButton("Sastojci");
		btnNewButton_1.setBounds(235, 453, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pretraga recepata");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(31, 512, 163, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Top lista recepata");
		btnNewButton_3.setBounds(129, 547, 155, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Top lista korisnika");
		btnNewButton_4.setBounds(235, 585, 163, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Azuriraj");
		btnNewButton_5.setBounds(240, 672, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Obrisi");
		btnNewButton_6.setBounds(339, 672, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		
		frame.setVisible(true);
		
	}
	
	/*
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 25, 128, 102);
		slika = new ImageIcon(getClass().getResource("person.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(slika));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(kn.getKorIme());;
		lblNewLabel_2.setBounds(265, 70, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(kn.getKorisnik().getIme());
		lblNewLabel_3.setBounds(265, 110, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(kn.getKorisnik().getPrezime());
		lblNewLabel_4.setBounds(265, 150, 89, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(kn.getKorisnik().getDatumRodjenja().toString());
		lblNewLabel_5.setBounds(265, 190, 103, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(kn.getKorisnik().getPol().toString());
		lblNewLabel_6.setBounds(265, 230, 89, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(kn.getKorisnik().getBoraviste().toString());
		lblNewLabel_7.setBounds(265, 270, 89, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(kn.getKorisnik().getBrojTelefona());
		lblNewLabel_8.setBounds(265, 310, 89, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Recepti");
		btnNewButton.setBounds(52, 146, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Zaprati");
		btnNewButton_1.setBounds(245, 427, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nazad");
		btnNewButton_2.setBounds(339, 427, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		frame.setVisible(true);
	}
	*/
	/*
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(149, 21, 117, 96);
		slika = new ImageIcon(getClass().getResource("person.png")).getImage();
		lblNewLabel_9.setIcon(new ImageIcon(slika));
		frame.getContentPane().add(lblNewLabel_9);
		
		
		textField = new JTextField();
		textField.setText(kn.getKorIme());
		textField.setBounds(215, 150, 139, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(kn.getLozinka());
		textField_1.setBounds(215, 190, 139, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(kn.getKorisnik().getIme());
		textField_2.setBounds(215, 230, 139, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(kn.getKorisnik().getPrezime());
		textField_3.setBounds(215, 270, 139, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText(kn.getKorisnik().getDatumRodjenja().toString());
		textField_4.setBounds(215, 310, 139, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText(kn.getKorisnik().getPol().toString());
		textField_5.setBounds(215, 350, 139, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText(kn.getKorisnik().getBoraviste().toString());
		textField_6.setBounds(215, 390, 139, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText(kn.getKorisnik().getBrojTelefona());
		textField_7.setBounds(215, 430, 139, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Korisnicko ime");
		lblNewLabel_10.setBounds(83, 150, 79, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Lozinka");
		lblNewLabel_11.setBounds(83, 190, 48, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ime");
		lblNewLabel_12.setBounds(83, 230, 48, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Prezime");
		lblNewLabel_13.setBounds(83, 270, 48, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Datum rodjenja");
		lblNewLabel_14.setBounds(83, 310, 79, 14);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Pol");
		lblNewLabel_15.setBounds(83, 350, 48, 14);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Mjesto");
		lblNewLabel_16.setBounds(83, 390, 48, 14);
		frame.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Telefon");
		lblNewLabel_17.setBounds(83, 430, 48, 14);
		frame.getContentPane().add(lblNewLabel_17);
		
		JButton btnNewButton_3 = new JButton("Promjena alata");
		btnNewButton_3.setBounds(47, 521, 150, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Promjena sastojaka");
		btnNewButton_4.setBounds(232, 521, 150, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.setBounds(241, 617, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Nazad");
		btnNewButton_6.setBounds(339, 617, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		frame.setVisible(true);
		
	}*/
}

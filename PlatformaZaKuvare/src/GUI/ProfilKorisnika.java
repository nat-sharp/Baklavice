package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProfilKorisnika {
	private JFrame frame;
	JLabel lblNewLabel;
	Menadzeri.MenadzerKNaloga mkn = Menadzeri.MenadzerKNaloga.getInstance();
	Image slika;
	LocalDate lk = LocalDate.now();
	Klase.Mesto m = new Klase.Mesto("NS", 12);
	Klase.Osoba o = new Klase.Osoba("Ante", "Antic", lk, "123", Klase.Pol.MUSKI, m, null);
	Klase.KorisnickiNalog kn = new Klase.KorisnickiNalog("ante22", "1234", Klase.TipKorisnika.MODERATOR, 22, 10, null, o, null, null, null, null, null,null);
	
	
	public ProfilKorisnika() {
		initialize(kn);
	}
	
	public ProfilKorisnika(Klase.KorisnickiNalog kn) {	
		initialize(kn);
	}
	
	

	
	private void initialize(Klase.KorisnickiNalog kn) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 741);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Vas profil :)");
		
		
		lblNewLabel = new JLabel();
		slika = new ImageIcon(getClass().getResource("person.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(slika));
		lblNewLabel.setBounds(145, 11, 140, 125);
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
		
		
		
		//Dugme alati
		JLabel lblNewLabel_15 = new JLabel("Alati");
		lblNewLabel_15.setBounds(100, 413, 48, 14);
		frame.getContentPane().add(lblNewLabel_15);
		
		JButton btnNewButton = new JButton("Alati");
		btnNewButton.setBounds(235, 413, 89, 23);
		frame.getContentPane().add(btnNewButton);
		ActionListener alati = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrikaziAlate a = new PrikaziAlate(kn);
			}
		};btnNewButton.addActionListener(alati);
		
		
		
		
		JLabel lblNewLabel_16 = new JLabel("Sastojci");
		lblNewLabel_16.setBounds(100, 453, 48, 14);
		frame.getContentPane().add(lblNewLabel_16);
		
		JButton btnNewButton_1 = new JButton("Sastojci");
		btnNewButton_1.setBounds(235, 453, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		ActionListener sastojci = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrikazSastojaka a = new PrikazSastojaka(kn);
			}
		};btnNewButton_1.addActionListener(sastojci);
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("Rad sa receptima");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OpcijeKRecepti o = new OpcijeKRecepti(kn);
			}
		});
		btnNewButton_2.setBounds(31, 512, 163, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("Top lista recepata");
		btnNewButton_3.setBounds(129, 547, 155, 23);
		frame.getContentPane().add(btnNewButton_3);
		ActionListener tlr = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TLRFrejm t = new TLRFrejm(Menadzeri.MenadzerTLR.getInstance().getTopListeRecepata().get(-1));
			}
		};btnNewButton_3.addActionListener(tlr);
		
		
		
		
		
		JButton btnNewButton_4 = new JButton("Top lista korisnika");
		btnNewButton_4.setBounds(235, 585, 163, 23);
		frame.getContentPane().add(btnNewButton_4);
		ActionListener tlk = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TLKFrejm m = new TLKFrejm(Menadzeri.MenadzerTLK.getInstance().getTopListeKreatora().get(-1));
			}
		};btnNewButton_4.addActionListener(tlk);
		
		
		
		JButton btnNewButton_5 = new JButton("Azuriraj");
		btnNewButton_5.setBounds(240, 672, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		ActionListener azuriraj = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AzurirajProfil a = new AzurirajProfil(kn);
				
			}
		};btnNewButton_5.addActionListener(azuriraj);
		
		
		//obrisi rijeseno
		JButton btnNewButton_6 = new JButton("Obrisi");
		btnNewButton_6.setBounds(339, 672, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		ActionListener obrisi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean brisi = porukaZaBrisanje();
				if(brisi) {
					frame.dispose();
					//Odavde treba da se brise korisnicki nalog, ako je ovdje sve obuhvaceno, onda se iz svega brise
					mkn.izbrisiKorisnickiNalog(ProfilKorisnika.this.kn);
				}
			}
		};btnNewButton_6.addActionListener(obrisi);
		
		
		frame.setVisible(true);
		
	}
	
	
	
	private boolean porukaZaBrisanje() {
		int odgovor = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da zelite obrisati korisnicki nalog?", 
				"", JOptionPane.YES_NO_OPTION);
		if (odgovor == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}


	
	
}

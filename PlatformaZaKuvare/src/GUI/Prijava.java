package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prijava extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton prijavi = new JButton("Prijavi se");
	private JButton odustani = new JButton("Odustani");
	private JTextField korisnickoIme;
	private JTextField sifra;
	
	JPanel panel;
	JPanel panel2;
	
	
	private static Prijava instanca;
	public static Prijava getInstance() {
		if (instanca == null) {
			instanca = new Prijava();
		}
		return instanca;
	}
	
	
	
	
	public Prijava() {
		setTitle("Baklavice");
		setSize(500, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		korisnickoIme = new JTextField(10);
		sifra = new JTextField(15);
		
		GridLayout layout = new GridLayout(5, 2);
		setLayout(layout);
		
		
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(new JLabel("                     Korisnicko ime: "));
		add(korisnickoIme);
		add(new JLabel("                     Sifra:"));
		add(sifra);
		
		add(new JLabel(""));
		add(new JLabel(""));
		
		layout.setVgap(20);
		
		panel2 = new JPanel(new GridLayout(1, 2));
		panel2.add(prijavi);
		panel2.add(new JLabel(""));
		add(panel2);
		
		
		panel = new JPanel(new GridLayout(1, 2));
		panel.add(new JLabel(""));
		panel.add(odustani);
		add(panel);
		
		
		

		ActionListener listenerPrijavi = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = Prijava.this.korisnickoIme.getText().trim();
				String lozinka = Prijava.this.sifra.getText().trim();
				
				boolean flag = false;
				for(Klase.KorisnickiNalog kn :Menadzeri.MenadzerKNaloga.getInstance().getKorNalozi()) {
					if(kn.getKorIme().equalsIgnoreCase(korisnickoIme) && kn.getLozinka().equalsIgnoreCase(lozinka)) {
						Klase.PlatformaZaKuvare.getInstance().setUlogovaniKorisnik(kn);
						if(kn.getVrstaKorisnika().equals(Klase.TipKorisnika.KREATOR)) {
							flag = true;
							Prijava.this.dispose();
							ProfilKorisnika p = new ProfilKorisnika(kn);	
						}else {
							flag = true;
							Prijava.this.dispose();
							ProfilModer m = new ProfilModer(kn);
						}
					}
				}
				if(!flag) {
					JOptionPane.showMessageDialog(Prijava.this,
							  "Korisnicko ime ili lozinka ne postoji. :(", "Greska", JOptionPane.ERROR_MESSAGE);	
				}			 
			}
		}; prijavi.addActionListener(listenerPrijavi);
		
		
		
		
		ActionListener listenerOdustani = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				GlavniProzor g = new GlavniProzor();
			}
		}; odustani.addActionListener(listenerOdustani);
		
		
		
		setVisible(true);
		
	}

}

package GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistracijaModeratora extends JFrame {
	private JTextField ime = new JTextField();
	private JTextField prezime = new JTextField();
	private JTextField datumRodjenja = new JTextField();
	private JTextField telefon = new JTextField();
	private JComboBox<Klase.Pol> pol;
	
	private JComboBox<Klase.Mesto> mesto; 
	
	
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

		panelOK = new JPanel();
		panelOK.setLayout(new GridLayout(1, 4));
		
		panelOK.add(ok);
		panelOK.add(new JLabel());
		panelOK.add(new JLabel());
		panelOK.add(new JLabel());
		
		
		panel.add(new JLabel());
		panel.add(panelOK);
		
		this.add(panel);
		
		
		setVisible(true);
		
		
	}
	
	
}

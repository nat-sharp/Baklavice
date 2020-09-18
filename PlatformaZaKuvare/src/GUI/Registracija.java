package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registracija extends JFrame{

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
	
	
	
	
	private static Registracija instanca;
	public static Registracija getInstance() {
		if (instanca == null) {
			instanca = new Registracija();
		}
		return instanca;
	}
	
	
	
	public Registracija() {
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
				String korisnickoIme = Registracija.this.korisnickoIme.getText().trim();
				String lozinka = Registracija.this.sifra.getText().trim();
				
				/*U sustini sad nam treba neka baza podataka, mapa, lista, koja ce sadrzati sve te 
				 * ucesnike da provjerimo da li imamo lika sa korisnickim imenom i lozinkom istim 
				 * kao sto je uneseno*/
				
				
				
				//Ovo mozemo iskoristiti ukoliko je neko ukucao pogresnu lozinku ili korisnicko ime
				/*
				 * JOptionPane.showMessageDialog(Registracija.this, "Unijeli ste pogresnu lozinku!\n         Pokusajte ponovo!",
								"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				 *JOptionPane.showMessageDialog(Registracija.this, "Unijeli ste pogresno korisnicko ime!\n         Pokusajte ponovo!",
							"Obavestenje", JOptionPane.INFORMATION_MESSAGE); 
				 */
				
			}
		}; prijavi.addActionListener(listenerPrijavi);
		
		
		
		
		ActionListener listenerOdustani = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}; odustani.addActionListener(listenerOdustani);
		
		
		
		setVisible(true);
		
	}

}

package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.KorisnickiNalog;
import Klase.PlatformaZaKuvare;

public class DodavanjeRecepta extends JFrame {

	private static final long serialVersionUID = 1L;
	private KorisnickiNalog kreator;

	public DodavanjeRecepta() {
		this.kreator = PlatformaZaKuvare.getInstance().getUlogovaniKorisnik();
		
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Dodavanje recepta");
		
		setLayout(new GridLayout(10, 2));
		add(new JLabel("   Korisnicko ime: " + this.kreator.getKorIme()));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(new JLabel("   Naziv recepta:"));
		JTextField ime = new JTextField(20);
		add(ime);
		
		add(new JLabel("   Obavezni sastojci:"), BorderLayout.WEST);
		JButton dugmeObSastojci = new JButton("Odabir");
		dugmeObSastojci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel panObSastojci = new JPanel(new GridLayout(1, 2));
		panObSastojci.add(new JLabel());
		panObSastojci.add(dugmeObSastojci);
		add(panObSastojci);
		
		add(new JLabel("   Opcioni sastojci:"), BorderLayout.WEST);
		JButton dugmeOpSastojci = new JButton("Odabir");
		dugmeOpSastojci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel panOpSastojci = new JPanel(new GridLayout(1, 2));
		panOpSastojci.add(dugmeOpSastojci);
		panOpSastojci.add(new JLabel());
		add(panOpSastojci);

		add(new JLabel("   Nacin pripreme:"), BorderLayout.WEST);
		JTextField priprema = new JTextField(20);
		add(priprema);

		add(new JLabel("   Kategorija:"), BorderLayout.WEST);
		JButton dugmeKat = new JButton("Odabir");
		dugmeKat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel panKat = new JPanel(new GridLayout(1, 2));
		panKat.add(new JLabel());
		panKat.add(dugmeKat);
		add(panKat);

		add(new JLabel("   Potrebni alati:"), BorderLayout.WEST);
		JButton dugmeAlati = new JButton("Odabir");
		dugmeAlati.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel panAlat = new JPanel(new GridLayout(1, 2));
		panAlat.add(dugmeAlati);
		panAlat.add(new JLabel());
		add(panAlat);

		add(new JLabel("   Vreme pripreme (u minutima):"), BorderLayout.WEST);
		JTextField vreme = new JTextField(10);
		add(vreme);
		
		add(new JLabel());
		JPanel kraj = new JPanel(new GridLayout(1, 2));
		kraj.add(new JLabel());
		JButton sacuvaj = new JButton("Sauvaj");
		sacuvaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		kraj.add(sacuvaj);
		add(kraj);
		
		setVisible(true);
	}
	
}

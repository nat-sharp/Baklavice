package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GlavniProzor extends JFrame {
	private JButton prijava;
	private JButton registracija;
	private JButton pretraga;
	private JPanel panelDugmad;
	
	public GlavniProzor() {
		setTitle("Platforma za kuvare");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		JLabel background = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\bg.jpg"));
		add(background);
		background.setLayout(new GridLayout(3, 3));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}
		
		prijava = new JButton("Prijava");
		registracija = new JButton("Registracija");
		pretraga = new JButton("Pretraga");

		background.add(new JLabel());
		background.add(new JLabel());
		background.add(new JLabel());
		background.add(new JLabel());
		
		panelDugmad = new JPanel(new GridLayout(3, 1));
		panelDugmad.add(prijava);
		panelDugmad.add(registracija);
		panelDugmad.add(pretraga);
		background.add(panelDugmad);
		
		background.add(new JLabel());
		background.add(new JLabel());
		background.add(new JLabel());
		background.add(new JLabel());
		
		prijava.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GlavniProzor.this.dispose();
				Prijava p = new Prijava();			
			}
		});
		
		registracija.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GlavniProzor.this.dispose();
				RegistracijaKreatora rk = new RegistracijaKreatora();		
			}
		});

		pretraga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GlavniProzor.this.dispose();
				PretragaProzor p = new PretragaProzor();	
			}
		});
		
		setVisible(true);		
	}
}

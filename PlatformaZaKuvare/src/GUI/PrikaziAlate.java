package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrikaziAlate {

	private JFrame frame;
	Klase.KorisnickiNalog kn;

	public PrikaziAlate(Klase.KorisnickiNalog kn) {
		this.kn = kn;
		initialize(this.kn);
	}

	
	private void initialize(Klase.KorisnickiNalog kn) {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Odbrana projekta");
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\alati.jpg"));
		lblNewLabel.setBounds(-2, 0, 400, 311);
		frame.getContentPane().add(lblNewLabel);
		
		JList<Klase.Alat> list = new JList<Klase.Alat>();
		list.setBounds(70, 322, 234, 156);
		/*
		DefaultListModel<Klase.Alat> model = new DefaultListModel<Klase.Alat>();
		model.addAll(kn.getOprema());
		list.setModel(model);*/
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ProfilKorisnika p = new ProfilKorisnika(kn);
			}
		});
		btnNewButton.setBounds(289, 492, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}
}

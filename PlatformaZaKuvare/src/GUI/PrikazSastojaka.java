package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrikazSastojaka {

	private JFrame frame;
	Klase.KorisnickiNalog kn;
	
	public PrikazSastojaka(Klase.KorisnickiNalog kn) {
		this.kn = kn;
		initialize(kn);
	}

	private void initialize(Klase.KorisnickiNalog kn) {
		frame = new JFrame();
		frame.setBounds(100, 100, 414, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel =  new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\ingredients.png"));
		lblNewLabel.setBounds(0, 0, 400, 300);
		frame.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		/*
		DefaultListModel<Klase.Sastojak> model = new DefaultListModel<Klase.Sastojak>();
		model.addAll(kn.getSastojci());
		list.setModel(model);*/
		list.setBounds(0, 299, 402, 219);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ProfilKorisnika p = new ProfilKorisnika();
			}
		});
		btnNewButton.setBounds(303, 527, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}

}

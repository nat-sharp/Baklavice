package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Klase.KorisnickiNalog;
import Klase.Recept;

public class PrikazObelezenihRecepata extends ProzorSaTabelom {

	private static final long serialVersionUID = 1L;

	public PrikazObelezenihRecepata(KorisnickiNalog korisnik) {
		super((ArrayList<Recept>) korisnik.getObelezeniRecepti());
		setTitle("Obelezeni recepti korisnika " + korisnik.getKorIme());
		
		this.pani.setLayout(new GridLayout(1, 5));
		this.pani.add(new JLabel());
		this.pani.add(new JLabel());
		
		JButton dugmeIzbrisi = new JButton("Otprati");
		this.pani.add(dugmeIzbrisi);
		dugmeIzbrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = PrikazObelezenihRecepata.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = PrikazObelezenihRecepata.this.recepti.get(index);
					korisnik.izbrisiObelezeniRecept(rec);
					PrikazObelezenihRecepata.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(PrikazObelezenihRecepata.this, "Nije selektovan recept za otpracivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		this.pani.add(new JLabel());
		
		JButton dugmePristupi = new JButton("Prikazi");
		this.pani.add(dugmePristupi);
		dugmePristupi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = PrikazObelezenihRecepata.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = PrikazObelezenihRecepata.this.recepti.get(index);
					new ProzorRecepta(rec);
				}
				else {
					JOptionPane.showMessageDialog(PrikazObelezenihRecepata.this, "Nije selektovan recept za prikazivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Klase.PlatformaZaKuvare;
import Klase.Recept;
import Menadzeri.MenadzerRecepta;

public class PrikazRecepataNaCekanju extends ProzorSaTabelom {

	private static final long serialVersionUID = 1L;

	public PrikazRecepataNaCekanju() {
		super((ArrayList<Recept>) MenadzerRecepta.getInstance().getReceptiNaCekanju());
		this.pani.add(new JLabel());
		this.pani.add(new JLabel());
		setTitle("Recepti za recenziju");
		JButton dugmePristupi = new JButton("Recenzuj");
		this.pani.add(dugmePristupi);
		dugmePristupi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = PrikazRecepataNaCekanju.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = PrikazRecepataNaCekanju.this.recepti.get(index);
					new IzmenaRecepta(PlatformaZaKuvare.getInstance().getUlogovaniKorisnik(), rec);
				}
				else {
					JOptionPane.showMessageDialog(PrikazRecepataNaCekanju.this, "Nije selektovan recept za recenziju!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}

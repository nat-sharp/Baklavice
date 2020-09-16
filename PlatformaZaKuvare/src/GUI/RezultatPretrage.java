package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Klase.Recept;

public class RezultatPretrage extends ProzorSaTabelom {

	private static final long serialVersionUID = 1L;

	public RezultatPretrage(ArrayList<Recept> receptiii) {
		super(receptiii);
		this.pani.add(new JLabel());
		this.pani.add(new JLabel());
		setTitle("Rezultati pretrage");
		JButton dugmePristupi = new JButton("Prikazi");
		this.pani.add(dugmePristupi);
		dugmePristupi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = RezultatPretrage.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = RezultatPretrage.this.recepti.get(index);
					new ProzorRecepta(rec);
				}
				else {
					JOptionPane.showMessageDialog(RezultatPretrage.this, "Nije selektovan recept za prikazivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}

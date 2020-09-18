package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Klase.Kategorija;
import Klase.PlatformaZaKuvare;
import Klase.Recept;

public class ProfilKategorije extends ProzorSaTabelom {
	public ProfilKategorije(Kategorija k) {
		super((ArrayList<Recept>) k.getRecepti());
		
		setSize(600, 300);
		setTitle("Profil kategorije");
		
		pani.add(new JLabel("Naziv: " + k.getNazivKat()));
		pani.add(new JLabel("Opis: " + k.getOpis()));
		
		JButton otprati = new JButton("Otprati kategoriju");
		pani.add(otprati);
		
		JButton prikaz = new JButton("Prikaži recept");
		pani.add(prikaz);
		
		//*** NE RADI ***
		otprati.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				k.izbrisiPratioca(PlatformaZaKuvare.getInstance().getUlogovaniKorisnik());
				PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().otpratiKategoriju(k);
				ProfilKategorije.this.dispose();
				new ProfilKategorije(k);
			}
		});
		
		prikaz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = ProfilKategorije.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = ProfilKategorije.this.recepti.get(index);
					new ProzorRecepta(rec);
				}
				else {
					JOptionPane.showMessageDialog(ProfilKategorije.this, "Nije selektovan recept za prikazivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}

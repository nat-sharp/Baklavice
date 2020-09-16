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

public class AutorskiRecepti extends ProzorSaTabelom {

	private static final long serialVersionUID = 1L;

	public AutorskiRecepti(KorisnickiNalog korisnik) {
		super((ArrayList<Recept>) korisnik.getAutorskiRecepti());
		setTitle("Autorski recepti korisnika " + korisnik.getKorIme());
		
		this.pani.setLayout(new GridLayout(1, 6));
		JButton dugmeIzmeni = new JButton("Izmeni");
		this.pani.add(dugmeIzmeni);
		dugmeIzmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = AutorskiRecepti.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = AutorskiRecepti.this.recepti.get(index);
					//IZMENAAA
				}
				else {
					JOptionPane.showMessageDialog(AutorskiRecepti.this, "Nije selektovan recept za izmenu!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		this.pani.add(new JLabel());
		
		JButton dugmeIzbrisi = new JButton("Izbrisi");
		this.pani.add(dugmeIzbrisi);
		dugmeIzbrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = AutorskiRecepti.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = AutorskiRecepti.this.recepti.get(index);
					int odgovor = JOptionPane.showConfirmDialog(AutorskiRecepti.this, "Da li ste sigurni da zelite da izbrisete selektovani recept?", "Potvrda", JOptionPane.YES_NO_OPTION);
					if (odgovor == JOptionPane.YES_OPTION) {
						korisnik.izbrisiAutorskiRecept(rec);
						AutorskiRecepti.this.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(AutorskiRecepti.this, "Nije selektovan recept za brisanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		this.pani.add(new JLabel());
		
		JButton dugmePristupi = new JButton("Prikazi");
		this.pani.add(dugmePristupi);
		dugmePristupi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = AutorskiRecepti.this.tabela.getSelectedRow();
				if (index >= 0) {
					Recept rec = AutorskiRecepti.this.recepti.get(index);
					new ProzorRecepta(rec);
				}
				else {
					JOptionPane.showMessageDialog(AutorskiRecepti.this, "Nije selektovan recept za prikazivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}

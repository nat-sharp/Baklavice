package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Klase.Alat;
import Klase.Kategorija;
import Klase.Kolicina;
import Klase.Ocena;
import Klase.PlatformaZaKuvare;
import Klase.Recept;

public class ProzorRecepta extends JFrame {

	private static final long serialVersionUID = 1L;
	private Recept recept;
	private JLabel svidjanja;
	private JLabel prosecna;
	private int brojLajkova;
	private int brojZvezdica;
	private double zbirZvezdica;
	private boolean postojeZvezdice;
	private int staraZvezdica;
	
	public ProzorRecepta(Recept r) {
		this.staraZvezdica = 0;
		this.postojeZvezdice = false;
		this.brojLajkova = 0;
		this.brojZvezdica = 0;
		this.zbirZvezdica = 0.0;
		
		this.recept = r;
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Recept:");
		
		JPanel pani1 = new JPanel(new GridLayout(5, 2));
		JPanel pani2 = new JPanel(new GridLayout(5, 2));
		setLayout(new GridLayout(11, 1));
		
		JButton korisnik = new JButton(recept.getAutor().getKorIme());
		korisnik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProfilZaPracenje(ProzorRecepta.this.recept.getAutor());
			}
		});
		JPanel prvi = new JPanel(new GridLayout(2, 5));
		prvi.add(new JLabel("")); prvi.add(new JLabel("")); prvi.add(new JLabel(""));
		prvi.add(new JLabel("")); prvi.add(korisnik); prvi.add(new JLabel(""));
		add(prvi);
		
		add(new JLabel("     " + this.recept.getNazivRec()));
		pani1.add(new JLabel("        Obavezni sastojci:"));
		pani2.add(new JLabel("        Opcioni sastojci:"));
		pani1.add(new JLabel(""));
		pani2.add(new JLabel(""));
		for (Kolicina k : this.recept.getKolicineSastojaka()) {
			if (k.isObavezan()) pani1.add(new JLabel(k.toString()));
			else pani2.add(new JLabel(k.toString()));
		}
		add(pani1);
		add(pani2);
		add(new JLabel("     Nacin pripreme:\n          - " + recept.getOpisPripreme()));
		StringBuilder str = new StringBuilder(); str.append("   ");
		for (Kategorija k : recept.getKategorije()) str.append("@" + k.getNazivKat() + "   ");
		add(new JLabel(str.toString()));
		
		StringBuilder alatii = new StringBuilder(); alatii.append("     Potrebni alati: ");
		for (Alat a : recept.getOprema()) {
			alatii.append(a.toString());
			if (!a.equals(recept.getOprema().get(recept.getOprema().size() -1))) alatii.append(", ");
		}
		add(new JLabel(alatii.toString()));
		
		add(new JLabel("     Potrebno vreme: " + recept.getDuzinaMin() + " min."));
		add(new JLabel("     Tezina: " + recept.getTezina().toString()));
		
		JPanel pani3 = new JPanel(new GridLayout(1, 4));
		JButton dugmeLajk = new JButton("Svidja mi se");
		dugmeLajk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dugmeLajk.setEnabled(false);
				ProzorRecepta.this.brojLajkova++;
				ProzorRecepta.this.svidjanja.setText("   " + ProzorRecepta.this.brojLajkova + " svidjanja");
				PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().svidjanjeRecepta(ProzorRecepta.this.recept);
			}
		});
		pani3.add(dugmeLajk);
		JButton dugmeKom = new JButton("Komentari");
		dugmeKom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new KomentariRecepta(ProzorRecepta.this.recept);
			}
		});
		pani3.add(dugmeKom);
		
		JPanel panii1 = new JPanel(new GridLayout(1, 3));
		panii1.add(new JLabel("Ocena:"));
		JPanel panii2 = new JPanel(new GridLayout(1, 3));
		ButtonGroup ocenee = new ButtonGroup();
		JRadioButton oc1 = new JRadioButton("1"); ocenee.add(oc1); panii1.add(oc1);
		JRadioButton oc2 = new JRadioButton("2"); ocenee.add(oc2); panii1.add(oc2);
		JRadioButton oc3 = new JRadioButton("3"); ocenee.add(oc3); panii2.add(oc3);
		JRadioButton oc4 = new JRadioButton("4"); ocenee.add(oc4); panii2.add(oc4);
		JRadioButton oc5 = new JRadioButton("5"); ocenee.add(oc5); panii2.add(oc5);
		pani3.add(panii1); pani3.add(panii2);
		add(pani3);
		ActionListener akcijaZvezde = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ProzorRecepta.this.postojeZvezdice) {
					ProzorRecepta.this.zbirZvezdica -= ProzorRecepta.this.staraZvezdica;
					ProzorRecepta.this.brojZvezdica--;
				}
				ProzorRecepta.this.staraZvezdica = 1;
				ProzorRecepta.this.postojeZvezdice = true;
				if (oc2.isSelected()) ProzorRecepta.this.staraZvezdica = 2; 
				else if (oc3.isSelected()) ProzorRecepta.this.staraZvezdica = 3; 
				else if (oc4.isSelected()) ProzorRecepta.this.staraZvezdica = 4; 
				else if (oc5.isSelected()) ProzorRecepta.this.staraZvezdica = 5; 
				PlatformaZaKuvare.getInstance().getUlogovaniKorisnik().oceniZvezde(ProzorRecepta.this.recept, ProzorRecepta.this.staraZvezdica);
				ProzorRecepta.this.brojZvezdica++;
				ProzorRecepta.this.zbirZvezdica = ProzorRecepta.this.zbirZvezdica + ProzorRecepta.this.staraZvezdica;
				double prosek1 = 0;
				if (ProzorRecepta.this.brojZvezdica != 0) prosek1 = ProzorRecepta.this.zbirZvezdica/ProzorRecepta.this.brojZvezdica;
				ProzorRecepta.this.prosecna.setText("   Prosecna ocena: " + prosek1);
			}
		};
		oc1.addActionListener(akcijaZvezde); oc2.addActionListener(akcijaZvezde);
		oc3.addActionListener(akcijaZvezde); oc4.addActionListener(akcijaZvezde);
		oc5.addActionListener(akcijaZvezde);
		
		JPanel pani4 = new JPanel(new GridLayout(1, 4));
		int brojKom = 0;
		for (Ocena o : recept.getOcene()) {
			if (o.getZvezdice() != 0) {
				brojZvezdica++;
				zbirZvezdica += o.getZvezdice();
			}
			if (o.isSvidjanje()) brojLajkova++;
			if (!o.getKomentari().isEmpty()) brojKom += o.getKomentari().size();
		}
		svidjanja = new JLabel("   Svidjanja: " + brojLajkova);
		pani4.add(svidjanja);
		pani4.add(new JLabel("   Komentari: " + brojKom));
		double prosek = 0;
		if (brojZvezdica != 0) prosek = zbirZvezdica/brojZvezdica;
		prosecna = new JLabel("   Prosecna ocena: " + prosek);
		pani4.add(prosecna);
		pani4.add(new JLabel("   Strucna ocena: " + recept.getRecenzija().getOcena()));
		add(pani4);
		
		setVisible(true);
	}
}

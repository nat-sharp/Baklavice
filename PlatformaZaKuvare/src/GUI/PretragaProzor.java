package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Klase.Alat;
import Klase.Kategorija;
import Klase.PlatformaZaKuvare;
import Klase.Recept;
import Klase.Sastojak;
import Klase.Tezina;
import Menadzeri.MenadzerKategorija;

public class PretragaProzor extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel naslov;
	private JLabel l1;
	private JTextField e1 ;
	
	private JLabel l2;
	private ArrayList<JCheckBox> cbKategorije;
	
	private JLabel l3;
	private JButton odabirS;
	
	private JLabel l4;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JRadioButton r4;
	private JRadioButton r5;
	private JLabel l5;
	private JButton odabirA;
	private JLabel l6;
	private JButton btnPretrazi;
	private JLabel l7;
	private ButtonGroup grupa;
	ArrayList<Sastojak> sastojci;
	ArrayList<Alat> alati;
	
	public PretragaProzor() {
		this.alati = new ArrayList<Alat>();
		this.sastojci = new ArrayList<Sastojak>();
		
		this.setSize(600,600);
		this.setTitle("Pretraga");
		l1 = new JLabel("Naziv recepta: ");
		e1 = new JTextField();
		l2 = new JLabel("Birajte kategorije: ");
		cbKategorije = new ArrayList<JCheckBox>();
		l3 = new JLabel("Birajte sastojke: ");
		odabirS = new JButton("Odabir sastojaka");
		
		l4 = new JLabel("Birajte vreme pripreme u minutama: ");
		r1 = new JRadioButton("<15");
		r2 = new JRadioButton("15 do 30");
		r3 = new JRadioButton("30 do 45");
		r4 = new JRadioButton("45 do 60");
		r5 = new JRadioButton("60+");
		grupa = new ButtonGroup();
		grupa.add(r1);
		grupa.add(r2);
		grupa.add(r3);
		grupa.add(r4);
		grupa.add(r5);
		l5 = new JLabel("Birajte alate koje posedujete: ");
		odabirA = new JButton("Odabir alata");

		l6 = new JLabel("Birajte tezinu pripreme: ");

		JComboBox combo = new JComboBox(Tezina.values());
		btnPretrazi = new JButton("Pretrazi");
		
		naslov = new JLabel("PRETRAGA");
		JPanel prvi = new JPanel();
		prvi.add(new JLabel());
		prvi.add(naslov);
		prvi.add(new JLabel());
		this.add(prvi, BorderLayout.NORTH);
		
		JPanel pnl = new JPanel(new GridLayout(6,2));
		pnl.add(l1); //naziv
		pnl.add(e1);
		pnl.add(l2); //kategorije
		JPanel kat = new JPanel(new FlowLayout());
		for(Kategorija k : MenadzerKategorija.getInstance().getNepromenljiveKategorije()) {
			JCheckBox c = new JCheckBox(k.getNazivKat());
			cbKategorije.add(c);
			kat.add(c);
		}
		pnl.add(kat);
		
		pnl.add(l3); //sastojci
		pnl.add(odabirS);
		pnl.add(l4); //vreme pripreme
		JPanel prip = new JPanel();
		prip.add(r1);
		prip.add(r2);
		prip.add(r3);
		prip.add(r4);
		prip.add(r5);
		pnl.add(prip);
		
		pnl.add(l5);//alati
		pnl.add(odabirA);
		pnl.add(l6);//tezina
		pnl.add(combo);
		JPanel p = new JPanel(new GridLayout(1,3));
		p.add(new JLabel());
		p.add(btnPretrazi);
		p.add(new JLabel());
		
		this.add(pnl, BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
		this.setVisible(true);
		
		odabirS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirSastojaka o = new OdabirSastojaka(PretragaProzor.this, null);
			}
			
		});
		odabirA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirAlata oo = new OdabirAlata(PretragaProzor.this, null);
				
			}
			
		});
		
		
		btnPretrazi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tezina t = (Tezina) combo.getSelectedItem();
				ArrayList<Recept> rezultati = (ArrayList<Recept>) PlatformaZaKuvare.getInstance().pretraga(alati
						, e1.getText(), t, PretragaProzor.this.getMin(), sastojci);
				
				//prikazi listurezultata
			}
			
		});
	}

	private int getMin() {
		JRadioButton moj = (JRadioButton) this.grupa.getSelection();
		if(moj.equals(r1)) {
			return 1;
		}else if(moj.equals(r2)) {
			return 15;
		}else if(moj.equals(r3)) {
			return 30;
		}else if(moj.equals(r4)) {
			return 45;
		}else if(moj.equals(r5)) {
			return 60;
		}
		return 0;
	}

}

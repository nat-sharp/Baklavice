package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Klase.Kolicina;
import Klase.KorisnickiNalog;
import Klase.Recenzija;
import Klase.Recept;
import Klase.Sastojak;
import Klase.Tezina;
import Klase.TipKorisnika;
import Menadzeri.MenadzerRecepta;

public class IzmenaRecepta extends JFrame {

	private static final long serialVersionUID = 1L;
	private KorisnickiNalog korNalog;
	private Recept recept;
	private KorisnickiNalog pomocniZaAlat;

	public IzmenaRecepta(KorisnickiNalog kn, Recept r) {
		this.korNalog = kn;
		this.recept = r;
		
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Dodavanje recepta");
		
		setLayout(new GridLayout(12, 2));
		add(new JLabel("   Korisnicko ime: " + this.recept.getAutor().getKorIme()));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(new JLabel("   Naziv recepta:"));
		JTextField ime = new JTextField(20); ime.setText(this.recept.getNazivRec());
		add(ime);
		
		add(new JLabel("   Obavezni sastojci:"), BorderLayout.WEST);
		JButton dugmeObSastojci = new JButton("Odabir");
		dugmeObSastojci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirKolicina(IzmenaRecepta.this.recept, false, true, new ArrayList<Sastojak>());
			}
		});
		JPanel panObSastojci = new JPanel(new GridLayout(1, 2));
		panObSastojci.add(new JLabel());
		panObSastojci.add(dugmeObSastojci);
		add(panObSastojci);
		
		add(new JLabel("   Opcioni sastojci:"), BorderLayout.WEST);
		JButton dugmeOpSastojci = new JButton("Odabir");
		dugmeOpSastojci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Sastojak> lis = new ArrayList<Sastojak>();
				for (Kolicina k : IzmenaRecepta.this.recept.getKolicineSastojaka()) lis.add(k.getSastojak());
				new OdabirKolicina(IzmenaRecepta.this.recept, false, false, lis);
			}
		});
		JPanel panOpSastojci = new JPanel(new GridLayout(1, 2));
		panOpSastojci.add(dugmeOpSastojci);
		panOpSastojci.add(new JLabel());
		add(panOpSastojci);

		add(new JLabel("   Nacin pripreme:"), BorderLayout.WEST);
		JTextField priprema = new JTextField(20); priprema.setText(this.recept.getOpisPripreme());
		add(priprema);

		add(new JLabel("   Kategorija:"), BorderLayout.WEST);
		JButton dugmeKat = new JButton("Odabir");
		dugmeKat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirKategorije(IzmenaRecepta.this.recept, false);
			}
		});
		JPanel panKat = new JPanel(new GridLayout(1, 2));
		panKat.add(new JLabel());
		panKat.add(dugmeKat);
		add(panKat);

		add(new JLabel("   Potrebni alati:"), BorderLayout.WEST);
		JButton dugmeAlati = new JButton("Odabir");
		dugmeAlati.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdabirAlata(IzmenaRecepta.this, IzmenaRecepta.this.pomocniZaAlat);
				
			}
		});
		JPanel panAlat = new JPanel(new GridLayout(1, 2));
		panAlat.add(dugmeAlati);
		panAlat.add(new JLabel());
		add(panAlat);

		add(new JLabel("   Vreme pripreme (u minutima):"), BorderLayout.WEST);
		JTextField vreme = new JTextField(10); vreme.setText(this.recept.getDuzinaMin() + "");
		add(vreme);
		
		add(new JLabel("   Tezina recepta:"));
		JPanel tezina = new JPanel(new GridLayout(1, 2));
		JComboBox<Tezina> ponudjeni = new JComboBox<Tezina>();
		ponudjeni.addItem(Tezina.LAKO); ponudjeni.addItem(Tezina.SREDNJE); ponudjeni.addItem(Tezina.TESKO);
		ponudjeni.setSelectedItem(this.recept.getTezina());
		if (this.korNalog.getVrstaKorisnika() != TipKorisnika.KREATOR) tezina.add(new JLabel());
		tezina.add(ponudjeni);
		if (this.korNalog.getVrstaKorisnika() == TipKorisnika.KREATOR) {
			tezina.add(new JLabel());
			ponudjeni.setEnabled(false);
		}
		add(tezina);

		Recenzija reci = new Recenzija();
		if (this.korNalog.getVrstaKorisnika() != TipKorisnika.KREATOR) {	//recenzijaa!
			reci.setModerator(this.korNalog);
			reci.setRecept(this.recept);
			add(new JLabel("   Strucna ocena:"));
			JPanel ocena = new JPanel(new GridLayout(1, 5));
			ButtonGroup grupica = new ButtonGroup();
			JRadioButton oc1 = new JRadioButton("1"); grupica.add(oc1); ocena.add(oc1);
			JRadioButton oc2 = new JRadioButton("2"); grupica.add(oc2); ocena.add(oc2);
			JRadioButton oc3 = new JRadioButton("3"); grupica.add(oc3); ocena.add(oc3);
			JRadioButton oc4 = new JRadioButton("4"); grupica.add(oc4); ocena.add(oc4);
			JRadioButton oc5 = new JRadioButton("5"); grupica.add(oc5); ocena.add(oc5);
			ActionListener akcijaZvezde = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					reci.setOcena(1);
					if (oc2.isSelected()) reci.setOcena(2);
					else if (oc3.isSelected()) reci.setOcena(3);
					else if (oc4.isSelected()) reci.setOcena(4);
					else if (oc5.isSelected()) reci.setOcena(5);
				}
			};
			oc1.addActionListener(akcijaZvezde); oc2.addActionListener(akcijaZvezde);
			oc3.addActionListener(akcijaZvezde); oc4.addActionListener(akcijaZvezde); oc5.addActionListener(akcijaZvezde);
			add(ocena);
		}

		add(new JLabel());
		JPanel kraj = new JPanel(new GridLayout(1, 2));
		kraj.add(new JLabel());
		JButton sacuvaj = new JButton("Sacuvaj");
		sacuvaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IzmenaRecepta.this.recept.setNazivRec(ime.getText());
				IzmenaRecepta.this.recept.setDuzinaMin(Integer.parseInt(vreme.getText()));
				IzmenaRecepta.this.recept.setOpisPripreme(priprema.getText());
				IzmenaRecepta.this.recept.setOprema(IzmenaRecepta.this.pomocniZaAlat.getOprema());
//				video link i image link????
				if (IzmenaRecepta.this.korNalog.getVrstaKorisnika() != TipKorisnika.KREATOR) {
					IzmenaRecepta.this.recept.setRecenzija(reci);
					MenadzerRecepta.getInstance().izbrisiReceptNaCekanju(IzmenaRecepta.this.recept);
					MenadzerRecepta.getInstance().dodajRecept(IzmenaRecepta.this.recept);
					IzmenaRecepta.this.recept.getAutor().dodajAutorskiRecept(IzmenaRecepta.this.recept);
				}
				else {} //sta ako korisnik izmeni svoj recept?
				IzmenaRecepta.this.dispose();
			}
		});
		kraj.add(sacuvaj);
		add(kraj);
		
		setVisible(true);
	}
	
}

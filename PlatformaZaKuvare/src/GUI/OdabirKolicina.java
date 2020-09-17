package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Klase.Kolicina;
import Klase.MernaJedinica;
import Klase.Recept;
import Klase.Sastojak;
import Menadzeri.MenadzerSastojaka;

public class OdabirKolicina extends JDialog {

	private static final long serialVersionUID = 1L;
	private ArrayList<JCheckBox> listaSastojaka;
	private ArrayList<ComboBoxMernihJedinica> listaMera;
	private ArrayList<JTextField> listaKolicine;
	private ArrayList<Sastojak> sastojci;
	private Recept recept;
	private boolean obavezanNe;

	public OdabirKolicina(Recept rec, boolean dodavanjeNovog, boolean obavezan, ArrayList<Sastojak> iskorisceni) {
		this.listaSastojaka = new ArrayList<JCheckBox>();
		this.sastojci = new ArrayList<Sastojak>();
		this.recept = rec;
		this.obavezanNe = obavezan;

		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setTitle("    Odabir sastojaka:");
		
		int velicinaIskoriscenih = 0;
		if (!iskorisceni.isEmpty()) velicinaIskoriscenih = iskorisceni.size();
		JPanel glavni = new JPanel(new GridLayout(MenadzerSastojaka.getInstance().getSastojci().size() - velicinaIskoriscenih, 3));
		for (Sastojak s : MenadzerSastojaka.getInstance().getSastojci()) {
			if (iskorisceni.indexOf(s) >= 0) continue;		//oni koji ne smeju biti
			sastojci.add(s);
			JCheckBox c = new JCheckBox(s.getNaziv());
			listaSastojaka.add(c);
			glavni.add(c);
			ComboBoxMernihJedinica merneJedinice = new ComboBoxMernihJedinica();
			listaMera.add(merneJedinice);
			glavni.add(merneJedinice);
			JTextField brojKomada = new JTextField();
			listaKolicine.add(brojKomada);
			glavni.add(brojKomada);
		}
		
		if (!dodavanjeNovog) {		//u slucaju kada nije dodavanje, onda imamo vec selektovane
			for (Kolicina k : recept.getKolicineSastojaka()) {
				int index = sastojci.indexOf(k.getSastojak());
				if (index >= 0) {
					listaSastojaka.get(index).setSelected(true);
					listaMera.get(index).setSelectedItem(k.getMernaJedinica());
					listaKolicine.get(index).setText(k.getKolicina() + "");
				}
			}
		}
		add(glavni, BorderLayout.CENTER);
		
		JButton btnOk = new JButton("OK");
		JPanel pnl = new JPanel(new GridLayout(1,3));
		pnl.add(new JLabel());
		pnl.add(new JLabel());
		pnl.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirKolicina.this.kraj();
			}
		});
		add(pnl, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private class ComboBoxMernihJedinica extends JComboBox<MernaJedinica> {

		private static final long serialVersionUID = 1L;
		
		public ComboBoxMernihJedinica() {
			addItem(MernaJedinica.MG);
			addItem(MernaJedinica.G);
			addItem(MernaJedinica.KG);
			addItem(MernaJedinica.KASICICA);
			addItem(MernaJedinica.KASIKA);
			addItem(MernaJedinica.KOMAD);
			addItem(MernaJedinica.ML);
			addItem(MernaJedinica.L);
			addItem(MernaJedinica.PAKOVANJE);
			addItem(MernaJedinica.PRSTOHVAT);
			addItem(MernaJedinica.SOLJICA);
			addItem(MernaJedinica.SOLJA);
		}
		public MernaJedinica getItem(int i) {
			switch (i) {
			case 0: return MernaJedinica.MG;
			case 1: return MernaJedinica.G;
			case 2: return MernaJedinica.KG;
			case 3: return MernaJedinica.KASICICA;
			case 4: return MernaJedinica.KASIKA;
			case 5: return MernaJedinica.KOMAD;
			case 6: return MernaJedinica.ML;
			case 7: return MernaJedinica.L;
			case 8: return MernaJedinica.PAKOVANJE;
			case 9: return MernaJedinica.PRSTOHVAT;
			case 10: return MernaJedinica.SOLJICA;
			default: return MernaJedinica.SOLJA;
			}
		}
	}
	
	private void kraj() {
		int i = 0;
		recept.getKolicineSastojaka().clear();		//izbrisi sve stare kolicine
		for (JCheckBox b : listaSastojaka) {
			if(b.isSelected()) {
				Kolicina k = new Kolicina(listaMera.get(i).getItem(listaMera.get(i).getSelectedIndex()), 
						Integer.parseInt(listaKolicine.get(i).getText()), obavezanNe, sastojci.get(i), recept);
				recept.dodajKolicinuSastojka(k);
			}
			i++;
		}
		dispose();
	}
}

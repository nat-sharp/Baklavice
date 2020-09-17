package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Klase.Kategorija;
import Klase.Recept;
import Menadzeri.MenadzerKategorija;

public class OdabirKategorije extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<JCheckBox> lista;
	private Recept recept;
	private ArrayList<Kategorija> kategorije;
	
	public OdabirKategorije(Recept rec, boolean noviRecept) {
		this.recept = rec;
		this.lista = new ArrayList<JCheckBox>();

		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		kategorije = (ArrayList<Kategorija>) MenadzerKategorija.getInstance().getKategorije();
		setTitle("    Odabir recepata:");
		
		JPanel glavni = new JPanel(new GridLayout(kategorije.size(), 1));
		for (Kategorija k : kategorije) {
			JCheckBox c = new JCheckBox(k.getNazivKat());
			lista.add(c);
			glavni.add(c);
			if (!noviRecept) if (recept.getKategorije().indexOf(k) >= 0) c.setSelected(true);
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
				OdabirKategorije.this.kraj();
			}
		});
		add(pnl, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	private void kraj() {
		int i = 0;
		for (JCheckBox b : lista) {
			if(b.isSelected()) {
				this.recept.dodajKategoriju(kategorije.get(i));
			}
			i++;
		}
		dispose();
	}
}

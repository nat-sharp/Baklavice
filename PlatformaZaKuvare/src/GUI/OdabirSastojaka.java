package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Klase.KorisnickiNalog;
import Klase.Sastojak;
import Menadzeri.MenadzerSastojaka;

public class OdabirSastojaka extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame mojRoditelj;
	private ArrayList<JCheckBox> lista;
	private ArrayList<Sastojak> selektovani;
	private KorisnickiNalog korNalog;
	private ArrayList<Sastojak> sastojci;
	
	public OdabirSastojaka(JFrame roditelj, KorisnickiNalog korNalog) {
		this.selektovani = new ArrayList<Sastojak>();
		this.korNalog = korNalog;
		this.mojRoditelj = roditelj;
		this.lista = new ArrayList<JCheckBox>();
		this.sastojci = (ArrayList<Sastojak>) MenadzerSastojaka.getInstance().getSastojci();

		this.mojRoditelj.setVisible(false);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setTitle("    Odabir sastojaka:");
		
		JPanel glavni = new JPanel(new GridLayout(sastojci.size(), 1));
		for (Sastojak s : sastojci) {
			JCheckBox c = new JCheckBox(s.getNaziv());
			lista.add(c);
			glavni.add(c);
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
				OdabirSastojaka.this.kraj();
			}
		});
		add(pnl, BorderLayout.SOUTH);
		
	}
	
	private void kraj() {
		int i = 0;
		for (JCheckBox b : lista) {
			if(b.isSelected()) {
				selektovani.add(sastojci.get(i));
			}
			i++;
		}
		this.korNalog.setSastojci(selektovani);
		this.mojRoditelj.setVisible(true);
		dispose();
	}
}

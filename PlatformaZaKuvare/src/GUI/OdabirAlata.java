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

import Klase.Alat;
import Klase.KorisnickiNalog;

public class OdabirAlata extends JFrame{
	private JFrame mojRoditelj;
	private ArrayList<Alat> selektovani;
	private KorisnickiNalog korNalog;

	private JCheckBox ch1 = new JCheckBox(Alat.MIKROTALASNA.toString());
	private JCheckBox ch2 = new JCheckBox(Alat.BLENDER.toString());
	private JCheckBox ch3 = new JCheckBox(Alat.KALUP.toString());
	private JCheckBox ch4 = new JCheckBox(Alat.MIKSER.toString());
	private JCheckBox ch5 = new JCheckBox(Alat.SOKOVNIK.toString());
	private JCheckBox ch6 = new JCheckBox(Alat.TOSTER.toString());
	
	public OdabirAlata(JFrame roditelj, KorisnickiNalog korNalog) {
		this.selektovani = new ArrayList<Alat>();
		this.korNalog = korNalog;
		this.mojRoditelj = roditelj;

		this.mojRoditelj.setVisible(false);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("    Odabir alata:");
		
		JPanel glavni = new JPanel(new GridLayout(6, 1));
		glavni.add(ch1); glavni.add(ch2); glavni.add(ch3);
		glavni.add(ch4); glavni.add(ch5); glavni.add(ch6);
		add(glavni, BorderLayout.CENTER);

		JButton btnOk = new JButton("OK");
		JPanel pnl = new JPanel(new GridLayout(1,3));
		pnl.add(new JLabel());
		pnl.add(new JLabel());
		pnl.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OdabirAlata.this.kraj();				
			}
		});
		add(pnl, BorderLayout.SOUTH);
		setVisible(true);
		
	}

	protected void kraj() {
		if(ch1.isSelected()) {
			selektovani.add(Alat.MIKROTALASNA);
		}
		if(ch2.isSelected()) {
			selektovani.add(Alat.BLENDER);
		}
		if(ch3.isSelected()) {
			selektovani.add(Alat.KALUP);
		}
		if(ch4.isSelected()) {
			selektovani.add(Alat.MIKSER);
		}
		if(ch5.isSelected()) {
			selektovani.add(Alat.SOKOVNIK);
		}
		if(ch6.isSelected()) {
			selektovani.add(Alat.TOSTER);
		}if(this.mojRoditelj instanceof PretragaProzor) {
			((PretragaProzor) this.mojRoditelj).alati = selektovani;
		}else {
			this.korNalog.setOprema(selektovani);
		}
		this.mojRoditelj.setVisible(true);
		dispose();
		
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Klase.Recept;
import Klase.TopListaRecepata;
import Menadzeri.MenadzerRecepta;
public class TLRFrejm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tabela;
	
	public TLRFrejm(TopListaRecepata tlr) {
		this.setTitle("TOP LISTA RECEPATA      DATUM: "+ tlr.getDatum().toString());
		this.setSize(600,600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		TabRecepti tabR = new TabRecepti(tlr.getRecepti());
		this.tabela = new JTable(tabR);
		tabela.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(tabela);
		
		
		JButton btnPrikaz = new JButton("Prikazi");
		JPanel pnl = new JPanel(new GridLayout(1,3));
		pnl.add(new JLabel());
		pnl.add(new JLabel());
		pnl.add(btnPrikaz);
		this.add(pnl,BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
		this.setVisible(true);
		
		btnPrikaz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = TLRFrejm.this.tabela.getSelectedRow();
				if(row != -1) {
					String naz = (String) TLRFrejm.this.tabela.getModel().getValueAt(row, 0);
					String korIme = (String) TLRFrejm.this.tabela.getModel().getValueAt(row, 1);
					
					Recept r = MenadzerRecepta.getInstance().getReceptByInfo(naz, korIme);
					//ProzorRecepta pr = new ProzorRecepta(r);
				}else {
					JOptionPane.showMessageDialog(null, "Nijedan element nije selektovan");
				}
				
			}
			
		});
		
	}

}

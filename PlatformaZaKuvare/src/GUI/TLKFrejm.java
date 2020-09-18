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

import Klase.TopListaKreatora;
public class TLKFrejm extends JFrame{

	private static final long serialVersionUID = 1L;
	private TopListaKreatora tlk;
	private JTable tabela;

	public TLKFrejm(TopListaKreatora tlk) {
		this.tlk = tlk;
		this.setSize(500,600);
		this.setTitle("TOP LISTA KORISNIKA KREATORA      DATUM: "+tlk.getDatum().toString() );
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		TabKorisnici tabK = new TabKorisnici(tlk.getKorisnici());
		this.tabela = new JTable(tabK);
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
				int row = TLKFrejm.this.tabela.getSelectedRow();
				if(row!= -1) {
					ProfilZaPracenje pp = new ProfilZaPracenje(TLKFrejm.this.tlk.getKorisnici().get(row));
				}else {
					JOptionPane.showMessageDialog(null, "Nijedan element nije selektovan");
				}
				
			}
			
		});

		
		
	}
	
}

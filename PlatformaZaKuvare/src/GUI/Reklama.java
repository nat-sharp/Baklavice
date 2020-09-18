package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reklama {

	private JFrame frame;

	public Reklama() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("REKLAMA");
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\reklama.png"));
		lblNewLabel.setBounds(-20, 0, 600, 353);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}

package utils;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class Page extends JFrame {

	protected Page() {
		this.setSize(500, 500);
		this.setIconImage(new ImageIcon("Images/icon.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
	}
	
	public void prepareTable(JFrame frame) {}
	
	public void prepareButtons(JFrame frame) {};
	
	public void prepareTextFields(JFrame frame) {};
	
	public void prepareLabel() {
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Images/logo.png"));
		Dimension size = label.getPreferredSize();
		label.setBounds(100, 0, size.width, size.height);
		this.add(label);
	}
}

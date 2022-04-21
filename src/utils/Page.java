package utils;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Page extends JFrame {

	protected Page() {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
	}
	
	public void prepareTable(JFrame frame) {}
	
	public void prepareButtons(JFrame frame) {};
	
	public void prepareTextFields(JFrame frame) {};
}

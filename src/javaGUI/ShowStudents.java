package javaGUI;

import javax.swing.JFrame;

public class ShowStudents {
	private JFrame frame = new JFrame();
	
	ShowStudents() {
		prepareGUI();
		frame.setVisible(true);
	}
	
	private void prepareGUI() {
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	}
}

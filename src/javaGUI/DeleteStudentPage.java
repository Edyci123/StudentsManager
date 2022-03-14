package javaGUI;

import javax.swing.JFrame;

public class DeleteStudentPage {
	private static JFrame frame = new JFrame();
	
	DeleteStudentPage() {
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

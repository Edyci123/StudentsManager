package javaGUI;

import javax.swing.*;

public class UpdateStudentPage {
	private static JFrame frame = new JFrame();
	
	UpdateStudentPage() {
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

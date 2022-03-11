package javaGUI;

import javax.swing.*;
import java.awt.event.*;

public class RegisterPage {	
	
	private JFrame frame = new JFrame();
	private JTextField firstName = new JTextField(15);
	private JTextField lastName = new JTextField(15);
	private JTextField email = new JTextField(15);
	
	RegisterPage() {
		prepareGUI();
		prepareButtons();
		prepareTextFields();
		frame.setVisible(true);
	}
	
	private void prepareGUI() {
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	}
	
	private void prepareButtons() {
		JButton button1 = new JButton("Register a new student!");
		button1.setBounds(25, 400, 175, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(firstName.getText() + " " + lastName.getText() + " " + email.getText());
				DatabaseQueries.addNewStudent(new Student(firstName.getText(), lastName.getText(), email.getText()));
			}
		}); 
		
		JButton button2 = new JButton("Show students!");
		button2.setBounds(287, 400, 175, 50);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowStudentsPage();
				frame.dispose();
			}
		});
		
		frame.add(button1);
		frame.add(button2);
	}
	
	private void prepareTextFields() {		
//		JPanel panel = new JPanel(new BorderLayout());
//		JLabel label = new JLabel("Firstname");
//		
//		panel.add(label, BorderLayout.WEST);
//		panel.add(firstName, BorderLayout.EAST);
//		
//		panel.setBounds(50, 100, 250, 25);

		frame.add(TextFields.createPanel(new JLabel("Firstname"), firstName, new Dimensions(50, 100, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("Lastname"), lastName, new Dimensions(50, 150, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("Email"), email, new Dimensions(50, 200, 250, 25)));	
	}
}

package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import utils.DatabaseQueries;
import utils.Dimensions;
import utils.TextFields;

public class InsertCredentials {
	private static JFrame frame = new JFrame();
	private static JTextField username = new JTextField(15);
	private static JPasswordField password = new JPasswordField(15);
	
	public InsertCredentials() {
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
		JButton button1 = new JButton("Register");
		button1.setBounds(140, 400, 200, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseQueries.setDatabaseCredentials(username.getText(), new String(password.getPassword()));
				new RegisterPage();
				frame.dispose();
			}
		});
		
		frame.add(button1);
	}
	
	private void prepareTextFields() {
		frame.add(TextFields.createPanel(new JLabel("username"), username, new Dimensions(50, 100, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("password"), password, new Dimensions(50, 150, 250, 25)));
	}
	
}

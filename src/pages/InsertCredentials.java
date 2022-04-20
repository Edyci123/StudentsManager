package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import utils.DatabaseQueries;
import utils.Dimensions;
import utils.Page;
import utils.TextFields;

@SuppressWarnings("serial")
public class InsertCredentials extends Page {
	private static JTextField username = new JTextField(15);
	private static JPasswordField password = new JPasswordField(15);
	
	public InsertCredentials() {
		super();
		prepareButtons(this);
		prepareTextFields(this);
		this.setVisible(true);
	}
	
	@Override
	public void prepareButtons(JFrame frame) {
		JButton button1 = new JButton("Register");
		button1.setBounds(140, 400, 200, 50);
		button1.addActionListener(new ActionListener() { // adding action listener to a button
			public void actionPerformed(ActionEvent e) {
				// if you have no table names students uncomment ->
				// DatabaseQueries.createNewTabel("students");
				DatabaseQueries.setDatabaseCredentials(username.getText(), new String(password.getPassword()));
				new RegisterPage();
				frame.dispose();
			}
		});
		
		frame.add(button1);
	}
	
	@Override
	public void prepareTextFields(JFrame frame) {
		frame.add(TextFields.createPanel(new JLabel("username"), username, new Dimensions(50, 100, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("password"), password, new Dimensions(50, 150, 250, 25)));
	}

	@Override
	public void prepareTable(JFrame frame) {
	}
	
}

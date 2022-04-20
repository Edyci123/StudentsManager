package pages;

import java.awt.event.*;

import javax.swing.*;

import utils.DatabaseQueries;
import utils.Dimensions;
import utils.Page;
import utils.TextFields;

@SuppressWarnings("serial")
public class UpdateStudentPage extends Page {
	private static JTextField firstName = new JTextField(15);
	private static JTextField lastName = new JTextField(15);
	private static JTextField newEmail = new JTextField(15);
	
	UpdateStudentPage() {
		super();
		prepareButtons(this);
		prepareTextFields(this);
		this.setVisible(true);
	}
	
	@Override
	public void prepareButtons(JFrame frame) {
		JButton button1 = new JButton("Update");
		button1.setBounds(25, 400, 175, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseQueries.updateStudentEmail(firstName.getText(), lastName.getText(), newEmail.getText());
			}
		});
		
		JButton button2 = new JButton("Return to Register Page");
		button2.setBounds(287, 400, 175, 50);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage();
				frame.dispose();
			}
		});
		
		frame.add(button1);
		frame.add(button2);
	}
	
	@Override
	public void prepareTextFields(JFrame frame) {
		frame.add(TextFields.createPanel(new JLabel("First name"), firstName, new Dimensions(50, 100, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("Last name"), lastName, new Dimensions(50, 150, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("New Email"), newEmail, new Dimensions(50, 200, 250, 25)));	
	}

	@Override
	public void prepareTable(JFrame frame) {
	}
	
}

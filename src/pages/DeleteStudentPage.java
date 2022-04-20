package pages;

import javax.swing.*;

import utils.DatabaseQueries;
import utils.Dimensions;
import utils.Page;
import utils.TextFields;

import java.awt.event.*;

@SuppressWarnings("serial")
public class DeleteStudentPage extends Page {
	private static JTextField firstName = new JTextField(15);
	private static JTextField lastName = new JTextField(15);
	
	DeleteStudentPage() {
		super();
		prepareButtons(this);
		prepareTextFields(this);
		this.setVisible(true);
	}
	
	@Override
	public void prepareButtons(JFrame frame) {
		JButton button1 = new JButton("Delete Student");
		button1.setBounds(25, 400, 175, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseQueries.deleteStudent(firstName.getText(), lastName.getText());
				firstName.setText(null);
				lastName.setText(null);
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
	}

	@Override
	public void prepareTable(JFrame frame) {
		// TODO Auto-generated method stub
		
	}
	
}

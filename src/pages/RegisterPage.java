package pages;

import javax.swing.*;

import utils.DatabaseQueries;
import utils.Dimensions;
import utils.Page;
import utils.Student;
import utils.TextFields;

import java.awt.event.*;

@SuppressWarnings("serial")
public class RegisterPage extends Page {	
	private JTextField firstName = new JTextField(15);
	private JTextField lastName = new JTextField(15);
	private JTextField email = new JTextField(15);
	
	public RegisterPage() {
		super();
		prepareButtons(this);
		prepareTextFields(this);
		this.setVisible(true);
	}
	
	@Override
	public void prepareButtons(JFrame frame) {
		JButton button1 = new JButton("Register a new student!");
		button1.setBounds(25, 325, 175, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Student.check(new Student(firstName.getText(), lastName.getText(), email.getText()))) {
					DatabaseQueries.addNewStudent(new Student(firstName.getText(), lastName.getText(), email.getText()));
					
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Wrong data introduced!",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}); 
		
		JButton button2 = new JButton("Show students!");
		button2.setBounds(287, 325, 175, 50);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowStudentsPage();
				dispose();
			}
		});
		
		JButton button3 = new JButton("Delete a Student");
		button3.setBounds(25, 400, 175, 50);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStudentPage();
				frame.dispose();
			}
		});
		
		JButton button4 = new JButton("Update Student");
		button4.setBounds(287, 400, 175, 50);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStudentPage();
				frame.dispose();
			}
		});
		
		
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
	}
	
	@Override
	public void prepareTextFields(JFrame frame) {	
		frame.add(TextFields.createPanel(new JLabel("First name"), firstName, new Dimensions(100, 125, 250, 25))); // adding panels with label and text field to the frame
		frame.add(TextFields.createPanel(new JLabel("Last name"), lastName, new Dimensions(100, 175, 250, 25)));
		frame.add(TextFields.createPanel(new JLabel("Email"), email, new Dimensions(100, 225, 250, 25)));	
	}
}

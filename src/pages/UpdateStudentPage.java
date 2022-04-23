package pages;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import utils.DatabaseQueries;
import utils.Dimensions;
import utils.MailUtil;
import utils.Page;
import utils.TextFields;

@SuppressWarnings("serial")
public class UpdateStudentPage extends Page {
	private static JTextField newEmail = new JTextField(15);
	private String firstName;
	private String lastName;
	private String oldEmail;
	
	public UpdateStudentPage(String firstName, String lastName, String oldEmail, ShowStudentsPage ssp, JTable table) {
		super();
		this.prepareLabel();
		this.firstName = firstName;
		this.lastName = lastName;
		this.oldEmail = oldEmail;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		prepareButtons(this, ssp, table);
		prepareTextFields(this);
		this.setVisible(true);
	}
	
	
	public void prepareButtons(JFrame frame, ShowStudentsPage ssp, JTable table) {
		JButton button1 = new JButton("Update");
		button1.setBounds(100, 200, 100, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseQueries.updateStudentEmail(firstName, lastName, oldEmail, newEmail.getText());
				frame.dispose();
				MailUtil.sendUpdateEmail(firstName, lastName, newEmail.getText());
				ssp.remove(table.getParent().getParent());
				ssp.prepareTable((JFrame)ssp);
			}
		});
		
		frame.add(button1);
	}
	
	@Override
	public void prepareTextFields(JFrame frame) {
		frame.add(TextFields.createPanel(new JLabel("New Email"), newEmail, new Dimensions(25, 125, 250, 25)));	
	}
	
	@Override
	public void prepareLabel() {
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Images/logoTiny.png"));
		Dimension size = label.getPreferredSize();
		label.setBounds(50, 0, size.width, size.height);
		this.add(label);
	}
}

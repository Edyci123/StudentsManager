package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import utils.DatabaseQueries;
import utils.Page;
import utils.Student;

@SuppressWarnings("serial")
public class ShowStudentsPage extends Page {
	public ShowStudentsPage() {
		super();
		prepareTable(this);
		prepareButtons(this);
		this.setVisible(true);
	}
	
	@Override
	public void prepareTable(JFrame frame) {
		String col[] = new String[] {"Index", "Firstname", "Lastname", "Email"};
		DefaultTableModel tableModel = new DefaultTableModel(0, 0);
		
		tableModel.setColumnIdentifiers(col);
		
		ArrayList<Student> list = DatabaseQueries.getStudents();
		
		int index = 1;
		for (Student s: list) {
			Object[] obj = {index, s.getFirstName(), s.getLastName(), s.getEmail()};
			tableModel.addRow(obj);
			index++;
		}
		
		JTable table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		
		JScrollPane sp = new JScrollPane(table);
		
		sp.setBounds(45, 50, 400, 200);
		frame.add(sp);
	}
	
	@Override
	public void prepareButtons(JFrame frame) {
		JButton button1 = new JButton("Back to Register Page");
		button1.setBounds(25, 400, 175, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage();
				frame.dispose();
			}
		});
		
		JButton button2 = new JButton("Update a student!");
		button2.setBounds(287, 400, 175, 50);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStudentPage();
				frame.dispose();
			}
		});
		
		frame.add(button1);
		frame.add(button2);
	}

	@Override
	public void prepareTextFields(JFrame frame) {
	}
	
}

package javaGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ShowStudentsPage {
	private JFrame frame = new JFrame();
	
	ShowStudentsPage() {
		prepareGUI();
		prepareTable();
		prepareButtons();
		frame.setVisible(true);
	}
	
	private void prepareGUI() {
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	}
	
	private void prepareTable() {
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
	
	private void prepareButtons() {
		JButton button1 = new JButton("Back to Register Page");
		button1.setBounds(140, 400, 200, 50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage();
				frame.dispose();
			}
		});
		
		frame.add(button1);
	}
	
}

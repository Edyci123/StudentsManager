package utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PopupMenuShowStudents extends JPopupMenu {

	public PopupMenuShowStudents() {
		JMenuItem update = new JMenuItem("Update");
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
				JPopupMenu menu = (JPopupMenu)c.getParent();
				JTable table = (JTable)menu.getInvoker();
				
				System.out.println("Update" + String.valueOf(table.getSelectedRow()));
			}
		});
		
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
				JPopupMenu menu = (JPopupMenu)c.getParent();
				JTable table = (JTable)menu.getInvoker();
				
				DatabaseQueries.deleteStudent(table.getSelectedRow() + 1);
			}
		});
		
		add(update);
		add(delete);
		
	}
	
}

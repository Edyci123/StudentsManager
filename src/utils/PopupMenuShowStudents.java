package utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;

import pages.ShowStudentsPage;
import pages.UpdateStudentPage;

@SuppressWarnings("serial")
public class PopupMenuShowStudents extends JPopupMenu {

	public PopupMenuShowStudents(ShowStudentsPage ssp) {
		JMenuItem update = new JMenuItem("Update");
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
				JPopupMenu menu = (JPopupMenu)c.getParent();
				JTable table = (JTable)menu.getInvoker();
				
				new UpdateStudentPage(table.getValueAt(table.getSelectedRow(), 1).toString(), table.getValueAt(table.getSelectedRow(), 2).toString(), table.getValueAt(table.getSelectedRow(), 3).toString(), ssp, table);
			}
		});
		
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new ActionListener() {  
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
				JPopupMenu menu = (JPopupMenu)c.getParent();
				JTable table = (JTable)menu.getInvoker();
				
				DatabaseQueries.deleteStudent(table.getValueAt(table.getSelectedRow(), 3).toString());
				
				ssp.remove(table.getParent().getParent());
				ssp.prepareTable((JFrame)ssp);
			}
		});
		
		add(update);
		add(new JSeparator());
		add(delete);
		
	}
	
}

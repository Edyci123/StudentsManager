package javaGUI;

import java.awt.*;
import javax.swing.*;

public class textFields {
	
	public static JPanel createPanel(JLabel label, JTextField textField, Dimensions d) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.WEST);
		panel.add(textField, BorderLayout.EAST);
		panel.setBounds(d.x, d.y, d.width, d.height);
		
		return panel;
	}

}

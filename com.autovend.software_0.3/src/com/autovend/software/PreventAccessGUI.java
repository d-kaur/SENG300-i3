package com.autovend.software;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PreventAccessGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public PreventAccessGUI() {
      JLabel label = new JLabel("Checkout Disabled", SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 54)); 
      setSize(600,600);
      add(label);
      setVisible(true);
	}

}

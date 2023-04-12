package com.autovend.software;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PreventScreenextends extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 public PreventScreenextends() {
		// TODO Auto-generated constructor stub
	
	        setTitle("Self checkout");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JLabel label = new JLabel("Self CheckoutStation Disabled", SwingConstants.CENTER);
	        //label.setSize(new Dimension(400,100));
	        label.setFont(new Font("Arial", Font.BOLD, 72));
	        add(label);

	        setSize(900, 500);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new PreventScreenextends();
	}
	
	
	

}

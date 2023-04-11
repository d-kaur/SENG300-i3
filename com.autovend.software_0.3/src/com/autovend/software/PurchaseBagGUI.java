package com.autovend.software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.autovend.devices.EmptyException;

public class PurchaseBagGUI {
	private JFrame frame;
	private JTextField textfield;
	private JButton addButton, backButton;
	AddOrRemoveBags purchaseBags;
	
	public PurchaseBagGUI() {
		frame = new JFrame("Purchase Bag");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		
		backButtonAction();
		frame.add(backButton);
		purchaseButtonAction();
		frame.add(addButton);
		frame.add(textfield);
		frame.setVisible(true);
	}

	private void purchaseButtonAction() {
		// TODO Auto-generated method stub
		addButton = new JButton("Purchase Bag");
		addButton.setBounds(50, 430, 145, 50);
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = textfield.getText();
				if(input.equals("")) {
					JOptionPane.showMessageDialog(new JPanel(), "Invalid Inputs", "Try Again", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int bagPurchase = Integer.parseInt(input);
				if(bagPurchase <= 0) {
					JOptionPane.showMessageDialog(new JPanel(),"Invalid Input", "Failed to purchase bag", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						purchaseBags.purchaseBag(bagPurchase);
						JOptionPane.showMessageDialog(new JPanel(),"Successfully Purchased Bag", "Success", JOptionPane.PLAIN_MESSAGE);
						System.exit(0);
					} catch (EmptyException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(new JPanel(),"Invalid Input", "Failed to purchase bag", JOptionPane.ERROR_MESSAGE);
					}
				}
				System.exit(0);
			}
			
		});
	}
	private void backButtonAction() {
		backButton = new JButton("Back");
		backButton.setBounds(205, 430, 145, 50);
		backButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				System.exit(0);
			}
		
		});
	}
}

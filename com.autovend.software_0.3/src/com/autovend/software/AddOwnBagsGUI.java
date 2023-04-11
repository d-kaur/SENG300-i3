package com.autovend.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddOwnBagsGUI {
	private JFrame frame;
	// Implement this button function in the Customer GUI
	public AddOwnBagsGUI() {
		frame = new JFrame("Add Own Bags");
		
		JButton addOwnBag = new JButton("Add Own Bags");
		addOwnBag.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bagWeight = JOptionPane.showInputDialog("Enter the weight of your bag.", " ");
				if(bagWeight.equals("")) {
					JOptionPane.showMessageDialog(new JPanel(), "Invalid Inputs!", "Try Again" , JOptionPane.ERROR_MESSAGE);
					return;
				}
				double weight = Double.parseDouble(bagWeight);
				boolean addedOwnBagSuccessfully = AddOrRemoveBags.addOwnBag(weight);
				if(addedOwnBagSuccessfully) {
				JOptionPane.showMessageDialog(new JPanel(), "Bag Added", "Success", JOptionPane.PLAIN_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(new JPanel(), "Failed to add Bag", "Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	});
		frame.add(addOwnBag);
	}
}

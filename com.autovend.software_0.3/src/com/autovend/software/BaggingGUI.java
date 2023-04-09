package com.autovend.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BaggingGUI {
	
	public void addOwnBags() {
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
	}
	
	public void purchaseBags() {
		JButton purchaseBag = new JButton("Purchase Bags");
		purchaseBag.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
			
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		String bagWeight = JOptionPane.showInputDialog("Enter the weight of your bag.", " ");
//		if(bagWeight.equals("")) {
//			JOptionPane.showMessageDialog(new JPanel(), "Invalid Inputs!", "Try Again" , JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		double weight = Double.parseDouble(bagWeight);
//		boolean addedOwnBagSuccessfully = AddOrRemoveBags.addOwnBag(weight);
//		if(addedOwnBagSuccessfully) {
//			JOptionPane.showMessageDialog(new JPanel(), "Bag Added", "Success", JOptionPane.PLAIN_MESSAGE);
//		}else {
//			JOptionPane.showMessageDialog(new JPanel(), "Failed to add Bag", "Failed", JOptionPane.ERROR_MESSAGE);
//		}
//	}
//	
//	JButton purchaseBags = new JButton("Purchase Bags");
//	purchaseBags.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//		}
//	});
}

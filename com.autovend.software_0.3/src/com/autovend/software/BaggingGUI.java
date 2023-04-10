package com.autovend.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.autovend.devices.EmptyException;
import com.autovend.devices.SelfCheckoutStation;

public class BaggingGUI {
	
	AddOrRemoveBags purchaseBags;
    SelfCheckoutStation scs;
	
	public void AddOwnBagsGUI() {
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
	
	public void PurchaseBagGUI() {
		JButton purchaseBag = new JButton("Purchase Bags");
		purchaseBag.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputBagPurchase = JOptionPane.showInputDialog("Enter how many bags you want to purchase:", " ");
				if(inputBagPurchase.equals(" ")) {
					JOptionPane.showMessageDialog(new JPanel(), "Invalid Inputs", "Try Again", JOptionPane.ERROR_MESSAGE);
				return;
				}
				int bagPurchase = Integer.parseInt(inputBagPurchase);
				if(bagPurchase < 0) {
					JOptionPane.showMessageDialog(new JPanel(),"Invalid Input", "Failed to purchase bag", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						purchaseBags.purchaseBag(bagPurchase);
						JOptionPane.showMessageDialog(new JPanel(),"Successfully Purchased Bag", "Success", JOptionPane.PLAIN_MESSAGE);
					} catch (EmptyException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(new JPanel(), e1, "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			
		});
	}
}

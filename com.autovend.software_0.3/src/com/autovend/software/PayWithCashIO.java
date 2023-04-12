
package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayWithCashIO extends PayGUI
{
	private JButton backButton;
	private JButton nickelButton;
	private JButton dimeButton;
	private JButton quarterButton;
	private JButton loonieButton;
	private JButton toonieButton;
	private JButton fiveDButton;
	private JButton tenDButton;
	private JButton twentyDButton;
	private JButton fiftyDButton;
	private TextField currentAmount;
	private TextField amountDue;

	 public PayWithCashIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
			super(msg,station,list,parent);

			JFrame frame = new JFrame();
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel MoneyPanel = new JPanel();
			JPanel backPanel = new JPanel();
			JPanel amountPanel = new JPanel();
			JPanel mainPanel = new JPanel();

			setMinimumSize(new Dimension(600,300));

			nickelButton = new JButton("$0.05");
			nickelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			dimeButton = new JButton("$0.10");
			dimeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			quarterButton = new JButton("$0.25");
			quarterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			loonieButton = new JButton("$1.00");
			loonieButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			toonieButton= new JButton("$2.00");
			toonieButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			fiveDButton = new JButton("$5.00");
			fiveDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			tenDButton = new JButton("$10.00");
			tenDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			twentyDButton = new JButton("$20.00");
			twentyDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			fiftyDButton = new JButton("$50.00");
			fiftyDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
				}
			});
	
			MoneyPanel.add(nickelButton);
			MoneyPanel.add(dimeButton);
			MoneyPanel.add(quarterButton);
			MoneyPanel.add(loonieButton);
			MoneyPanel.add(toonieButton);
			MoneyPanel.add(fiveDButton);
			MoneyPanel.add(tenDButton);
			MoneyPanel.add(twentyDButton);
			MoneyPanel.add(fiftyDButton);

			JLabel currentAmountLabel = new JLabel("Current Amount:");
			JLabel amountDueLabel = new JLabel("Amount Due:");

			currentAmount = new TextField();
			currentAmount.setPreferredSize(new Dimension(150, 30));
			amountDue = new TextField();
			amountDue.setPreferredSize(new Dimension(150, 30));

			amountPanel.add(currentAmountLabel);
			amountPanel.add(currentAmount);
			amountPanel.add(amountDueLabel);
			amountPanel.add(amountDue);

			backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					
				}
			});
			backPanel.add(backButton);

			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(MoneyPanel, BorderLayout.NORTH);
			mainPanel.add(amountPanel, BorderLayout.CENTER);
			mainPanel.add(backPanel, BorderLayout.SOUTH);
			
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setContentPane(mainPanel);
			pack();

		}
}
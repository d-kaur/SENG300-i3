
package com.autovend.software;
import javax.swing.*;

import com.autovend.Bill;
import com.autovend.Coin;
import com.autovend.devices.BillValidator;
import com.autovend.devices.CoinValidator;
import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

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
	private PayWithCash payer;
	private BillValidator billacceptor;
	private CoinValidator coinacceptor;
	 public PayWithCashIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
			super(msg,station,list,parent);
			payer = new PayWithCash(station,list);
			billacceptor = station.billValidator;
			coinacceptor = station.coinValidator;
			billacceptor.register(payer);
			coinacceptor.register(payer);
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
					Coin nickel = new Coin(new BigDecimal("0.05"), coinacceptor.currency);
					coinacceptor.accept(nickel);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			dimeButton = new JButton("$0.10");
			dimeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
					Coin dime = new Coin(new BigDecimal("0.1"), coinacceptor.currency);
					coinacceptor.accept(dime);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			quarterButton = new JButton("$0.25");
			quarterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Coin quarter = new Coin(new BigDecimal("0.25"), coinacceptor.currency);
					coinacceptor.accept(quarter);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}}
			});
	
			loonieButton = new JButton("$1.00");
			loonieButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Coin one = new Coin(new BigDecimal(1), coinacceptor.currency);
					coinacceptor.accept(one);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			toonieButton= new JButton("$2.00");
			toonieButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
					Coin two = new Coin(new BigDecimal(2), coinacceptor.currency);
					coinacceptor.accept(two);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			fiveDButton = new JButton("$5.00");
			fiveDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
					Bill five = new Bill(5, coinacceptor.currency);
					billacceptor.accept(five);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			tenDButton = new JButton("$10.00");
			tenDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
					Bill ten = new Bill(10, coinacceptor.currency);
					billacceptor.accept(ten);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			twentyDButton = new JButton("$20.00");
			twentyDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//parent.displayMainScreen();
					Bill twenty = new Bill(20, coinacceptor.currency);
					billacceptor.accept(twenty);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
				}
			});
	
			fiftyDButton = new JButton("$50.00");
			fiftyDButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Bill fifty = new Bill(50, coinacceptor.currency);
					billacceptor.accept(fifty);
					if(payer.getAmountDue().compareTo(new BigDecimal(0)) <= 0)
					{
						parent.showReciept();
					}
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
			amountDue = new TextField(itemsBought.getAmountLeftToPay().toString());
			amountDue.setPreferredSize(new Dimension(150, 30));

			amountPanel.add(currentAmountLabel);
			amountPanel.add(currentAmount);
			amountPanel.add(amountDueLabel);
			amountPanel.add(amountDue);

			backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					back();
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
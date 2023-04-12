

package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayIO extends JFrame
{
	private PayWithGiftCardIO giftCard;
	private PayWithDebitIO debitCard;
	private PayWithCashIO cash;
	private RecieptIO reciept;
	private CustomerIO parent;
	private JButton back;
	private JButton membershipButton;
	private JButton debitCreditButton;
	private JButton cashButton;
	private JButton giftCardButton;
	public PayIO(SelfCheckoutStation scs, CustomerIO parent)
	{
		this.parent = parent;
		giftCard = new PayWithGiftCardIO("Pay Gift",scs,this);
		debitCard = new PayWithDebitIO("Pay Card",scs,this);
		cash = new PayWithCashIO("Pay Cash",scs,this);

		JFrame frame = new JFrame("Select Payment Type");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel membershipPanel = new JPanel();
		JPanel payButtonsPanel = new JPanel();
		JPanel backPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		setMinimumSize(new Dimension(550,300));

		membershipButton = new JButton("Membership");
		membershipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//parent.showMainScreen();
			}
		});
		membershipPanel.add(membershipButton);

		JLabel headerLable = new JLabel("Select Payment Type:");
		
		debitCreditButton = new JButton("Debit/Credit");
		debitCreditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDebitScreen();
			}
		});

		cashButton = new JButton("Cash");
		cashButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCashScreen();
			}
		});

		giftCardButton = new JButton("Gift Card");
		giftCardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGiftScreen();
			}
		});

		payButtonsPanel.add(headerLable);
		payButtonsPanel.add(debitCreditButton);
		payButtonsPanel.add(cashButton);
		payButtonsPanel.add(giftCardButton);

		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		//add(back);
		backPanel.add(back);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(membershipPanel, BorderLayout.NORTH);
		mainPanel.add(payButtonsPanel, BorderLayout.CENTER);
		mainPanel.add(backPanel, BorderLayout.SOUTH);
		
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();

		//add(mainScreen);
		//add(giftCard);
		//add(debitCard);
		//add(cash);
		//showMainScreen();
		
	}
	public void setAllInvisble()
	{
		setVisible(false);
		giftCard.setVisible(false);
		debitCard.setVisible(false);
		cash.setVisible(false);
	}
	public void showMainScreen()
	{
		setAllInvisble();
		setVisible(true);
	}
	public void showDebitScreen()
	{
		setAllInvisble();
		debitCard.setVisible(true);
	}
	public void showGiftScreen()
	{
		setAllInvisble();
		giftCard.setVisible(true);
	}
	public void showCashScreen()
	{
		setAllInvisble();
		cash.setVisible(true);
		cash.updatePrice();
	}
	public void showReciept()
	{
		setAllInvisble();
		reciept = new RecieptIO(this);
		reciept.setVisible(true);
	}
	public void done()
	{
		parent.done();
	}
	private void back()
	{
		parent.showMainScreen();
	}
	
}
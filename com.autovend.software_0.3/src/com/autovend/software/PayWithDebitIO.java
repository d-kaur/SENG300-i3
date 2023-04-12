package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PayWithDebitIO extends PayGUI{

	private JButton tapButton;
	private JButton insertButton;
	private JButton swipeButton;
	private JButton backButton;

    public PayWithDebitIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
		super(msg,station,list,parent);

		JFrame frame = new JFrame("Add Item By Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel actionButtonsPanel = new JPanel();
		JPanel backPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		setMinimumSize(new Dimension(500,300));

		JLabel headerLabel = new JLabel("Select Payment Method");

		tapButton = new JButton("TAP");
		tapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});

		insertButton = new JButton("INSERT");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});

		swipeButton = new JButton("SWIPE");
		swipeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});

		actionButtonsPanel.setLayout(new BoxLayout(actionButtonsPanel, BoxLayout.Y_AXIS));
		actionButtonsPanel.add(Box.createVerticalGlue());
		headerLabel.setAlignmentX(JButton.CENTER_ALIGNMENT);
		actionButtonsPanel.add(headerLabel);
		tapButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		actionButtonsPanel.add(tapButton);
		insertButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		actionButtonsPanel.add(insertButton);
		swipeButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		actionButtonsPanel.add(swipeButton);


		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});

		backPanel.add(backButton);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(actionButtonsPanel, BorderLayout.NORTH);
		mainPanel.add(backPanel, BorderLayout.SOUTH);
		
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();



	}
}
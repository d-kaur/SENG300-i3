
package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayWithGiftCardIO extends PayGUI {
	//GIFT IS ONLY BY INSERT
	//DO we even need a button?
	private JButton insertButton;
	private JButton backButton;

	private JButton back = new JButton("back");
	 public PayWithGiftCardIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
			super(msg,station,list,parent);

		 JFrame frame = new JFrame("Pay with Gift Card");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 JPanel actionButtonsPanel = new JPanel();
		 JPanel backPanel = new JPanel();
		 JPanel mainPanel = new JPanel();

		 setMinimumSize(new Dimension(500,300));

		 JLabel headerLabel = new JLabel("Please Insert Card");
		 insertButton = new JButton("INSERT");
		 insertButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){

			 }
		 });

		 actionButtonsPanel.setLayout(new BoxLayout(actionButtonsPanel, BoxLayout.Y_AXIS));
		 actionButtonsPanel.add(Box.createVerticalGlue());
		 headerLabel.setAlignmentX(JButton.CENTER_ALIGNMENT);
		 actionButtonsPanel.add(headerLabel);
		 insertButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		 actionButtonsPanel.add(insertButton);

		 backButton = new JButton("Back");
		 backButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				back();
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
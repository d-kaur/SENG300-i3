/**
 * 
 */
package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.autovend.devices.SelfCheckoutStation;

/**
 * @author wasay
 *
 */
public class AddItemBrowseGUI extends AddItemGUI{

	private JButton addButton;

	public AddItemBrowseGUI(CustomerIO parent, SelfCheckoutStation scs)
	{
		super(parent,"Add Item Text", scs);

		JPanel comboPanel = new JPanel();
		JPanel addBackPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		JFrame frame = new JFrame("Add Item By Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMinimumSize(new Dimension(600,400));

		JLabel headerLabel = new JLabel("Search:");
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setPreferredSize(new Dimension(150, 40));

		comboPanel.add(headerLabel);
		comboPanel.add(comboBox);
	
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			//parent.displayMainScreen();
			}
		});

		addBackPanel.add(addButton);
		addBackPanel.add(back);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(addBackPanel, BorderLayout.SOUTH);
		mainPanel.add(comboPanel, BorderLayout.CENTER);

		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();

	}

}

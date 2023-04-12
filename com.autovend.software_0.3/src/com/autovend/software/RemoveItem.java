package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RemoveItem extends JFrame{
private JButton backButton;
private JButton deleteItemButton;
private AttendantIO parent;
private JComboBox<String> comboBox = new JComboBox<>();
int stationSelected;
	public RemoveItem(AttendantIO parent){
		this.parent = parent;
		JFrame frame = new JFrame("Remove Item");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel itemsPanel = new JPanel();
		JPanel deletePanel = new JPanel();
		JPanel backPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		setMinimumSize(new Dimension(600,400));

		JLabel headerLabel = new JLabel("Items");
	
		comboBox.setPreferredSize(new Dimension(150, 40));

		itemsPanel.add(headerLabel);
		itemsPanel.add(comboBox);

		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				parent.displayMainScreen();
			}
		});
		backPanel.add(backButton);

		deleteItemButton = new JButton("Delete Item");
		deleteItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				PurchasedItems.removeProduct((String)comboBox.getSelectedItem());
				update();
			}
		});

		deletePanel.add(deleteItemButton);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(itemsPanel, BorderLayout.CENTER);
		mainPanel.add(backPanel, BorderLayout.SOUTH);
		mainPanel.add(deletePanel, BorderLayout.EAST);

		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();

	}
	public void update()
	{
		comboBox.removeAllItems();
		ArrayList<String> items = PurchasedItems.getNames();
		for(String s: items)
		{
			comboBox.addItem(s);
		}
	}

}


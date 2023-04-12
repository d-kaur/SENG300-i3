package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddItemAttendant extends JFrame{
private JButton backButton;
private JButton addItemButton;
private AttendantIO parent;

public AddItemAttendant(AttendantIO parent){
	this.parent = parent;
	JFrame frame = new JFrame("Add Item By Search");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel SearchPanel = new JPanel();
	JPanel addPanel = new JPanel();
	JPanel backPanel = new JPanel();
	JPanel mainPanel = new JPanel();

	setMinimumSize(new Dimension(600,400));
	
	JLabel headerLabel = new JLabel("Search:");
	JComboBox<String> comboBox = new JComboBox<>();
	comboBox.setPreferredSize(new Dimension(150, 40));

	SearchPanel.add(headerLabel);
	SearchPanel.add(comboBox);

	backButton = new JButton("Back");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			parent.displayMainScreen();
		}
	});
	backPanel.add(backButton);

	addItemButton = new JButton("Add Item");
	addItemButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			//parent.displayMainScreen();
		}
	});
	addPanel.add(addItemButton);


	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(SearchPanel, BorderLayout.CENTER);
	mainPanel.add(addPanel, BorderLayout.EAST);
	mainPanel.add(backPanel, BorderLayout.SOUTH);
	
	frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setContentPane(mainPanel);
	pack();

}	

}

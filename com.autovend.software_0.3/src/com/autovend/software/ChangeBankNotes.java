package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBankNotes extends JFrame{
	private AttendantIO parent;
	private JButton backButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton nickelButton;
	private JButton dimeButton;
	private JButton quarterButton;
	private JButton loonieButton;
	private JButton toonieButton;
	private JButton fiveDButton;
	private JButton tenDButton;
	private JButton twentyDButton;
	private JButton fiftyDButton;
	
	
	public  ChangeBankNotes (AttendantIO parent){
		this.parent = parent;
		JFrame frame = new JFrame("Adjust Coins/Bills");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel listOfBC = new JPanel();
		JPanel MoneyPanel = new JPanel();
		JPanel AddRemovePanel = new JPanel();
		JPanel backPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		setMinimumSize(new Dimension(700,400));
		//Creating Componenets

		//Creating combo box
		JLabel headerLabel = new JLabel("List Of Coins and Bank Notes:");
		JComboBox<String> comboBox = new JComboBox<>();
	
		listOfBC.add(headerLabel);
		listOfBC.add(comboBox);

		//Creating back button
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				parent.displayMainScreen();
			}
		});
		
		backPanel.add(backButton);
	
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

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//parent.displayMainScreen();
			}
		});

		removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//parent.displayMainScreen();
			}
		});

		AddRemovePanel.add(addButton);
		AddRemovePanel.add(removeButton);

		//adding components to frame
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(listOfBC, BorderLayout.WEST);
		mainPanel.add(MoneyPanel, BorderLayout.EAST);
		mainPanel.add(AddRemovePanel, BorderLayout.CENTER);
		mainPanel.add(backPanel, BorderLayout.SOUTH);
		
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();


	}


	

}

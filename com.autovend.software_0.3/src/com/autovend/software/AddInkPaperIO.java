package com.autovend.software;
import com.autovend.devices.ReceiptPrinter;
import com.autovend.devices.SelfCheckoutStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInkPaperIO extends JFrame {
	private AttendantIO parent;
	private JTextField ink;
	private JTextField paper;

	private JButton inkButton;
	private JButton paperButton; 
	private JButton backButton;

	private JPanel inkPanel;
	private JPanel paperPanel;
	private JPanel mainPanel;

	private SelfCheckoutStation[] stations;
	private ReceiptPrinter currentPrinter;
	public AddInkPaperIO(AttendantIO parent, SelfCheckoutStation[] stations)
	{
		this.parent = parent;
		this.stations = stations;
		JFrame frame = new JFrame("Add Ink Paper");
		JPanel paperPanel = new JPanel();
		JPanel inkPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel backPanel = new JPanel();

		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				parent.displayMainScreen();
			}
		});
		backPanel.add(backButton);

		JLabel inkLable = new JLabel("Ink:");
		JLabel paperLable = new JLabel("Paper:");
		setMinimumSize(new Dimension(600,400));

		ink = new JTextField(20);
		paper = new JTextField(20);

		inkButton = new JButton("Add Ink");
		inkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					currentPrinter.addPaper(Integer.parseInt(ink.getText()));
				}
				catch(Exception exception)
				{
					int y = 0;
				}
			}
		});

		paperButton = new JButton("Add Paper"); 
		paperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					currentPrinter.addPaper(Integer.parseInt(paper.getText()));
				}
				catch(Exception exception)
				{
					int y = 0;
				}
			}
		});

		paperPanel.add(paperLable);
		paperPanel.add(paper);
		paperPanel.add(paperButton);
		
		inkPanel.add(inkLable);
		inkPanel.add(ink);
		inkPanel.add(inkButton);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(inkPanel, BorderLayout.NORTH);
		mainPanel.add(paperPanel, BorderLayout.CENTER);
		mainPanel.add(backPanel, BorderLayout.SOUTH);
		
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();

	}
	public void pickStation(int station)
	{

		currentPrinter = stations[station].printer;
	}
}

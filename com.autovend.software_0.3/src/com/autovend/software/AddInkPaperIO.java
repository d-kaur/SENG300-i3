package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInkPaperIO extends JFrame {
	private JTextField ink;
	private JTextField paper;

	private JButton inkButton;
	private JButton paperButton; 
	private JPanel inkPanel;
	private JPanel paperPanel;

	
	public AddInkPaperIO(AttendantIO parent)
	{
	
		JPanel paperPanel = new JPanel();
		JLabel inkLable = new JLabel("Ink:");
		JLabel paperLable = new JLabel("Paper:");
		setMinimumSize(new Dimension(600,400));

		ink = new JTextField(20);
		paper = new JTextField(20);

		inkButton = new JButton("Add Ink");
		paperButton = new JButton("Add Paper"); 

		

	}
}

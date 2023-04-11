package com.autovend.software;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemAttendant extends JFrame{
	private JButton back = new JButton("back");
	public AddItemAttendant(AttendantIO parent)
	{
		super("Add I tem By Text");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.displayMainScreen();
			}
		});
		add(back);
	}

}

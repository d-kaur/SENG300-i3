package com.autovend.software;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBankNotes extends JFrame{
	private AttendantIO parent;
	private JButton back = new JButton("back");
	public  ChangeBankNotes (AttendantIO parent){
		this.parent = parent;
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.displayMainScreen();
			}
		});
		add(back);
	}
	

}

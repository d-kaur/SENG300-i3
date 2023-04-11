/**
 * 
 */
package com.autovend.software;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wasay
 *
 */
public class RemoveItem extends JFrame{
	private AttendantIO parent;
	private JButton back;
	public RemoveItem(AttendantIO parent) {
		this.parent = parent;
		back = new JButton("back");
		back.addActionListener(new ActionListener() {

								   @Override
								   public void actionPerformed(ActionEvent e) {
									   parent.displayMainScreen();
								   }
							   }
		);
		add(back);

	}
}

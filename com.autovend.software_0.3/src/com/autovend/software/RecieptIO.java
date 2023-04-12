
package com.autovend.software;
import javax.annotation.processing.Messager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecieptIO extends JFrame
{
	private PayIO parent;
	private PurchasedItems list;
	private String recieptMessage;
	private JLabel message;
	private JButton back = new JButton("back");
	public RecieptIO(PurchasedItems list, PayIO parent)
	{
		super("Reciept:");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				done();
			}
		});
		message = new JLabel();

		add(message);
		add(back);
		this.parent = parent;
		this.list = list;
	}
	
	
	
	private void done()
	{
		parent.done();
	}
	
	
}
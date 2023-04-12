
package com.autovend.software;
import javax.annotation.processing.Messager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecieptIO extends JFrame
{
	private PayIO parent;
	
	private String recieptMessage;
	private JLabel message;
	private JButton back = new JButton("back");
	public RecieptIO(PayIO parent)
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
	}
	
	
	
	private void done()
	{
		parent.done();
	}
	
	
}
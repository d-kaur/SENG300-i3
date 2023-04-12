
package com.autovend.software;
import javax.annotation.processing.Messager;
import javax.swing.*;

import com.autovend.products.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RecieptIO extends JFrame
{
	private PayIO parent;
	
	private String recieptMessage;
	private JLabel message;
	private JButton back = new JButton("back");
	public RecieptIO(PayIO parent)
	{


		super("Reciept:");

		ArrayList<String> products = PurchasedItems.getNames();
		
		String all = "";
		for(String s: products)
		{
			all += s + new String("\n");

		}
		all += PurchasedItems.getTotalPrice().toString();
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				done();
			}
		});
		message = new JLabel(all);



		add(message);
		add(back);
		this.parent = parent;
	}
	
	
	
	private void done()
	{
		parent.done();
	}
	
	
}
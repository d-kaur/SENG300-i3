
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
		JFrame frame = new JFrame();
		JPanel messagePanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel backPanel = new JPanel();
		setMinimumSize(new Dimension(600,400));

		ArrayList<String> products = PurchasedItems.getNames();
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

		String all = "";
		for(String s: products)
		{
			messagePanel.add(new JLabel( s+ new String("\n")));

		}
		messagePanel.add(new JLabel( new String("$") + PurchasedItems.getTotalPrice().toString()));
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				done();
			}
		});
		message = new JLabel(all);





		messagePanel.add(message);
		backPanel.add(back);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(messagePanel, BorderLayout.CENTER);
		mainPanel.add(backPanel, BorderLayout.SOUTH);
		this.parent = parent;

		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();
	}
	
	
	
	private void done()
	{
		parent.done();
	}
	
	
}
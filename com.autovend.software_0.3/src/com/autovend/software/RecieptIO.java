
package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecieptIO extends JFrame
{
	private PayIO parent;
	private PurchasedItems list;
	private String recieptMessage;
	
	public RecieptIO(PurchasedItems list, PayIO parent)
	{
		this.parent = parent;
		this.list = list;
	}
	
	
	
	private void done()
	{
		parent.done();
	}
	
	
}
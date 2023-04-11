
package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecieptIO extends JFrame
{
	private Pay parent;
	private String recieptMessage;
	
	public RecieptIO(String message, Pay parent)
	{
		this.parent = parent;
		recieptMessage = message;
	}
	
	
	
	private void done()
	{
		parent.done();
	}
	
	
}
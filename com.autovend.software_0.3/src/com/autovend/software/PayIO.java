

package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayIO extends JFrame
{
	private PayWithGiftCardIO giftCard;
	private PayWithDebitIO debitCard;
	private PayWithCashIO cash;
	private PurchasedItems itemsbought;
	private RecieptIO reciept;
	private CustomerIO parent;
	private JButton back = new JButton("back");
	public PayIO(PurchasedItems itemsbought, SelfCheckoutStation scs, CustomerIO parent)
	{
		this.itemsbought = itemsbought;
		this.parent = parent;
		giftCard = new PayWithGiftCardIO("Pay Gift",scs,itemsbought,this);
		debitCard = new PayWithDebitIO("Pay Card",scs,itemsbought,this);
		cash = new PayWithCashIO("Pay Cash",scs,itemsbought,this);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showMainScreen();
			}
		});
		add(back);
		//add(mainScreen);
		//add(giftCard);
		//add(debitCard);
		//add(cash);
		showMainScreen();
		
	}
	private void setAllInvisble()
	{
		setVisible(false);
		giftCard.setVisible(false);
		debitCard.setVisible(false);
		cash.setVisible(false);
	}
	public void showMainScreen()
	{
		setAllInvisble();
		setVisible(true);
	}
	public void showDebitScreen()
	{
		setAllInvisble();
		debitCard.setVisible(true);
	}
	public void showGiftScreen()
	{
		setAllInvisble();
		giftCard.setVisible(true);
	}
	public void showCashScreen()
	{
		setAllInvisble();
		cash.setVisible(true);
	}
	public void showReciept()
	{
		setAllInvisble();
		reciept = new RecieptIO(itemsbought,this);
		add(reciept);
		reciept.setVisible(true);
	}
	public void done()
	{
		parent.done();
	}
	private void back()
	{
		parent.showMainScreen();
	}
	
}
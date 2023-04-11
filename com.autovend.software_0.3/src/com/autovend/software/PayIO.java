

package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayIO extends JFrame
{
	private JFrame mainScreen;
	private PayGiftCardIO giftCard;
	private PayDebitIO debitCard;
	private PayCashIO cash;
	private PurchasedItems itemsbought;
	private RecieptIO reciept;
	public PayIO(PurchasedItems itemsbought)
	{
		this.itemsbought = itemsbought;
		
		
		add(mainScreen);
		add(giftCard);
		add(debitCard);
		add(cash);
	
		
	}
	private setAllInvisble()
	{
		mainScreen.setVisible(false);
		giftCard.setVisible(false);
		debitCard.setVisible(false);
		cash.setVisible(false);
	}
	public showMainScreen()
	{
		setAllInvisble();
		mainScreen.setVisible(true);
	}
	public showDebitScreen()
	{
		setAllInvisble();
		debitCard.setVisible(true);
	}
	public showGiftScreen()
	{
		setAllInvisble();
		giftCard.setVisible(true);
	}
	public showCashScreen()
	{
		setAllInvisble();
		cash.setVisible(true);
	}
	public showReciept()
	{
		setAllInvsible();
		reciept = new RecieptIO(this,itemsbought);
		add(reciept);
		reciept.setVisible(true);
	}
	public done()
	{
		parent.done()
	}
	
	
}

package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayCashIO extends JFrame, Pay
{

	public PayCashIO(PurchasedItems itemsbought,)
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
	
}
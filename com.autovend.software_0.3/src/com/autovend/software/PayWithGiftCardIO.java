
package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayWithGiftCardIO extends  PayGUI
{
	private JButton back = new JButton("back");
	 public PayWithGiftCardIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
			super(msg,station,list,parent);
			back.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

				}
			});
		}
}
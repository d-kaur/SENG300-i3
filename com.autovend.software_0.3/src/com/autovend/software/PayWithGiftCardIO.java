
package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayWithGiftCardIO extends  PayGUI
{
	
	 public PayWithGiftCardIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
			super(msg,station,list,parent);
		}
}
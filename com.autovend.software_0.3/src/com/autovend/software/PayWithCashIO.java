
package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayWithCashIO extends PayGUI
{

	 public PayWithCashIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
			super(msg,station,list,parent);
		}
}
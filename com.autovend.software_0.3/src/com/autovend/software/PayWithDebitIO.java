package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;

public class PayWithDebitIO extends PayGUI{
    public PayWithDebitIO(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
		super(msg,station,list,parent);
	}
}
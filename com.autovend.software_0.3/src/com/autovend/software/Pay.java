
package com.autovend.software;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;

import com.autovend.devices.AbstractDevice;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.SimulationException;
import com.autovend.software.observers.PayObserver;


public abstract class Pay{
    protected SelfCheckoutStation station;
    protected BigDecimal amountDue;
    protected PurchasedItems itemsBought;
    protected BigDecimal amountPaid;
    protected PayIO parent;
    public Pay( SelfCheckoutStation station, PurchasedItems list) {
    	if (station == null) {
            throw new SimulationException(new NullPointerException("Station cannot be null."));
        }
        this.station = station;
        this.parent = parent;
        itemsBought = list;
        amountPaid = new BigDecimal(0);
        amountDue = itemsBought.getAmountLeftToPay();
    }

    protected void pay(BigDecimal amountToPay) {
        itemsBought.addAmountPaid(amountToPay);
        BigDecimal amountPaid = itemsBought.getAmountPaid();
    	if (amountPaid.equals(amountDue)) {
    		//for (PayObserver observer : observers) {
    		//	observer.reactToSufficientPaymentEvent(this);
    		//}
    	}
    }

    public BigDecimal getAmountDue() {
        return itemsBought.getAmountLeftToPay();
    }
}

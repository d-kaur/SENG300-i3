
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

    protected BigDecimal amountPaid;
    protected PayIO parent;
    public Pay( SelfCheckoutStation station) {
    	if (station == null) {
            throw new SimulationException(new NullPointerException("Station cannot be null."));
        }
        this.station = station;
        this.parent = parent;
        amountPaid = new BigDecimal(0);
        amountDue = PurchasedItems.getAmountLeftToPay();
    }

    protected void pay(BigDecimal amountToPay) {
    	PurchasedItems.addAmountPaid(amountToPay);
        BigDecimal amountPaid = PurchasedItems.getAmountPaid();
    	
    }

    public BigDecimal getAmountDue() {
        return PurchasedItems.getAmountLeftToPay();
    }
}

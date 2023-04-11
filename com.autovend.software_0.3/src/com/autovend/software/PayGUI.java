/** Members for Iteration 2:
 * Ethan Oke (30142180)
 * Jose Camilo Lozano Cetina (30144736)
 * Quinn Leonard (30145315)
 * Efren Garcia (30146181)
 * Nam Anh Vu (30127597)
 * Tyler Nguyen (30158563)
 * Victor Han (30112492)
 * Francisco Huayhualla (30091238)
 * Md Minhazur Rahman Hamim (30145446)
 * Imran Haji (30141571)
 * Sara Dhuka (30124117)
 * Robert (William) Engel (30119608)
 */

package com.autovend.software;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;

import com.autovend.devices.AbstractDevice;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.SimulationException;
import com.autovend.software.observers.PayObserver;


public abstract class PayGUI extends JFrame{
    protected SelfCheckoutStation station;
    protected BigDecimal amountDue;
    protected PurchasedItems itemsBought;
    protected BigDecimal amountPaid;
    protected PayIO parent;
    public PayGUI(String msg, SelfCheckoutStation station, PurchasedItems list, PayIO parent) {
        super(msg);
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
    protected void back()
    {
    	
    }
    public void done() {
    	parent.done();
    }
    public BigDecimal getAmountDue() {
        return itemsBought.getAmountLeftToPay();
    }
}

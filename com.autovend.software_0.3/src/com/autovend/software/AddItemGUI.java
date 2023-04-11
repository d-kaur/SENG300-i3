
package com.autovend.software;


import java.awt.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.PriceLookUpCodedUnit;
import com.autovend.devices.Keyboard;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.PLUCodedProduct;
import com.autovend.software.observers.ElectronicScaleObserverStub;
import com.autovend.software.observers.KeyBoardObserverStub;

/**
 * Wasay Siddiqi
 *
 */
public abstract class AddItemGUI extends JFrame{
	protected CustomerIO parent;
	protected SelfCheckoutStation check;
	
	
	protected JButton back = new JButton("back");
	public AddItemGUI(CustomerIO parent,String msg, SelfCheckoutStation check) {
		super(msg);
		this.parent = parent;
		this.check = check;

	}
	
	protected void back() {
		parent.showMainScreen();
	}
	
	
	
	
	
}
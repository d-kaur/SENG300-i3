/**
 * 
 */
package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;

/**
 * @author wasay
 *
 */
public class AddItemTextGUI extends AddItemGUI{

	public AddItemTextGUI(CustomerIO parent, SelfCheckoutStation scs)
	{
		super(parent,"Add Item Text",scs);
		add(back);
	}
}

/**
 * 
 */
package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;

/**
 * @author wasay
 *
 */
public class AddItemBrowseGUI extends AddItemGUI{
	public AddItemBrowseGUI(CustomerIO parent, SelfCheckoutStation scs)
	{
		super(parent,"Add Item Text", scs);
	}
}

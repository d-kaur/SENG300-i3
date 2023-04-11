package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;

public class AddScanItemGUI extends AddItemGUI{
    public AddScanItemGUI(CustomerIO parent, SelfCheckoutStation scs)
    {
        super(parent,"Add Item Text",scs);
        add(back);
    }
}

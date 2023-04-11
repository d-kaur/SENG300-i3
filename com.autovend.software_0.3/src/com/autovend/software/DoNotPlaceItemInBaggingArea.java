package com.autovend.software;

import javax.swing.JLabel;

import com.autovend.devices.SelfCheckoutStation;

public class DoNotPlaceItemInBaggingArea extends AddItem{
	private AttendantMainGUI Agui;
    private CustomerMainGUI Cgui;
	


	public DoNotPlaceItemInBaggingArea(SelfCheckoutStation scs) {
		super(scs);
	}
	
	public void OptionSelected() {
		super.check.handheldScanner.disable();
        super.check.mainScanner.disable();
        // need to disable screen?
		//needs to specify which station?
        Agui.showAlert("Do not place item in bagging area selected");
		
	}
	
	public void OptionApproved() {
		
	}

}

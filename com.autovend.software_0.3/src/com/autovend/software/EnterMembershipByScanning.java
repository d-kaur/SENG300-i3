package com.autovend.software;

import com.autovend.Barcode;
import com.autovend.devices.AbstractDevice;
import com.autovend.devices.BarcodeScanner;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.observers.AbstractDeviceObserver;
import com.autovend.devices.observers.BarcodeScannerObserver;

public class EnterMembershipByScanning extends Membership implements BarcodeScannerObserver {

	public EnterMembershipByScanning(SelfCheckoutStation selfCheckoutStation) {
		super(selfCheckoutStation);

	}

	@Override
	public void reactToEnabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactToDisabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactToBarcodeScannedEvent(BarcodeScanner barcodeScanner, Barcode barcode) {
		try {
			MemberData member = lookupMember(barcode.toString());
			// Display member info on GUI or whatever
		} catch (Exception e) {
			// Display member not found on GUI or whatever
		}
	}

}

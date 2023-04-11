package com.autovend.software;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.SupervisionStation;

public class SoftwareStationManager extends SelfCheckoutStation {
	
	
	public SoftwareStationManager(Currency currency, int[] billDenominations, BigDecimal[] coinDenominations,
			int scaleMaximumWeight, int scaleSensitivity) {
		super(currency, billDenominations, coinDenominations, scaleMaximumWeight, scaleSensitivity);
		// TODO Auto-generated constructor stub
		isEnabled = true;
	
	}
	

	private Boolean isEnabled;
	
	// todo change to private
	public ArrayList<SupervisionStation> supervisedStations;
	
	
	
//	find the object
	
	
//	we have selfcheckout stations and method to add them to supervisor
	
//	one approach could be keeping a list of currently disabled devices and enabled ones
	
	
	public void listStations() {
		SupervisionStation station1 = new SupervisionStation();
		
		supervisedStations.add(station1);
		
		
		System.out.println("station name = " + supervisedStations );
		
	}

}

/**
 * 
 */
package com.autovend.software;

import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.PriceLookUpCodedUnit;
import com.autovend.SellableUnit;
import com.autovend.devices.Keyboard;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.observers.ElectronicScaleObserver;
import com.autovend.devices.observers.KeyboardObserver;
import com.autovend.devices.observers.TouchScreenObserver;
import com.autovend.external.ProductDatabases;
import com.autovend.products.PLUCodedProduct;
import com.autovend.software.observers.AddItemObserver;
import com.autovend.software.observers.ElectronicScaleObserverStub;
import com.autovend.software.observers.KeyBoardObserverStub;

/**
 * @author wasay
 *
 */
public class AddItemByPLU extends AddItem{
	
	SelfCheckoutStation station;
	/**
	 * Constructor enables scale from SelfCheckoutStation.
	 * @param scs
	 */
	
	public AddItemByPLU(SelfCheckoutStation scs) {
		super(scs);
		station = scs;
		station.scale.enable();		
	}

	
	/**
	 * Method for adding the item using PLU
	 * @param PLUStr: PriceLookUp - String
	 * 
	 */
	public boolean setPLU(String PLUStr) {
		// initialize keyboard and observers
		KeyBoardObserverStub obs = new KeyBoardObserverStub();
		Keyboard keyboard = new Keyboard();
		keyboard.enable();
		keyboard.register(obs); // keyboard obs
		obs.reactToEnabledEvent(keyboard);
		ElectronicScaleObserverStub scaleObs = new ElectronicScaleObserverStub();
		
		String[] PLUStrArr = PLUStr.split("");
		if(PLUStrArr.length != 4) {//plu can only have 4 digits
			return false;
		}
		// observers react to keyboard actions 
		char PLUChar [] = PLUStr.toCharArray();
		for (int i = 0; i<PLUChar.length; i++) {
			keyboard.pressKey(PLUChar[i]);
			obs.reactToKeyPressedEvent(keyboard, PLUChar[i]);
		}
		keyboard.disable();
		obs.reactToDisabledEvent(keyboard);
		keyboard.deregister(obs);
		
		// Convert pluString to numeral
		Numeral [] pluArr = new Numeral[PLUStrArr.length];
		for (int i=0; i<PLUStrArr.length; i++) {
			byte temp = (byte) Integer.parseInt(PLUStrArr[i]);
			pluArr[i] = Numeral.valueOf(temp);
		}
		PriceLookUpCode plu = new PriceLookUpCode(pluArr);
		
		// Item is purchased (and scale observer is enabled) if it exists in the data base, 
		if(ProductDatabases.PLU_PRODUCT_DATABASE.containsKey(plu)) {
			station.scale.enable();
			scaleObs.reactToEnabledEvent(station.scale);
			
			PLUCodedProduct p = ProductDatabases.PLU_PRODUCT_DATABASE.get(plu);
			PriceLookUpCodedUnit unit = new PriceLookUpCodedUnit(p.getPLUCode(), 1.5);
			station.scale.add(unit);
			scaleObs.reactToWeightChangedEvent(station.scale, unit.getWeight());
			addPLUProduct(p);
			station.scale.disable();
			scaleObs.reactToDisabledEvent(station.scale);
			return true;
		}else
			return false;
	}
}

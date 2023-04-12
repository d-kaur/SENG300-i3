/**
 * 
 */
package com.autovend.software;

import java.util.ArrayList;

import com.autovend.Barcode;
import com.autovend.PriceLookUpCode;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.products.PLUCodedProduct;

/**d
 * @author wasay
 *
 */
public class AddItemByBrowsing extends AddItem {

	public AddItemByBrowsing(SelfCheckoutStation scs) {
		super(scs);
		
	}
	public boolean AddBrowsedItem(String name) {
		ArrayList <Barcode> codes = (ArrayList<Barcode>) ProductDatabases.BARCODED_PRODUCT_DATABASE.keySet();
		BarcodedProduct foundBarcode = null;
		for (int i=0; i<codes.size(); i++) {
			BarcodedProduct temp = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(codes.get(i));
			if(temp.getDescription().equals(name)) {
				foundBarcode = temp;
			}
		}
		
		ArrayList <PriceLookUpCode> PLUcodes = (ArrayList<PriceLookUpCode>) ProductDatabases.PLU_PRODUCT_DATABASE.keySet();
		PLUCodedProduct foundPLU = null;
		if(!name.isBlank()) {
			for (int i=0; i<codes.size(); i++) {
				PLUCodedProduct temp = ProductDatabases.PLU_PRODUCT_DATABASE.get(codes.get(i));
				if(temp.getDescription().equals(name)) {
					foundPLU = temp;

				}
			}
		}
		if(foundBarcode != null && foundPLU == null) {
			PurchasedItems.addProduct(foundBarcode);
			return true;
		}else if (foundPLU != null && foundBarcode == null) {
			PurchasedItems.addPLUProduct(foundPLU, 1.5);
			return true;
		}else 
			return false;
		
	}

	/**
	 * 
	 */
	

}

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

/**
 * @author w
 *
 */
public class AddItemByBrowsing extends AddItem {
	
	/**
	 * Constructor for the class, immediately moves to it's superclass
	 * @param scs
	 */
	public AddItemByBrowsing(SelfCheckoutStation scs) {
		super(scs);
		
	}
	
	/**
	 * Method for adding an item that the user wrote in text
	 * @param name - the name of the item to purchase given by the user 
	 * @return true - item found and added into the list of purchased items
	 */
	public boolean AddBrowsedItem(String name) {
		ArrayList <Barcode> barcodes = new ArrayList<Barcode>(); 
		barcodes.addAll(ProductDatabases.BARCODED_PRODUCT_DATABASE.keySet());
		
		ArrayList <PriceLookUpCode> PLUcodes = new ArrayList<PriceLookUpCode>(); 
		PLUcodes.addAll(ProductDatabases.PLU_PRODUCT_DATABASE.keySet());

		BarcodedProduct foundBarcode = null;
		PLUCodedProduct foundPLU = null;
		
		if(!(name.isEmpty())) {
			
			for (int i=0; i<barcodes.size(); i++) {
				BarcodedProduct temp = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcodes.get(i));
				if(temp.getDescription().equals(name)) {
					foundBarcode = temp;
				}
			}
		
			for (int i=0; i<PLUcodes.size(); i++) {
				PLUCodedProduct temp = ProductDatabases.PLU_PRODUCT_DATABASE.get(PLUcodes.get(i));

				if(temp.getDescription().equals(name)) {
					foundPLU = temp;

				}
			}
			
		}
		if(foundBarcode != null && foundPLU == null) {
			PurchasedItems.addProduct(foundBarcode);
			return true;
		}else if (foundPLU != null && foundBarcode == null) {
			PurchasedItems.addPLUProduct(foundPLU, 1.0);
			return true;
		}else 
			return false;
		
	}

	/**
	 * 
	 */
	

}

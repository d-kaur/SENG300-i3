package com.autovend.software;

import java.math.BigDecimal;

import javax.swing.JLabel;

import com.autovend.Barcode;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.products.BarcodedProduct;
import com.autovend.products.Product;

public class DoNotPlaceItemInBaggingArea extends AddItem{
	private BarcodedProduct prod;
	private AttendantMainGUI Agui;
    private CustomerMainGUI Cgui;
	


	public DoNotPlaceItemInBaggingArea(SelfCheckoutStation scs) {
		super(scs);
	}
	
	public void OptionSelected(BarcodedProduct product) {
		// Block System
		super.check.handheldScanner.disable();
        super.check.mainScanner.disable();
        this.prod = product;
        // need to disable gui
        Agui.showAlert("Do not place item in bagging area selected");
		
	}
	
	public void OptionApproved() {
		//updated the item list so that the item is the same except the expected weight does not include the items weight.
		if (!prod.equals(null)) {
			if (prod.equals(PurchasedItems.getListOfProducts().get(PurchasedItems.getListOfProducts().size()-1))) {
				BarcodedProduct newprod = new BarcodedProduct(prod.getBarcode(), prod.getDescription(), prod.getPrice() , 0.0);
				PurchasedItems.removeProduct(prod);
				PurchasedItems.addProduct(newprod);
				prod = null;
			}

		}
		super.check.handheldScanner.enable();
		super.check.mainScanner.enable();
	}

}

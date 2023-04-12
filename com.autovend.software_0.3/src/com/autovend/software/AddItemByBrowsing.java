package com.autovend.software;

import java.util.ArrayList;
import java.util.List;

import com.autovend.BarcodedUnit;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.software.observers.CustomerIOStub;
import com.autovend.software.observers.ElectronicScaleObserverStub;

public class AddItemByBrowsing extends AddItem{
	
	private SelfCheckoutStation station;
	private PurchasedItems purchaseList;
	private final BarcodedProduct[] barcode_products = ProductDatabases.BARCODED_PRODUCT_DATABASE.values()
			.toArray(new BarcodedProduct[0]);

	
	public AddItemByBrowsing(SelfCheckoutStation scs) {
		super(scs);
		this.station = scs;
		PurchasedItems purchasedItems = new PurchasedItems();
		station.scale.enable();	
		this.purchaseList = purchasedItems;
	}

	public PurchasedItems getPurchasedItems() {
		return this.purchaseList;
	}
	
	public String[] searchItems(String keyword) {

		List<String> descriptions = new ArrayList<>();
		for (BarcodedProduct p : barcode_products) {
			if (p.getDescription().contains(keyword)) {
				descriptions.add(p.getDescription());
			}
		}
		return descriptions.toArray(new String[0]);
	}
	
	public void setBrowsing(String BrowsingStr) {
		//Electronic Scale
		ElectronicScaleObserverStub scaleObs = new ElectronicScaleObserverStub();
		
		// find the selected products information
		BarcodedProduct product = null;
		for (BarcodedProduct p : barcode_products) {
			if (p.getDescription().equals(BrowsingStr)) {
				product = p;
				break;
			}
		}
		
		// signals to customer to place 
		BarcodedUnit unit = new BarcodedUnit(product.getBarcode(), product.getExpectedWeight());
		CustomerIOStub.itemHasBeenScannedEvent(this.station, unit);
			
		// add the product
		addBarcodedProduct(product);
				
		// disable station from further input
		station.scale.disable();
		scaleObs.reactToDisabledEvent(station.scale);

		// react to weight Change
		scaleObs.reactToWeightChangedEvent(station.scale, unit.getWeight());

		// unblock the station
		station.scale.enable();
		scaleObs.reactToEnabledEvent(station.scale);
			
	}
}

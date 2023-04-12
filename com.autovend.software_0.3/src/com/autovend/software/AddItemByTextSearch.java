/**
 * 
 */
package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;

/**
 * @author bheesha kumari - 30158810
 *
 */

public class AddItemByTextSearch extends AddItem {

	private SelfCheckoutStation selfCheckoutStation;
	private PurchasedItems purchaseList;
	private final BarcodedProduct[] barcode_products = ProductDatabases.BARCODED_PRODUCT_DATABASE.values()
			.toArray(new BarcodedProduct[0]);


	public AddItemByTextSearch(SelfCheckoutStation check) {
		super(check);
		PurchasedItems purchasedItems = new PurchasedItems();
		this.selfCheckoutStation = check;
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


	public void addItem(String description) {

		// Finding the product
		BarcodedProduct product = null;
		for (BarcodedProduct p : barcode_products) {
			if (p.getDescription().equals(description)) {
				product = p;
				break;
			}
		}

		// 5. Blocks the self-checkout station from further customer interaction
		selfCheckoutStation.handheldScanner.disable();
		selfCheckoutStation.mainScanner.disable();

		// 6. Adds the product
		PurchasedItems.addProduct(product);

		// 7. System: Signals to the Customer I/O to place the scanned item in the Bagging Area.
		BarcodedUnit scannedUnit = new BarcodedUnit(product.getBarcode(), product.getExpectedWeight());
		CustomerIOStub.itemHasBeenScannedEvent(this.selfCheckoutStation, scannedUnit);

		// 6. Signals to the system that the weight has changed.


		// 9. unblock the station
		selfCheckoutStation.handheldScanner.enable();
		selfCheckoutStation.mainScanner.enable();

	}

}

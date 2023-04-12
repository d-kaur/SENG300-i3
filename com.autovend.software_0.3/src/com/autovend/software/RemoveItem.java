/**
 * 
 */
package com.autovend.software;

/**
 * @author wasay
 * bheesha kumari 30148810
 *
 */
public class RemoveItem {

    private SelfCheckoutStation selfCheckoutStation;
    private PurchasedItems purchaseList;

    public RemoveItem(SelfCheckoutStation check) {
        PurchasedItems purchasedItems = new PurchasedItems();
        this.selfCheckoutStation = check;
        this.purchaseList = purchasedItems;
    }

    public PurchasedItems getPurchasedItems() {
        return this.purchaseList;
    }

    public void removeItem(BarcodedProduct product) {

        // 2. Blocks the self-checkout station from further customer interaction
        selfCheckoutStation.handheldScanner.disable();
        selfCheckoutStation.mainScanner.disable();

        // 3. removes the product
        PurchasedItems.removeProduct(product);

        // 4. Signals the Attendant I/O

        // 5. System: Signals to the Customer I/O to place the scanned item in the
        // Bagging Area.
        BarcodedUnit scannedUnit = new BarcodedUnit(product.getBarcode(), product.getExpectedWeight());
        CustomerIOStub.itemHasBeenScannedEvent(this.selfCheckoutStation, scannedUnit);

        // 6. unblock the station
        selfCheckoutStation.handheldScanner.enable();
        selfCheckoutStation.mainScanner.enable();

    }



}

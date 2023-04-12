package com.autovend.software.test;

/** Bheesha Kumari - 30158810
 *
 */

import java.math.BigDecimal;
import java.util.*;

import com.autovend.products.Product;
import com.autovend.software.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.autovend.Barcode;
import com.autovend.BarcodedUnit;
import com.autovend.Numeral;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;

public class RemoveItemTest {

    Currency currency = Currency.getInstance("CAD");
    int[] billDenominations = {1, 2, 5, 10};
    BigDecimal[] coinDenominations = {BigDecimal.TEN};
    private SelfCheckoutStation selfCheckoutStation;
    private BigDecimal price1, price2, price3;
    private Double weight1, weight2, weight3;
    private String description1, description2, description3;
    private BarcodedProduct itemProduct1, itemProduct2, itemProduct3;
    private BarcodedUnit unitItem1, unitItem2, unitItem3;
    private BigDecimal expectedCartPrice;
    private int maxScaleWeight, sensitivity;
    private double expectedBaggingWeight;
    private ScanItems scanItems;
    private WeightDiscrepancy weightDiscrepancy;
    private ArrayList<BarcodedProduct> itemList;
    private boolean scanFailed1, scanFailed2, scanFailed3;
    private RemoveItem removeItem;

    // initializing some barcodes to use during tests
    Numeral[] n = {Numeral.one, Numeral.two, Numeral.three};
    Numeral[] m = {Numeral.two, Numeral.three, Numeral.one};
    Numeral[] k = {Numeral.three, Numeral.two, Numeral.one};
    Barcode b1 = new Barcode(n);
    Barcode b2 = new Barcode(m);
    Barcode b3 = new Barcode(k);

    @Before
    public void setUp() {
        // expectedCartPrice at start is 0 before scanning anything
        expectedCartPrice = new BigDecimal(0);
        expectedBaggingWeight = 0.0;
        itemList = new ArrayList<BarcodedProduct>();

        // initialize a few prices
        price1 = new BigDecimal(2.00);
        price2 = new BigDecimal(3.00);
        price3 = new BigDecimal(4.50);

        //initialize a few weights
        weight1 = 2.0;
        weight2 = 3.5;
        weight3 = 12.0;

        // initialize a few descriptions
        description1 = "item1";
        description2 = "item2";
        description3 = "item3";

        scanFailed1 = false;
        scanFailed2 = false;
        scanFailed3 = false;

        //initialize some products
        itemProduct1 = new BarcodedProduct(b1, description1, price1, weight1);
        itemProduct2 = new BarcodedProduct(b2, description2, price2, weight2);
        itemProduct3 = new BarcodedProduct(b3, description3, price3, weight3);

        // initialize some units associated with the barcodes
        unitItem1 = new BarcodedUnit(b1, weight1);
        unitItem2 = new BarcodedUnit(b2, weight2);
        unitItem3 = new BarcodedUnit(b3, weight3);

        // add the products to the database to access
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(b1, itemProduct1);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(b2, itemProduct2);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(b3, itemProduct3);

        PurchasedItems.addProduct(itemProduct1);
        PurchasedItems.addProduct(itemProduct2);
        PurchasedItems.addProduct(itemProduct3);

        maxScaleWeight = 10;
        sensitivity = 1;

        // create the station
        selfCheckoutStation = new SelfCheckoutStation(currency, billDenominations, coinDenominations, maxScaleWeight, sensitivity);

        // initialize constructor and add each product to the list of products being scanned
        scanItems = new ScanItems(selfCheckoutStation);
        weightDiscrepancy = new WeightDiscrepancy(selfCheckoutStation);

        //register the observer and enable scanners
        selfCheckoutStation.mainScanner.enable();
        selfCheckoutStation.mainScanner.register(scanItems);
        selfCheckoutStation.handheldScanner.enable();
        selfCheckoutStation.handheldScanner.register(scanItems);
        selfCheckoutStation.baggingArea.register(weightDiscrepancy);

        removeItem = new RemoveItem(selfCheckoutStation);
    }

    @After
    public void tearDown() {
        selfCheckoutStation = null;
        PurchasedItems.reset();
    }

    @Test
    public void assertAllItems() {
        // get purchased items
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // initially, we have all items
        List<BarcodedProduct> expected = Arrays.asList(itemProduct1, itemProduct2, itemProduct3);

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void removeItemTest_item1() {
        // remove item
        removeItem.removeItem(itemProduct1);

        // get purchased items
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // item1 has been removed
        List<BarcodedProduct> expected = Arrays.asList(itemProduct2, itemProduct3);

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void removeItemTest_item2() {
        // remove item
        removeItem.removeItem(itemProduct1);
        removeItem.removeItem(itemProduct2);

        // get purchased items
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // item1, and item 2 has been removed
        List<BarcodedProduct> expected = Arrays.asList(itemProduct3);

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void removeItemTest_item3() {
        // remove item
        removeItem.removeItem(itemProduct1);
        removeItem.removeItem(itemProduct2);
        removeItem.removeItem(itemProduct3);

        // get purchased items
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // no items
        List<BarcodedProduct> expected = Arrays.asList();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}

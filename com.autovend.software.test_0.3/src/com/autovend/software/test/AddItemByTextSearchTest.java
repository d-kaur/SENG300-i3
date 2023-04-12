package com.autovend.software.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.Currency;

import org.junit.*;

import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.PLUCodedProduct;
import com.autovend.software.AddItemByPLU;
import com.autovend.software.AddItemPLUGUI;

/**
 * Bheesha Kumari - 30158810
 */

public class AddItemByTextSearchTest {

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
    private AddItemByTextSearch addItemByTextSearch;

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

        maxScaleWeight = 30;
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

        addItemByTextSearch = new AddItemByTextSearch(selfCheckoutStation);
    }

    @After
    public void tearDown() {
        selfCheckoutStation = null;
        PurchasedItems.reset();
    }

    @Test
    public void testSearchItemsAll() {
        // search by keyword "item"
        String[] actual = addItemByTextSearch.searchItems("item");

        // should return all items
        String[] expected = {"item1", "item2", "item3"};

        // order doesn't matter
        Arrays.sort(actual);
        Arrays.sort(expected);

        // assert
        Assert.assertEquals(expected.length, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchItemsOne() {
        // search by keyword "item1"
        String[] actual = addItemByTextSearch.searchItems("item1");

        // should return {"item1"}
        String[] expected = {"item1"};

        // assert
        Assert.assertEquals(expected.length, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchItemsNone() {
        // search by keyword "no item"
        String[] actual = addItemByTextSearch.searchItems("no item");

        // should return empty array
        String[] expected = {};

        // assert
        Assert.assertEquals(expected.length, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddItem_OneItem() throws OverloadException {
        // add item1
        addItemByTextSearch.addItem("item1");
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // expected
        List<BarcodedProduct> expected = Arrays.asList(itemProduct1);

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        // expected weight
        double expected_weight = itemProduct1.getExpectedWeight();

        // assert weight
        Assert.assertEquals(expected_weight, selfCheckoutStation.baggingArea.getCurrentWeight(), 0.0);
    }

    @Test
    public void testAddItem_TwoItems() throws OverloadException {
        // add item1
        addItemByTextSearch.addItem("item1");
        addItemByTextSearch.addItem("item2");
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // expected
        List<BarcodedProduct> expected = Arrays.asList(itemProduct1, itemProduct2);
        // expected weight
        double expected_weight = itemProduct1.getExpectedWeight() + itemProduct2.getExpectedWeight();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        // assert weight
        Assert.assertEquals(expected_weight, selfCheckoutStation.baggingArea.getCurrentWeight(), 0.0);
    }

    @Test
    public void testAddItem_ThreeItems() throws OverloadException {
        // add item1
        addItemByTextSearch.addItem("item1");
        addItemByTextSearch.addItem("item2");
        addItemByTextSearch.addItem("item3");
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // expected
        List<BarcodedProduct> expected = Arrays.asList(itemProduct1, itemProduct2, itemProduct3);

        // expected weight
        double expected_weight = itemProduct1.getExpectedWeight() + itemProduct2.getExpectedWeight() + itemProduct3.getExpectedWeight();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        // assert weight
        Assert.assertEquals(expected_weight, selfCheckoutStation.baggingArea.getCurrentWeight(), 0.0);

    }

}

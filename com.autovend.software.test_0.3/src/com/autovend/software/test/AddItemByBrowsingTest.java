package com.autovend.software.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.autovend.Barcode;
import com.autovend.BarcodedUnit;
import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.products.PLUCodedProduct;
import com.autovend.software.AddItemByBrowsing;
import com.autovend.software.PurchasedItems;

public class AddItemByBrowsingTest {

	private SelfCheckoutStation station;
	private Numeral[] num = {Numeral.one, Numeral.two, Numeral.three, Numeral.four};
	private PriceLookUpCode pluCode;
    private BigDecimal price1, price2, price3;
    private Double weight1, weight2, weight3;
    private String description1, description2, description3;
    private BarcodedProduct itemProduct1, itemProduct2, itemProduct3;
    private BarcodedUnit unitItem1, unitItem2, unitItem3;
    private BigDecimal expectedCartPrice;
    private ArrayList<BarcodedProduct> itemList;
    private int maxScaleWeight, sensitivity;
    private double expectedBaggingWeight;
	private AddItemByBrowsing addItemByBrowsing;
    private boolean scanFailed1, scanFailed2, scanFailed3;
	
    Numeral[] n = {Numeral.one, Numeral.two, Numeral.three};
    Numeral[] m = {Numeral.two, Numeral.three, Numeral.one};
    Numeral[] k = {Numeral.three, Numeral.two, Numeral.one};
    
    Barcode b1 = new Barcode(n);
    Barcode b2 = new Barcode(m);
    Barcode b3 = new Barcode(k);
	
	@Before
	public void setup() {
		Currency cad = Currency.getInstance("CAD");
		int [] billDeno = {1,5,10,20,50};
		BigDecimal [] coinDeno = {
				BigDecimal.valueOf(0.01),
				BigDecimal.valueOf(0.05),
				BigDecimal.valueOf(0.10),
				BigDecimal.valueOf(0.25),
		};
		station = new SelfCheckoutStation(cad, billDeno, coinDeno, 50, 1);
		
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
	}
	
	
	@Test
	public void addItemTest() {
		addItemByBrowsing.setBrowsing("item1");
		addItemByBrowsing.setBrowsing("item2");
		addItemByBrowsing.setBrowsing("item3");
        List<BarcodedProduct> actual = PurchasedItems.getListOfProducts();

        // expected
        List<BarcodedProduct> expected = Arrays.asList(itemProduct1, itemProduct2, itemProduct3);

        // expected weight
        double expected_weight = itemProduct1.getExpectedWeight() + itemProduct2.getExpectedWeight() + itemProduct3.getExpectedWeight();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        
        // assert weight
        Assert.assertEquals(expected_weight, station.baggingArea.getCurrentWeight(), 0.0);
	
	
	}
}
package com.autovend.software.test;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.autovend.Barcode;
import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.products.PLUCodedProduct;
import com.autovend.software.AddItemByBrowsing;
import com.autovend.software.AddItemByPLU;

public class AddItemByBrowsingTest {
	
	private SelfCheckoutStation station;
	private Numeral[] numPLU = {Numeral.one, Numeral.two, Numeral.three, Numeral.four};
	private Numeral[] numBarcode = {Numeral.seven, Numeral.nine, Numeral.three, Numeral.four, Numeral.nine};
	private PriceLookUpCode pluCode;
	private Barcode barcode;
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
		
		barcode = new Barcode(numBarcode);
		String descBarcode = "Twix";
		BarcodedProduct product = new BarcodedProduct(barcode, descBarcode, BigDecimal.valueOf(1.99), 1);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode, product);
		
		pluCode = new PriceLookUpCode(numPLU);
		String descPLU = "Banana";
		PLUCodedProduct pluProduct = new PLUCodedProduct(pluCode, descPLU, BigDecimal.valueOf(1.99));
		ProductDatabases.PLU_PRODUCT_DATABASE.put(pluCode, pluProduct);
	}
	@Test
	public void addPLUItemTest() {
		AddItemByBrowsing addingItemPLU = new AddItemByBrowsing(station);
		Assert.assertTrue(addingItemPLU.AddBrowsedItem("Banana"));
		Assert.assertFalse(addingItemPLU.AddBrowsedItem("Orange"));
	}
	
	@Test
	public void addBarcodeItemTest() {
		AddItemByBrowsing addingBarcodeItem = new AddItemByBrowsing(station);
		Assert.assertTrue(addingBarcodeItem.AddBrowsedItem("Twix"));
		Assert.assertFalse(addingBarcodeItem.AddBrowsedItem("Oh Henry"));
	}
}

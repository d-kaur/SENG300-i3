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
 * Wasay Siddiqi
 */
public class AddItemByPLUTest {

	private SelfCheckoutStation station;
	private Numeral[] num = {Numeral.one, Numeral.two, Numeral.three, Numeral.four};
	private PriceLookUpCode pluCode;
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
		pluCode = new PriceLookUpCode(num);
		String desc = "A_Test_Item";
		PLUCodedProduct pluProduct = new PLUCodedProduct(pluCode, desc, BigDecimal.valueOf(2.99));
		ProductDatabases.PLU_PRODUCT_DATABASE.put(pluCode, pluProduct);
	}
	
	
	@Test
	public void addItemTest() {
		AddItemByPLU addingItemPLU = new AddItemByPLU(station);
		Assert.assertTrue(addingItemPLU.setPLU("1234"));
		Assert.assertFalse(addingItemPLU.setPLU("6543"));
		Assert.assertFalse(addingItemPLU.setPLU("8"));
	}
	
	
	
}
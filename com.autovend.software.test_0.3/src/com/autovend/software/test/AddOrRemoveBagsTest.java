/** Members for Iteration 2:
 * Ethan Oke (30142180)
 * Jose Camilo Lozano Cetina (30144736)
 * Quinn Leonard (30145315)
 * Efren Garcia (30146181)
 * Nam Anh Vu (30127597)
 * Tyler Nguyen (30158563)
 * Victor Han (30112492)
 * Francisco Huayhualla (30091238)
 * Md Minhazur Rahman Hamim (30145446)
 * Imran Haji (30141571)
 * Sara Dhuka (30124117)
 * Robert (William) Engel (30119608)
 */
package com.autovend.software.test;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

import com.autovend.ReusableBag;
import com.autovend.devices.*;
import org.junit.*;
import com.autovend.software.*;

public class AddOrRemoveBagsTest {
    AddOrRemoveBags addBags;
    SelfCheckoutStation scs;
    ArrayList<ReusableBag> listOfStoreBags = new ArrayList<ReusableBag>();

    ReusableBag bag = new ReusableBag();

    ReusableBagDispenser dispenser = new ReusableBagDispenser(100);

    //sets up for testing

    @Before
    public void setup() throws OverloadException {
        ReusableBag[] bags = new ReusableBag[50];//Load 50 bags in advance
        for (int i = 0; i < 50; i++) {
            bags[i] = new ReusableBag();
        }
        dispenser.load(bags);
        addBags = new AddOrRemoveBags(scs);
        Currency cad = Currency.getInstance("CAD");
		int [] billDeno = {1,5,10,20,50};
		BigDecimal [] coinDeno = {
				BigDecimal.valueOf(0.01),
				BigDecimal.valueOf(0.05),
				BigDecimal.valueOf(0.10),
				BigDecimal.valueOf(0.25),
		};
		scs = new SelfCheckoutStation(cad, billDeno, coinDeno, 50, 1);
    }
    @After
    public void tearDown() {
        addBags = null;
        PurchasedItems.reset();
    }
    //tests if the class is constructed correctly
    @Test
    public void AddOrRemoveBagsConstructorTest() {
        boolean flag;
        try {
            AddOrRemoveBags testConstructor = new AddOrRemoveBags(scs);
            flag = true;
        }
        catch (Exception e) {
            flag = false;
        }
        assertTrue(flag);
    }
    //tests if a bag is added correctly
    @Test
    public void PurchaseFewBag() throws EmptyException {
        addBags.purchaseBag(5);
        assertEquals(5, PurchasedItems.getBagcount());
    }

    @Test
    public void AddOwnBag() {

    }



}

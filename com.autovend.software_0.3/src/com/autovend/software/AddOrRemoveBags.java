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
package com.autovend.software;

import java.math.*;
import java.util.ArrayList;

import com.autovend.devices.*;

import static com.autovend.software.PurchasedItems.addBag;

// extend the Parent class
public class AddOrRemoveBags{

    private ReusableBagDispenser dispenser;
    private SelfCheckoutStation station;

    public AddOrRemoveBags(SelfCheckoutStation scs, ReusableBagDispenser dispenser) {
        this.station = station;
        this.dispenser = dispenser;
    }

    public void purchaseBag(int BagNum) throws EmptyException {
        for (int i = 0; i < BagNum; i++) {
            addBag(dispenser.dispense());
        }
    }

    public void addOwnBag(double bagWeight) {

    }
}

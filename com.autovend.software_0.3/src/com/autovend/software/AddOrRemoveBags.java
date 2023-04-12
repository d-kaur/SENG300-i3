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

import com.autovend.devices.AbstractDevice;
import com.autovend.devices.EmptyException;
import com.autovend.devices.ReusableBagDispenser;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.observers.AbstractDeviceObserver;
import com.autovend.devices.observers.ReusableBagDispenserObserver;

// extend the Parent class
public class AddOrRemoveBags implements ReusableBagDispenserObserver {

    private SelfCheckoutStation station;
    private PurchasedItems purchased;

    public AddOrRemoveBags(SelfCheckoutStation scs, PurchasedItems purchased) {
        this.station = scs;
        this.purchased = purchased;
    }

    public void purchaseBag(int BagNum) throws EmptyException {
        for (int i = 0; i < BagNum; i++) {
            this.purchased.addBag(this.station.bagDispenser.dispense());
        }
    }

    public static boolean addOwnBag(double bagWeight) {
    	if (bagWeight <= 0) {
    		return false;
    	}
		return true;

    }
    @Override
    public void bagDispensed(ReusableBagDispenser dispenser) {
    }

    @Override
    public void outOfBags(ReusableBagDispenser dispenser) {
        System.out.println("Sorry, the bags at the current site are sold out");
    }

    @Override
    public void bagsLoaded(ReusableBagDispenser dispenser, int count) {

    }

    @Override
    public void reactToEnabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
        this.station.bagDispenser.enable();
    }

    @Override
    public void reactToDisabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
        this.station.bagDispenser.disable();
    }
}

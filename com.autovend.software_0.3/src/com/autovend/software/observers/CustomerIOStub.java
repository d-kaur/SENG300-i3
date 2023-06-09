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

package com.autovend.software.observers;

import com.autovend.BarcodedUnit;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;

public class CustomerIOStub {

    public static void itemHasBeenScannedEvent(SelfCheckoutStation selfCheckoutStation, BarcodedUnit scannedUnit) {
        BarcodedProduct itemProduct = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(scannedUnit.getBarcode());
    }



}

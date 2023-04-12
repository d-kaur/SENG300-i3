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

import com.autovend.ReusableBag;
import com.autovend.products.BarcodedProduct;
import com.autovend.products.PLUCodedProduct;
import com.autovend.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
//import java.lang.String.*;

public class PurchasedItems{

    private static ArrayList<Product> listOfProducts;
    private static BigDecimal totalPrice;
    private static double totalExpectedWeight;
    private static BigDecimal change;
    private static BigDecimal amountPaid;
    private static boolean isPaid;
    private static int bagCount;
    private static BigDecimal idealBagPriceInUSD = BigDecimal.valueOf(0.1);

    static {
        listOfProducts = new ArrayList<>();
        bagCount = 0;
        totalPrice = new BigDecimal(0);
        amountPaid = new BigDecimal(0);
        totalExpectedWeight = 0;
        change = new BigDecimal(0);
        isPaid = false;
    }

    public static void addProduct(BarcodedProduct product){
        listOfProducts.add(product);
        totalPrice = totalPrice.add(product.getPrice());
        totalExpectedWeight += product.getExpectedWeight();
        if (totalPrice.compareTo(amountPaid) >= 0) {
            isPaid = false;
        }
    }
    public static void addPLUProduct(PLUCodedProduct p,double weight) {
		// TODO Auto-generated method stub
    	listOfProducts.add(p);
        totalPrice = totalPrice.add(p.getPrice().multiply(new BigDecimal(weight)));
        if (totalPrice.compareTo(amountPaid) >= 0) {
            isPaid = false;
        }
		
	}
	
    public static void addBag(ReusableBag bag){
        bagCount++;
        totalPrice = totalPrice.add(idealBagPriceInUSD);
        totalExpectedWeight += bag.getWeight();
        if (totalPrice.compareTo(amountPaid) >= 0) {
            isPaid = false;
        }
    }

    public static ArrayList<Product> getListOfProducts(){
        return listOfProducts;
    }



    // I think this is not necessary for this iteration but will be useful for future ones
    public static void removeProduct(String product){
        for(Product p : listOfProducts)
        {
            if(p instanceof PLUCodedProduct)
            {
                PLUCodedProduct a = (PLUCodedProduct)p;
                if(product.compareTo(a.getDescription()) == 0){
                    listOfProducts.remove(a);
                    totalPrice = totalPrice.subtract(a.getPrice());
                    //totalExpectedWeight -= a.getExpectedWeight();
                    return;
                }
            }
            if(p instanceof BarcodedProduct)
            {
                BarcodedProduct a = (BarcodedProduct) p;
                if(product.compareTo(a.getDescription()) == 0){
                    listOfProducts.remove(a);
                    totalPrice = totalPrice.subtract(a.getPrice());
                    totalExpectedWeight -= a.getExpectedWeight();
                    return;
                }
            }
        }
    }

    public static void removeOtherProduct(Product product, double weight){
        //listOfBags.remove(product);
        totalPrice = totalPrice.subtract(product.getPrice());
        totalExpectedWeight -= weight;
    }
    public static ArrayList<String> getNames()
    {
        ArrayList<String> names = new ArrayList<>();
        for(Product p: listOfProducts)
        {
            if(p instanceof PLUCodedProduct)
            {
                PLUCodedProduct a = (PLUCodedProduct)p;
                names.add(a.getDescription());
            }
            if(p instanceof BarcodedProduct)
            {
                BarcodedProduct a = (BarcodedProduct) p;
                names.add(a.getDescription());
            }
        }
        return names;
    }
    public static BigDecimal getTotalPrice(){
        return totalPrice;
    }

    public static double getTotalExpectedWeight(){
        return totalExpectedWeight;
    }

    public static void setChange(BigDecimal amount){
        change = amount;
    }

    public static BigDecimal getChange(){
        return change;
    }

    public static int getBagcount(){return bagCount;}


    public static void addAmountPaid(BigDecimal amount) {
        amountPaid = amountPaid.add(amount);
        if (amountPaid.compareTo(totalPrice) >= 0) {
        	isPaid = true;
        }
    }

    public static boolean isPaid() {
    	return isPaid;
    }

    public static BigDecimal getAmountPaid(){
        return amountPaid;
    }

    public static BigDecimal getAmountLeftToPay() {
    	return totalPrice.subtract(amountPaid);
    }


    // This method is used for testing purposes ONLY
    public void setAmountPaid(BigDecimal amount) {
    	amountPaid = amount;
        if (amountPaid.compareTo(totalPrice) >= 0) {
            isPaid = true;
        }
    }

    public void reset() {
    	listOfProducts = new ArrayList<>();
        bagCount = 0;
        totalPrice = new BigDecimal(0);
        amountPaid = new BigDecimal(0);
        totalExpectedWeight = 0;
        change = new BigDecimal(0);
        isPaid = false;
    }

}

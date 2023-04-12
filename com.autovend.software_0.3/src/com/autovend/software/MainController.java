
package com.autovend.software;

import java.math.BigDecimal;
import java.util.Currency;

import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.PLUCodedProduct;

public class MainController {
    private AttendantIO attendantIO;
    private CustomerIO customerIO = null;
    private SelfCheckoutStation station = null;
    private Currency currency = Currency.getInstance("CAD");
    private	int[] billDenominations = {5,10,20,50};
    private BigDecimal[] coinDenominations = {new BigDecimal(0.05),new BigDecimal(0.1),
    		new BigDecimal(0.25),
    		new BigDecimal(1), new BigDecimal(2)};
    private		int scaleMaximumWeight = 300;
    private		int scaleSensitivity = 1;
    public MainController()
    {

        station = new SelfCheckoutStation(currency,billDenominations,coinDenominations,scaleMaximumWeight,scaleSensitivity);
           customerIO = new CustomerIO(this, station );
           shutdown();


        attendantIO = new AttendantIO(this,station);

        populateDataBase();
    }
    // add methods that the customer IO needs to change the attendant screen, and vice versa
 
    public void approve()
    {
    	customerIO.permit();
    }
    public void open()
    {
    	customerIO.open();
    }
    public void permit()
    {
    	customerIO.permit();
    }
    public void prevent()
    {
    	customerIO.prevent();
    }
    public void shutdown()
    {
    	customerIO.close();
    }
    public void finish()
    {

 
        station = new SelfCheckoutStation(currency,billDenominations,coinDenominations,scaleMaximumWeight,scaleSensitivity);
        customerIO = new CustomerIO(this, station);
        shutdown();
    }
    public void populateDataBase()
    {

        LoginLogout.createAccount("victor","han");

        PriceLookUpCode testCode = new PriceLookUpCode(Numeral.one,Numeral.one,Numeral.one,Numeral.one);
        PLUCodedProduct testPLU = new PLUCodedProduct(testCode, "testPLU", new BigDecimal(2));
        ProductDatabases.PLU_PRODUCT_DATABASE.put(testCode,testPLU);
    }
    public static void main(String args[])
    {
    	MainController main = new MainController();
 
    }
    
}


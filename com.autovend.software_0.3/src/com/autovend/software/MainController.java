
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
    private CustomerIO[] customerIO = {null,null,null,null,null};
    private SelfCheckoutStation[] stations = {null,null,null,null,null};
    private Currency currency = Currency.getInstance("CAD");
    private	int[] billDenominations = {5,10,20,50};
    private BigDecimal[] coinDenominations = {new BigDecimal(0.05),new BigDecimal(0.1),
    		new BigDecimal(0.25),
    		new BigDecimal(1), new BigDecimal(2)};
    private		int scaleMaximumWeight = 300;
    private		int scaleSensitivity = 1;
    public MainController()
    {
       for(int x = 0; x < 1; x++)
       {
            stations[x] = new SelfCheckoutStation(currency,billDenominations,coinDenominations,scaleMaximumWeight,scaleSensitivity);
           customerIO[x] = new CustomerIO(this,
            stations[x], x);
           shutdown(x);
        }

        attendantIO = new AttendantIO(this,stations);

        populateDataBase();
    }
    // add methods that the customer IO needs to change the attendant screen, and vice versa
 
    public void approve(int station)
    {
    	customerIO[station].permit();
    }
    public void open(int station)
    {
    	customerIO[station].open();
    }
    public void permit(int station)
    {
    	customerIO[station].permit();
    }
    public void prevent(int station)
    {
    	customerIO[station].prevent();
    }
    public void shutdown(int station)
    {
    	customerIO[station].close();
    }
    public void finish(int station)
    {

        everyList[station] = new PurchasedItems();
        stations[station] = new SelfCheckoutStation(currency,billDenominations,coinDenominations,scaleMaximumWeight,scaleSensitivity);
        customerIO[station] = new CustomerIO(this,
                stations[station], station, everyList[station]);
        shutdown(station);
    }
    public void populateDataBase()
    {

        LoginLogout.createAccount("victor","han");

        PriceLookUpCode testCode = new PriceLookUpCode(Numeral.one,Numeral.two,Numeral.three,Numeral.four);
        PLUCodedProduct testPLU = new PLUCodedProduct(testCode, "testPLU", new BigDecimal(2));
        ProductDatabases.PLU_PRODUCT_DATABASE.put(testCode,testPLU);
    }
    public static void main(String args[])
    {
    	MainController main = new MainController();
 
    }
    
}


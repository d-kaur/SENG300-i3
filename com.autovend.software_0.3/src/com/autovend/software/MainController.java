
package com.autovend.software;

import java.math.BigDecimal;
import java.util.Currency;

import com.autovend.devices.SelfCheckoutStation;

public class MainController {
    private AttendantIO attendantIO;
    private CustomerIO[] customerIO = {null,null,null,null,null};
    private Currency currency = Currency.getInstance("CAD");
    private	int[] billDenominations = {5,10,20,50};
    private BigDecimal[] coinDenominations = {new BigDecimal(0.05),new BigDecimal(0.1),
    		new BigDecimal(0.25),
    		new BigDecimal(1), new BigDecimal(2)};
    private		int scaleMaximumWeight = 300;
    private		int scaleSensitivity = 1;
    public MainController()
    {
        int x = 0;
       // for(int x = 0; x < 0; x++)
        {
           customerIO[x] = new CustomerIO(this,
            new SelfCheckoutStation(currency,billDenominations,coinDenominations,scaleMaximumWeight,scaleSensitivity), x);
           //shutdown(x);
        }

        attendantIO = new AttendantIO(this);

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
    	customerIO[station] = new CustomerIO(this, 
    	new SelfCheckoutStation(currency,billDenominations,coinDenominations,scaleMaximumWeight,scaleSensitivity), station);
    }
    public void populateDataBase()
    {
    	LoginLogout.createAccount("victor","han");
    }
    public static void main(String args[])
    {
    	MainController main = new MainController();
 
    }
    
}


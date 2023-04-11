
package com.autovend.software;

public class MainController {
    private AttendantIO attendantIO;
    private CustomerIO[] customerIO;
    public MainController()
    {   
        customerIO = {new CustomerIO(this),new CustomerIO(this),
        		new CustomerIO(this),new CustomerIO(this),new CustomerIO(this)};
        attendantIO = new AttendantIO(this);
    }
    // add methods that the customer IO needs to change the attendant screen, and vice versa
    public void preventCustomer()
    {
    	this.customerIO.showPreventScreen();
    	

    }
    public void approve(int station)
    {
    	customerIO[station].approve();
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
    	customerIO[station].shutdown();
    }
    
    public static void main(String args[])
    {
    	MainController main = new MainController();
 
    }
    
}


package com.autovend.software;

public class MainController {
    private AttendantIO attendantIO;
    private CustomerIO customerIO;
    public MainController()
    {   
        customerIO = new CustomerIO(this);
        attendantIO = new AttendantIO(this);
    }
    // add methods that the customer IO needs to change the attendant screen, and vice versa
    public void preventCustomer()
    {

    }
    public void permitCustomer()
    {
        
    }
    public void Approve(int station)
    {
    	
    }
    public static void main(String args[])
    {
    	MainController main = new MainController();
 
    }
    
}

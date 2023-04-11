
package com.autovend.software;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomerIO {
    private MainController parent;
    
    private CustomerMainGUI customerMainGUI;

	private PreventAccessGUI preventAccessGUI;
	private ClosedGUI closedGUI;
    // we might need this to restore the correct screen
    // private String state;
	private SelfCheckoutStation scs;
	int stationNum;
    public CustomerIO(MainController parent, SelfCheckoutStation scs, int stationNum){
        this.parent = parent;
        preventAccessGUI = new PreventAccessGUI();
        customerMainGUI = new CustomerMainGUI(this,scs, stationNum);
        this.scs = scs;
        this.stationNum = stationNum;
    }
//    shows an screen indicating that the station is not working
    public void prevent()
    {
    	customerMainGUI.setVisible(false);
    	
    	preventAccessGUI.setVisble(true);
        
    }
    public void permit()
    {
    	
    	preventAccessGUI.setVisible(false);
    	
    	customerMainGUI.setVisible(true);
    	
        
    }
    public void close()
    {
    	preventAccessGUI.setVisible(false);
    	customerMainGUI.setVisble(false);
    	ClosedGUI.setVisible(true);
    }
    public void open()
    {
    	ClosedGUI.setVisible(false);
    	prevent();
    }
    public void done()
    {
    	parent.finish(stationNum);
    }
}



package com.autovend.software;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomerIO {
    private MainController parent;
    
    private CustomerMainGUI customerMainGUI;

	private PreventAccessGUI preventAccessGUI;
    // we might need this to restore the correct screen
    // private String state;


    public CustomerIO(MainController parent){
        this.parent = parent;
        preventAccessGUI = new PreventAccessGUI();
        customerMainGUI = new CustomerMainGUI(this);
        
    }
//    shows an screen indicating that the station is not working
    public void showPreventScreen()
    {
    	customerMainGUI.setVisible(false);
    	
    	preventAccessGUI.setVisble(true);
        
    }
    public void showPermitScreen()
    {
    	
    	preventAccessGUI.setVisible(false);
    	
    	customerMainGUI.setVisible(true);
    	
        
    }
    
    public static void main(String[] args) {
		PreventAccessGUI gui = new PreventAccessGUI();
	}
}



package com.autovend.software;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.autovend.devices.SelfCheckoutStation;

public class CustomerIO {
    private MainController parent;
    
    private CustomerMainGUI customerMainGUI;

	private PreventAccessGUI preventAccessGUI;
	private ClosedGUI closedGUI;
	private AddItemBrowseGUI addItemBrowse;
	private AddItemPLUGUI addItemPLU;
	private AddItemTextCustomer addItemText;
	private PayIO payIO;
	private PurchasedItems itemsbought;
    // we might need this to restore the correct screen
    // private String state;
	private SelfCheckoutStation scs;
	int stationNum;
    public CustomerIO(MainController parent, SelfCheckoutStation scs, int stationNum){
        this.parent = parent;
        itemsbought = new PurchasedItems();
        //preventAccessGUI = new PreventAccessGUI(this);
        customerMainGUI = new CustomerMainGUI(this,scs, stationNum);
  
        closedGUI = new ClosedGUI();
    	addItemBrowse = new AddItemBrowseGUI(this,scs);
    	addItemPLU = new AddItemPLUGUI(this,scs);
    	addItemText = new AddItemTextCustomer(this,scs);
        payIO = new PayIO(itemsbought,scs,this);
        this.scs = scs;
        this.stationNum = stationNum;
    }
    private void setAllInvisible()
    {
    	customerMainGUI.setVisible(false);
    	preventAccessGUI.setVisible(false);
    	closedGUI.setVisible(false);
    	addItemBrowse.setVisible(false);
    	addItemPLU.setVisible(false);
    	addItemText.setVisible(false);
    	payIO.setVisible(false);
    }
    private void restore() {
    	
    }
//    shows an screen indicating that the station is not working
    public void prevent()
    {
    	setAllInvisible();
    	
    	preventAccessGUI.setVisible(true);
        
    }
    public void permit()
    {
    	
    	preventAccessGUI.setVisible(false);
    	
    	customerMainGUI.setVisible(true);
    	
        
    }
    public void close()
    {
    	preventAccessGUI.setVisible(false);
    	customerMainGUI.setVisible(false);
    	closedGUI.setVisible(true);
    }
    public void open()
    {
    	closedGUI.setVisible(false);
    	prevent();
    }
    public void done()
    {
    	parent.finish(stationNum);
    }
    public void showMainScreen()
    {
    	setAllInvisible();
    	customerMainGUI.setVisible(true);
    }
    public void ShowPayScreen()
    {
    	setAllInvisible();
    	payIO.setVisible(true);
    }
    public void showAddBrowse()
    {
    	setAllInvisible();
    	addItemBrowse.setVisible(true);
    }
    public void showAddPLU()
    {
    	setAllInvisible();
    	addItemPLU.setVisible(true);
    }
    public void showAddText()
    {
    	setAllInvisible();
    	addItemText.setVisible(true);
    }
    
}


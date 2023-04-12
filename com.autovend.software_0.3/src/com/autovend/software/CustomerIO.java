
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
    

    private ScanItemsGUI addScanItem;

    // we might need this to restore the correct screen
    // private String state;
	private SelfCheckoutStation scs;
    public CustomerIO(MainController parent, SelfCheckoutStation scs){

        this.parent = parent;
    
        preventAccessGUI = new PreventAccessGUI(this);
        customerMainGUI = new CustomerMainGUI(this,scs);
        customerMainGUI.setVisible(false);

        closedGUI = new ClosedGUI(this);
    	addItemBrowse = new AddItemBrowseGUI(this,scs);

    	addItemPLU = new AddItemPLUGUI(this,scs);
        addScanItem = new ScanItemsGUI(this, scs);
    	addItemText = new AddItemTextCustomer(this,scs);
        payIO = new PayIO(scs,this);
        this.scs = scs;


    }
    private void setAllInvisible()
    {
    	customerMainGUI.setVisible(false);

        preventAccessGUI.setVisible(false);
    	closedGUI.setVisible(false);
    	addItemBrowse.setVisible(false);
    	addItemPLU.setVisible(false);
    	addItemText.setVisible(false);
    	payIO.setAllInvisble();
        addScanItem.setVisible(false);


    }
//    shows an screen indicating that the station is not working
    public void prevent()
    {
    	setAllInvisible();
    	
    	preventAccessGUI.setVisible(true);
        
    }
    public void permit()
    {
    	setAllInvisible();
    	
    	customerMainGUI.setVisible(true);
    	
        
    }
    public void close()
    {
    	setAllInvisible();
    	closedGUI.setVisible(true);
    }
    public void open()
    {
    	closedGUI.setVisible(false);
    	prevent();
    }
    public void done()
    {
    	parent.finish();
    }
    public void showMainScreen()
    {
    	setAllInvisible();
    	customerMainGUI.setVisible(true);
    }
    public void showPayScreen()
    {
    	setAllInvisible();
    	payIO.showMainScreen();
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
    public void showScanItem()
    {
        setAllInvisible();
        addScanItem.setVisible(true);
    }
}


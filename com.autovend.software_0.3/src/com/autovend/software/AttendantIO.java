package com.autovend.software;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.software.*;
public class AttendantIO {
    private MainController parent;
    private AttendantMainGUI attendantMainGUI;
    private LoginLogoutGUI loginLogoutIO;
    private AddInkPaperIO addInkPaperIO;
    private AddItemAttendant addItem;
    private RemoveItem removeItem;
    private ChangeBankNotes changeBankNotes;
    private PurchasedItems[] everyList;
    private SelfCheckoutStation[] stations;
    public AttendantIO(MainController parent, PurchasedItems[] everylist, SelfCheckoutStation[] stations){
    	this.stations = stations;
        this.everyList = everylist;
        this.parent = parent;
        loginLogoutIO = new LoginLogoutGUI(this);
        attendantMainGUI = new AttendantMainGUI(this);
        addInkPaperIO = new AddInkPaperIO(this,stations);
        addItem = new AddItemAttendant(this); 
        removeItem =  new RemoveItem(this);
        changeBankNotes = new ChangeBankNotes(this);
        displayLogin();
    }
    private void setAllInvisible()
    {
    	attendantMainGUI.setVisible(false);
        loginLogoutIO.setVisible(false);
        attendantMainGUI.setVisible(false);
        addInkPaperIO.setVisible(false);
        addItem.setVisible(false);
        removeItem.setVisible(false);
        changeBankNotes.setVisible(false);
    }
    public void displayLogin()
    {
    	setAllInvisible();
    	loginLogoutIO.setVisible(true);
    }
    public void displayMainScreen()
    {
    	setAllInvisible();
    	attendantMainGUI.setVisible(true);
    }
    public void displayAddItem()
    {
    	setAllInvisible();
    	addItem.setVisible(true);
    }
    public void displayRemoveItem(int station)
    {
    	setAllInvisible();
        removeItem.pickStation(station);
    	removeItem.setVisible(true);
    	
    }
    public void displayInkPaper(int station){
    	setAllInvisible();
        addInkPaperIO.pickStation(station);
    	addInkPaperIO.setVisible(true);
    }
    public void displayBankNotes()
    {
    	setAllInvisible();
    	changeBankNotes.setVisible(true);
    }
    public void approve(int station) 
    {
    	parent.approve(station);
    }
    public void shutDown(int station) {
    	parent.shutdown(station);
    }
    public void startup(int station)
    {
    	parent.open(station);
    }
    public void prevent(int station)
    {
    	parent.prevent(station);
    }
    public void attendantApprove(int station)
    {
    	parent.approve(station);
    }
 
}

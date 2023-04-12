package com.autovend.software;
import com.autovend.devices.SelfCheckoutStation;

public class AttendantIO {
    private MainController parent;
    private AttendantMainGUI attendantMainGUI;
    private LoginLogoutGUI loginLogoutIO;
    private AddInkPaperIO addInkPaperIO;
    private AddItemAttendant addItem;
    private RemoveItem removeItem;
    private ChangeBankNotes changeBankNotes;
    private SelfCheckoutStation station;
    public AttendantIO(MainController parent, SelfCheckoutStation station){
    	this.station = station;
        this.parent = parent;
        loginLogoutIO = new LoginLogoutGUI(this);
        attendantMainGUI = new AttendantMainGUI(this);
        addInkPaperIO = new AddInkPaperIO(this,station);
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
    public void displayRemoveItem()
    {
    	setAllInvisible();
        removeItem.update();
    	removeItem.setVisible(true);
    	
    }
    public void displayInkPaper(){
    	setAllInvisible();
        addInkPaperIO.pickStation();
    	addInkPaperIO.setVisible(true);
    }
    public void displayBankNotes()
    {
    	setAllInvisible();
    	changeBankNotes.setVisible(true);
    }
    public void approve()
    {
    	parent.approve();
    }
    public void shutDown() {
    	parent.shutdown();
    }
    public void startup()
    {
    	parent.open();
    }
    public void prevent()
    {
    	parent.prevent();
    }
    public void attendantApprove()
    {
    	parent.approve();
    }
 
}

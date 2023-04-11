package com.autovend.software;
public class AttendantIO {
    private MainController parent;
    private AttendantMainGUI attendantMainGUI;
    private LoginLogoutIO loginLogoutIO;
    private AddInkPaperIO addInkPaperIO;
    private AddItemAttendant addItem;
    private RemoveItem removeItem;
    private ChangeBankNotes changeBankNotes;
    public AttendantIO(MainController parent){
        this.parent = parent;
        loginLogoutIO = new LoginLogoutIO(this);
        attendantMainGUI = new AttendantMainGUI(this);
        addInkPaperIO = new AddInkPaperIO(this);
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
    }
    public displayLogin()
    {
    	setAllInvisble();
    	loginLogoutIO.setVisible(true);
    }
    public displayMainScreen()
    {
    	setAllInvisble();
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
    	removeItem.setVisible(true);
    	
    }
    public void displayInkPaper()
    {
    	setAllInvisible();
    	addInkPaperIO.setVisble(true);
    }
    public void displayBankNotes()
    {
    	setAllInvisble();
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
    	parent.startup(station);
    }
    public void disable(int station)
    {
    	parent.disable(station);
    }
    public void attendantApprove(int station)
    {
    	parent.approve(station);
    }
 
}

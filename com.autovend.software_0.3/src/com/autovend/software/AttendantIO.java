package com.autovend.software;
public class AttendantIO {
    private MainController parent;
    private AttendantMainGUI attendantMainGUI;
    private LoginLogoutIO loginLogoutIO;
    private AddInkPaperIO addInkPaperIO;
    //private Ad
    public AttendantIO(MainController parent){
        this.parent = parent;
        loginLogoutIO = new LoginLogoutIO(this);
        attendantMainGUI = new AttendantMainGUI(this);
        addInkPaperIO = new AddInkPaperIO(this);
    }
    private void setAllInvisible()
    {
    	
    }
    public displayMainScreen()
    {
    	setAllInvisble();
    }
    public void displayAddItem()
    {
    	setAllInvisible();
    }
    public void displayRemoveItem()
    {
    	setAllInvisible();
    	
    }
    public void displayInkPaper()
    {
    	setAllInvisible();
    	addInkPaperIO.setVisble(true);
    }
    
    public void attendantApprove(int station) 
    {
    	parent.Approve(station);
    }
    public void approveBag()
    {
    	
    }
    public void displayBankNotes()
    {
    	
    }
}

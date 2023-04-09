public class MainController {
    private AttendantIO attendantIO;
    private CustomerIO customerIO;
    public MainController()
    {   
        customerIO = new CustomerIO(this);
        attendantIO = new AttendantIO(this);
    }
    // add methods that the customer IO needs to change the attendant screen, and vice versa
}

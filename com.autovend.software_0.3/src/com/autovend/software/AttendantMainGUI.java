package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.autovend.software.*;

public class AttendantMainGUI extends JFrame {

    //Setting up button for each self check out station
    private int stationSelected;
    private JButton stationButton;
    // private JButton station1Button;
    // private JButton station2Button;
    // private JButton station3Button;
    // private JButton station4Button;
    // private JButton station5Button;

    //Setting up attendant action buttons 

    private JButton startButton;
    private JButton stopButton;
    private JButton premitButton;
    private JButton preventButton;
    private JButton removeItemButton;
    private JButton addItemBySearchButton;

    private JButton adjustCoinsBillsButton;

    private JButton allowPersonalBagButton;
    private JButton approveExceptionButton;

    private JButton addInkPaperButton;
    public JLabel alert;
    private boolean[] open = {false,false,false,false,false};
    private boolean[] permitted = {false,false,false,false,false};
    private static AttendantIO parent;
    
    public AttendantMainGUI(AttendantIO parent) {
        this.parent = parent;
        JFrame frame = new JFrame("Attendant Self Checkout Station");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting up Self Checkout Panel Layout
        JPanel StationPanel = new JPanel();
        JPanel StartPermitPanel = new JPanel();
        JPanel StopPreventPanel = new JPanel();
        JPanel MiddleButtonsPanel = new JPanel();
        JPanel mainPanel = new JPanel();
      //   JPanel alertPanel = new JPanel();
        
        setMinimumSize(new Dimension(600,400));
        

        //Setting up contents of Panel

        //Adding station buttons to panel and including action listener to buttons 
        for (int i = 0; i < 5; i++) {
            JButton stationButton = new JButton(String.valueOf(i + 1));
            final int index = i; // We need to make a final copy of i to use in the lambda expression
            stationButton.addActionListener(e -> {
                stationSelected = index;
            });
            StationPanel.add(stationButton);
        }

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        premitButton = new JButton("Permit");
        premitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        preventButton = new JButton("Prevent");
        preventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        addItemBySearchButton = new JButton("Add Item By Search");
        addItemBySearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        adjustCoinsBillsButton = new JButton("Adjust Coins/Bills");
        adjustCoinsBillsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        allowPersonalBagButton = new JButton("Allow Personal Bag");
        allowPersonalBagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        approveExceptionButton = new JButton("Approve");
        approveExceptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        addInkPaperButton = new JButton("Add Ink/Paper");
        addInkPaperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
             }
            
        });

        //Adding contents to Panel 

        //Left side buttons
        StartPermitPanel.setLayout(new BoxLayout(StartPermitPanel, BoxLayout.Y_AXIS));
        StartPermitPanel.add(startButton);
        StartPermitPanel.add(premitButton);

        //Right side buttons
        StopPreventPanel.setLayout(new BoxLayout(StopPreventPanel, BoxLayout.Y_AXIS));
        StopPreventPanel.add(stopButton);
        StopPreventPanel.add(preventButton);
        
        //Middle Buttons
        MiddleButtonsPanel.setLayout(new BoxLayout(MiddleButtonsPanel, BoxLayout.Y_AXIS));
        MiddleButtonsPanel.add(Box.createVerticalGlue());
        removeItemButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        MiddleButtonsPanel.add(removeItemButton);
        addItemBySearchButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        MiddleButtonsPanel.add(addItemBySearchButton);
        adjustCoinsBillsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        MiddleButtonsPanel.add(adjustCoinsBillsButton);
        allowPersonalBagButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        MiddleButtonsPanel.add(allowPersonalBagButton);
        approveExceptionButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        MiddleButtonsPanel.add(approveExceptionButton);
        addInkPaperButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        MiddleButtonsPanel.add(addInkPaperButton);
        MiddleButtonsPanel.add(Box.createVerticalGlue());

        //Alter notifire lable 
        //alertPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 3)); // set the height to 50 pixels

        // Create the alert label
        // String message = "weight";
        // JLabel alert = new JLabel("Alert: " + message);
        
        // Add the alert label to the alertPanel
       // alertPanel.add(alert);
        
         
            JPanel alertPanel = new JPanel();
            JLabel newalert = new JLabel();
            alertPanel.add(newalert);
            mainPanel.add(alertPanel, BorderLayout.SOUTH);
         
         

        //Orienting contents layout
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(StationPanel, BorderLayout.NORTH);
        mainPanel.add(StartPermitPanel, BorderLayout.WEST);
        mainPanel.add(StopPreventPanel, BorderLayout.EAST);
        mainPanel.add(MiddleButtonsPanel, BorderLayout.CENTER);
        //mainPanel.add(alertPanel, BorderLayout.SOUTH);
        
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        pack();
    }

    

    public static void main(String[] args){
      new AttendantMainGUI(parent);
   }


    
}
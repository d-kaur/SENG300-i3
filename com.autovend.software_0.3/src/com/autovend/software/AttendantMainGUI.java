<<<<<<< Updated upstream
package com.autovend.software;

import com.autovend.software.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AttendantMainGUI extends JFrame implements ActionListener {

    //Setting up button for each self check out station
    private JButton station1Button;
    private JButton station2Button;
    private JButton station3Button;
    private JButton station4Button;
    private JButton station5Button;

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

    public AttendantMainGUI() {
        JFrame frame = new JFrame("Attendant Self Checkout Station");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting up Self Checkout Panel Layout
        JPanel StationPanel = new JPanel();
        JPanel StartPermitPanel = new JPanel();
        JPanel StopPreventPanel = new JPanel();
        JPanel MiddleButtonsPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel alertPanel = new JPanel();
        
        setMinimumSize(new Dimension(600,400));
        

        //Setting up contents of Panel
        station1Button = new JButton("1");
        //station1Button.setBounds(10, 20, 80,25);
        station1Button.addActionListener(this);

        station2Button = new JButton("2");
        //station2Button.setBounds(100, 20, 85 ,25);
        station2Button.addActionListener(this);

        station3Button = new JButton("3");
        //station3Button.setBounds(190, 20, 85 ,25);
        station3Button.addActionListener(this);

        station4Button = new JButton("4");
        //station4Button.setBounds(280, 20, 85 ,25);
        station4Button.addActionListener(this);

        station5Button = new JButton("5");
        station5Button.addActionListener(this);

        startButton = new JButton("Start");
        startButton.addActionListener(this);

        premitButton = new JButton("Permit");
        premitButton.addActionListener(this);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);

        preventButton = new JButton("Prevent");
        preventButton.addActionListener(this);

        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(this);

        addItemBySearchButton = new JButton("Add Item By Search");
        addItemBySearchButton.addActionListener(this);

        adjustCoinsBillsButton = new JButton("Adjust Coins/Bills");
        adjustCoinsBillsButton.addActionListener(this);

        allowPersonalBagButton = new JButton("Allow Personal Bag");
        allowPersonalBagButton.addActionListener(this);

        approveExceptionButton = new JButton("Approve");
        approveExceptionButton.addActionListener(this);

        addInkPaperButton = new JButton("Add Ink/Paper");
        addInkPaperButton.addActionListener(this);

        //Adding contents to Panel 

        //Self Checkout Buttons
        StationPanel.add(station1Button);
        StationPanel.add(station2Button);
        StationPanel.add(station3Button);
        StationPanel.add(station4Button);
        StationPanel.add(station5Button);

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
        String message = "weight";
        JLabel alert = new JLabel("Alert: " + message);
        
        // Add the alert label to the alertPanel
        alertPanel.add(alert);
        
        //Orienting contents layout
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(StationPanel, BorderLayout.NORTH);
        mainPanel.add(StartPermitPanel, BorderLayout.WEST);
        mainPanel.add(StopPreventPanel, BorderLayout.EAST);
        mainPanel.add(MiddleButtonsPanel, BorderLayout.CENTER);
        mainPanel.add(alertPanel, BorderLayout.SOUTH);
        
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // TODO Auto-generated method stub
       throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    // public static void main(String[] args){
    //    new AttendantMainGUI();
    // }

    
}

=======
package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendantMainGUI extends JFrame {

    //Setting up button for each self check out station
    private int stationSelected;
    private JButton stationButton;

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
        
        setMinimumSize(new Dimension(600,400));
        

        //Setting up contents of Panel

        //Adding station buttons to panel and including action listener to buttons 
        for (int i = 0; i < 5; i++) {
            JButton stationButton = new JButton(String.valueOf(i + 1));
            final int index = i; 
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

        //Orienting contents layout
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(StationPanel, BorderLayout.NORTH);
        mainPanel.add(StartPermitPanel, BorderLayout.WEST);
        mainPanel.add(StopPreventPanel, BorderLayout.EAST);
        mainPanel.add(MiddleButtonsPanel, BorderLayout.CENTER);
        
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        pack();
    }
    public void showAlert(String message) {
      JOptionPane.showMessageDialog(this, message, "Alert", JOptionPane.INFORMATION_MESSAGE);
  }
    
    

    public static void main(String[] args){
      new AttendantMainGUI(parent);
   }


    
}
>>>>>>> Stashed changes

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
    private JLabel alert;

    private AttendantIO parent;
    
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
                parent.startup();
             }
            
        });

        premitButton = new JButton("Permit");
        premitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.approve();
             }
            
        });

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.shutDown();
             }
            
        });

        preventButton = new JButton("Prevent");
        preventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.prevent();
             }
            
        });

        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.displayRemoveItem();
             }
            
        });

        addItemBySearchButton = new JButton("Add Item By Search");
        addItemBySearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.displayAddItem();
             }
            
        });

        adjustCoinsBillsButton = new JButton("Adjust Coins/Bills");
        adjustCoinsBillsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.displayBankNotes();
             }
            
        });

        allowPersonalBagButton = new JButton("Allow Personal Bag");
        allowPersonalBagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.approve();
             }
            
        });

        approveExceptionButton = new JButton("Approve");
        approveExceptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.attendantApprove();
             }
            
        });

        addInkPaperButton = new JButton("Add Ink/Paper");
        addInkPaperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.displayInkPaper();
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

}


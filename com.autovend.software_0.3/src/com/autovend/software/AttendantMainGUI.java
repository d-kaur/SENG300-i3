package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendantMainGUI extends JFrame {

    //Setting up button for each self check out station
    private int stationSelected = 0;
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
    
    private CustomerMainGUI station1 = null;
    private CustomerMainGUI station2 = null;
    private CustomerMainGUI station3 = null;
    private CustomerMainGUI station4 = null;
    private CustomerMainGUI station5 = null;
    
    private CustomerMainGUI[] stations  = {station1, station2, station3, station4, station5};
    
    public AttendantMainGUI(AttendantIO parent) {
    	//System.out.println(stationSelected);
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
                stationSelected = index + 1;
                System.out.println(stationSelected);
                if (stations[stationSelected - 1] != null)
                {
                	for (CustomerMainGUI station: stations)
                	{
                		if (station != null)
                		{
                			station.setVisible(false);
                		}	
                	}
                	stations[stationSelected - 1].setVisible(true);
                }
               
                
            });
            StationPanel.add(stationButton);
        }

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removeItemFrame removeItem = new removeItemFrame();
                //removeItemframe.display();
            	switch (stationSelected)
            	{
            	case 0:      
            		System.out.println("Please select a station first");
            		break;
            	
            	case 1:            		           		
            		if (station1 == null)
            		{
            			//System.out.println("Starting 1");
            			for (CustomerMainGUI station: stations)
                    	{
                    		if (station != null)
                    		{
                    			station.setVisible(false);
                    		}	
                    	}
            			stations[0] = new CustomerMainGUI("Station 1");
            			
            		}
            		break;
            	
            	case 2:
            	
            		if (station2 == null)
            		{
            			//System.out.println("Starting 2");
            			for (CustomerMainGUI station: stations)
                    	{
                    		if (station != null)
                    		{
                    			station.setVisible(false);
                    		}	
                    	}
            			stations[1] = new CustomerMainGUI("Station 2");
            		}
            		break;
            	
            	case 3:
            	
            		if (station3 == null)
            		{
            			//System.out.println("Starting 3");
            			for (CustomerMainGUI station: stations)
                    	{
                    		if (station != null)
                    		{
                    			station.setVisible(false);
                    		}	
                    	}
            			stations[2] = new CustomerMainGUI("Station 3");
            		}
            		break;
            	
            	case 4:
            	
            		if (station4 == null)
            		{
            			//System.out.println("Starting 4");
            			for (CustomerMainGUI station: stations)
                    	{
                    		if (station != null)
                    		{
                    			station.setVisible(false);
                    		}	
                    	}
            			stations[3] = new CustomerMainGUI("Station 4");
            		}
            		break;
            	
            	case 5:
            	
            		if (station5 == null)
            		{
            			//System.out.println("Starting 5");
            			for (CustomerMainGUI station: stations)
                    	{
                    		if (station != null)
                    		{
                    			station.setVisible(false);         
                    		}	
                    	}
            			stations[4] = new CustomerMainGUI("Station 5");
            		}
            		break;
            	
            	default:
            	}
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
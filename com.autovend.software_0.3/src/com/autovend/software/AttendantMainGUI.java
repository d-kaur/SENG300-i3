package com.autovend.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.jar.JarEntry;
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

    public AttendantMainGUI() {
        JFrame frame = new JFrame("Attendant Self Checkout Station");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting up Self Checkout Panel Layout
        JPanel StationPanel = new JPanel();
        setMinimumSize(new Dimension(950,800));
        

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

        StationPanel.add(station1Button);
        StationPanel.add(station2Button);
        StationPanel.add(station3Button);
        StationPanel.add(station4Button);
        StationPanel.add(station5Button);
        StationPanel.add(startButton);
        StationPanel.add(premitButton);
        
        frame.add(StationPanel, BorderLayout.NORTH);
        //frame.add(startButton, BorderLayout.WEST);
        
        
        // private JButton startButton;
        // private JButton stopButton;
        // private JButton premitButton;
        // private JButton preventButton;
        // private JButton removeItemButton;
        // private JButton addItemBySearchButton;


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(StationPanel);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // TODO Auto-generated method stub
       throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args){
       new AttendantMainGUI();
    }

    
}


package com.autovend.software;

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

    public AttendantMainGUI() {

        station1Button = new JButton("1");
        station1Button.addActionListener(this);

        station2Button = new JButton("2");
        station2Button.addActionListener(this);

        station3Button = new JButton("3");
        station3Button.addActionListener(this);

        station4Button = new JButton("4");
        station4Button.addActionListener(this);

        station5Button = new JButton("5");
        station5Button.addActionListener(this);

        //Setting up Main Panel Layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setSize(getPreferredSize());

        mainPanel.add(station1Button);
        mainPanel.add(station2Button);

        setContentPane(mainPanel);
        pack();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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


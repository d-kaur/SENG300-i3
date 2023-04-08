//NAME abhiroop kaur
//UCID 30152829
package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;


public class CustomerMainGUI extends JFrame implements ActionListener{
    public CustomerMainGUI(){
        JPanel buttonPanel = new JPanel();
        JPanel payPanel = new JPanel();
        setMinimumSize(new Dimension(800, 800)); //set the size of the frame

        JButton scanButton = new JButton("Add by Scanning");//add action listener to this button            
        JButton pluButton = new JButton("Add by PLU Number");
        JButton searchButton = new JButton("Add by Search");
        JButton browseButton = new JButton("Add by Browsing Purchase Bags");
        JButton purchaseButton = new JButton("Purchase Bags");
        JButton payButton = new JButton("Pay");
        //payButton.setBounds();
        JButton useBag = new JButton("Use Personal Bag");

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.X_AXIS));

        buttonPanel.add(scanButton);
        buttonPanel.add(pluButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(browseButton);
        buttonPanel.add(purchaseButton);
        buttonPanel.add(payButton); 
        buttonPanel.add(useBag);

        payPanel.add(payButton);
        payPanel.add(useBag);

        add(buttonPanel, BorderLayout.EAST);
        add(payPanel, BorderLayout.SOUTH);
        // add(payButton, BorderLayout.SOUTHWEST);
        // add(useBag, BorderLayout.SOUTHEAST);

        //setContentPane(buttonPanel);
        // pack();
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
        
  

    public static void main(String[] args){
        new CustomerMainGUI();
        }

   
}

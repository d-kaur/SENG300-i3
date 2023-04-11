//NAME abhiroop kaur
//UCID 30152829

package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;




public class CustomerMainGUI extends JFrame implements ActionListener{


    public CustomerMainGUI(String title){
    	this.setTitle(title);
        JPanel buttonPanel = new JPanel();
        JPanel payPanel = new JPanel();
        JPanel displayPanel = new JPanel();
        setMinimumSize(new Dimension(650, 700)); //set the size of the frame


        //set up the buttons
        JButton scanButton = new JButton("Add by Scanning");//add action listener to this button
        scanButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //new ScanGUI();
            }
        });        
        JButton pluButton = new JButton("Add by PLU Number");
        pluButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        JButton searchButton = new JButton("Add by Search");
        searchButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        JButton browseButton = new JButton("Add by Browsing Purchase Bags");
        browseButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        JButton purchaseButton = new JButton("Purchase Bags");
        purchaseButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        JButton payButton = new JButton("Pay");
        payButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        //payButton.setBounds();
        //AttendantMainGUI alert = new AttendantMainGUI(null);
        JButton useBag = new JButton("Use Personal Bag");
        useBag.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //alert.showAlert("Alert:Use Personal Bag");
                
            }
        });

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.X_AXIS));
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

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

        //setting up the header label
        JLabel headerLabel = new JLabel("Items in Cart:");
        int fontSize = 18;
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.BOLD, fontSize));

        //setting up the jcombobox to display the items in the cart
        JComboBox<String> comboBox = new JComboBox<>();

        displayPanel.add(headerLabel);
        displayPanel.add(comboBox);

        add(displayPanel, BorderLayout.WEST);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);   
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
        
  
/*
    public static void main(String[] args){
        new CustomerMainGUI();
        }
*/

   
}

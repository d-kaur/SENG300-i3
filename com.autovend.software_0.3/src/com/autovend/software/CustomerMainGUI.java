//NAME abhiroop kaur
//UCID 30152829

package com.autovend.software;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import com.autovend.devices.SelfCheckoutStation;




/**
 * @author turec
 *
 */
public class CustomerMainGUI extends JFrame{


    private JPanel buttonPanel;
	private JPanel payPanel;
	private JPanel displayPanel;
	private CustomerIO parent;
	private PurchasedItems itemsbought;

	
	public CustomerMainGUI(CustomerIO customerIO , SelfCheckoutStation scs){
        parent = customerIO;
        itemsbought = new PurchasedItems();


        buttonPanel = new JPanel();
        payPanel = new JPanel();
        displayPanel = new JPanel();
        setMinimumSize(new Dimension(650, 700)); //set the size of the frame
       

        //set up the buttons
        JButton scanButton = new JButton("Add by Scanning");//add action listener to this button
        scanButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                parent.showScanItem();;
            }
        });        
        JButton pluButton = new JButton("Add by PLU Number");
        pluButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showAddPLU();
                
            }
        });

        JButton searchButton = new JButton("Add by Search");
        searchButton.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showAddBrowse();
            }
        });
        JButton purchaseButton = new JButton("Purchase a Bag");
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
                parent.showPayScreen();
            }
        });
        JButton useBag = new JButton("Use Personal Bag");
        useBag.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.prevent();
                
            }
        });

        JButton audioButton = new JButton("Audio");
        audioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
             }
            
        });

        JButton languageButton = new JButton("Language");
        languageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
             }
            
        });

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.X_AXIS));
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(scanButton);
        buttonPanel.add(pluButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(purchaseButton);
        buttonPanel.add(payButton); 
        buttonPanel.add(useBag);

        payPanel.add(payButton);
        payPanel.add(useBag);
        payPanel.add(languageButton);
        payPanel.add(audioButton);

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
    /*
//	shows that the selfcheckout is not available for use
    public static void preventScreen(CustomerMainGUI mainGui) {
        parent.preventScreesetVisible(false);
        mainGui.displayPanel.setVisible(false);
        mainGui.payPanel.setVisible(false);
        
        
        JLabel label = new JLabel("Checkout Disabled", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 54)); // set font size to 36
        mainGui.add(label);
        
    }
    
	*/
	public void done()
	{
		parent.done();
	}
}	
	


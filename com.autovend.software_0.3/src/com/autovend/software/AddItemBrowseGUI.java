/**
 * 
 */
package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

import com.autovend.Barcode;
import com.autovend.PriceLookUpCode;
import com.autovend.PriceLookUpCodedUnit;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.products.PLUCodedProduct;
import com.autovend.products.Product;

/**
 * @author w
 *
 */
public class AddItemBrowseGUI extends AddItemGUI{
	
	private static final long serialVersionUID = 1L;
	private JButton addButton;

	public AddItemBrowseGUI(CustomerIO parent, SelfCheckoutStation scs)
	{
		super(parent,"Add Item Text", scs);

		JPanel comboPanel = new JPanel();
		JPanel addBackPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		JFrame frame = new JFrame("Add Item By Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMinimumSize(new Dimension(600,400));

		JLabel headerLabel = new JLabel("Search:");
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setPreferredSize(new Dimension(150, 40));
		comboBox.setEditable(true);
		comboPanel.add(headerLabel);
		comboPanel.add(comboBox);
	
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e){
			//parent.displayMainScreen();
			String name = (String) comboBox.getSelectedItem();
			
			ArrayList <Barcode> barcodes = new ArrayList<Barcode>(); 
			barcodes.addAll(ProductDatabases.BARCODED_PRODUCT_DATABASE.keySet());
			
			ArrayList <PriceLookUpCode> PLUcodes = new ArrayList<PriceLookUpCode>(); 
			PLUcodes.addAll(ProductDatabases.PLU_PRODUCT_DATABASE.keySet());

			BarcodedProduct foundBarcode = null;
			PLUCodedProduct foundPLU = null;
			
			if(!(name.isEmpty())) {
				
				for (int i=0; i<barcodes.size(); i++) {
					BarcodedProduct temp = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcodes.get(i));
					if(temp.getDescription().equals(name)) {
						foundBarcode = temp;
					}
				}
			
				for (int i=0; i<PLUcodes.size(); i++) {
					PLUCodedProduct temp = ProductDatabases.PLU_PRODUCT_DATABASE.get(PLUcodes.get(i));

					if(temp.getDescription().equals(name)) {
						foundPLU = temp;

					}
				}
				
			}
			if(foundBarcode != null && foundPLU == null)
				PurchasedItems.addProduct(foundBarcode);
			else if (foundPLU != null && foundBarcode == null)
				PurchasedItems.addPLUProduct(foundPLU, 1);
			
			
		}
		});

		addBackPanel.add(addButton);
		addBackPanel.add(back);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(addBackPanel, BorderLayout.SOUTH);
		mainPanel.add(comboPanel, BorderLayout.CENTER);

		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(mainPanel);
		pack();

	}
	
	private Product getProductFromDatabase(Set<Barcode> keys) {
		return null;

		
		
	}

}

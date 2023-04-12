package com.autovend.software;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.autovend.Barcode;
import com.autovend.BarcodedUnit;
import com.autovend.Numeral;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.software.observers.ElectronicScaleObserverStub;

public class AddItemBrowseGUI extends AddItem{
	private JComboBox box;
	private Button addButton, backButton;
	private JFrame frame;
	private int x,y;
	private String Browse;
	private boolean success;
	private final BarcodedProduct[] barcode_products = ProductDatabases.BARCODED_PRODUCT_DATABASE.values()
			.toArray(new BarcodedProduct[0]);
	
	public AddItemBrowseGUI(SelfCheckoutStation scs) {
		super(scs);
		success = false;
		check.screen.enable();
		
		frame = new JFrame("Add Item by Browse");
		frame.setSize(1280,800);
		Browse = "";
		frame.enable();
		check.scale.enable();
		
		//Combo box
		String Itemlist[] = {};
		box = new JComboBox(barcode_products);
		x = 600;//frame.getSize().width/2;
		y = 425;//frame.getSize().height/2;
		
		for (BarcodedProduct p : barcode_products) {
			box.addItem(p.getDescription());
		}
		box.enableInputMethods(true);
		box.setBounds(x,y,200,25);
		box.setEditable(true);
		box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Browse = (String) box.getSelectedItem();
			}
		});
		frame.add(box);

		
		backButton = new Button("BACK");
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				check.scale.disable();
				box.disable();
				frame.removeAll();
				frame.disable();
				System.exit(0);
			}
		});
		
		backButton.setBounds(x,y+25, 30,15);
		check.screen.setVisible(true);
		frame.add(backButton);
		frame.setVisible(false);
		frame.setLayout(null);
	}
	
	public void setBrowsing() {
		
		ElectronicScaleObserverStub scaleObs = new ElectronicScaleObserverStub();
		
		addButton = new Button("ADD");
		addButton.setBounds(x+45,y+25, 30,15);
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BarcodedProduct product = null;
				for (BarcodedProduct p : barcode_products) {
					if (p.getDescription().equals(Browse)) {
						product = p;
						break;
					}
				}
				
				check.scale.enable();
				scaleObs.reactToEnabledEvent(check.scale);
					
				double itemWeight = product.getExpectedWeight();
				BarcodedUnit unit = new BarcodedUnit(product.getBarcode(), itemWeight);
						
				check.scale.add(unit);
				scaleObs.reactToWeightChangedEvent(check.scale, unit.getWeight());
							
				addBarcodedProduct(product);
				check.scale.remove(unit); 
				check.scale.disable();
				scaleObs.reactToDisabledEvent(check.scale);
				success = true;
			
			}
		});
		frame.add(addButton);
		frame.setVisible(true);
	}
	
	public boolean getState() {
		return success;
	}
}

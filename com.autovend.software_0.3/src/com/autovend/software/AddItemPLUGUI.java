/**
 * 
 */
package com.autovend.software;


import java.awt.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.autovend.Numeral;
import com.autovend.PriceLookUpCode;
import com.autovend.PriceLookUpCodedUnit;
import com.autovend.devices.Keyboard;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.external.ProductDatabases;
import com.autovend.products.PLUCodedProduct;
import com.autovend.software.observers.ElectronicScaleObserverStub;
import com.autovend.software.observers.KeyBoardObserverStub;

/**
 * Wasay Siddiqi
 *
 */
public class AddItemPLUGUI extends AddItem{
	private JComboBox<String> box;
	private Button addButton, backButton;
	private Keyboard keyboard;
	private JFrame frame;
	private int x,y;
	private String PLU;
	private boolean success;
	
	/**
	 * Constructor for adding an item using PLU
	 * GUI is utilized 
	 * @param scs: SelfCheckoutStation
	 */
	
	public AddItemPLUGUI(SelfCheckoutStation scs) {
		super(scs);
		success = false;
		check.screen.enable();
		
		frame = new JFrame("Add Item by PLU");
		frame.setSize(1280,800);
		PLU = "";
		frame.enable();
		check.scale.enable();
		
		box = new JComboBox<String>(new String[] {""});
		x = 600;//frame.getSize().width/2;
		y = 425;//frame.getSize().height/2;
		
		box.enableInputMethods(true);
		box.setBounds(x,y,200,25);
		box.setEditable(true);
		box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PLU = (String) box.getSelectedItem();
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
	
	/**
	 * 
	 */
	
	public void setPLU() {
		KeyBoardObserverStub obs = new KeyBoardObserverStub();
		Keyboard keyboard = new Keyboard();
		keyboard.enable();
		keyboard.register(obs);
		obs.reactToEnabledEvent(keyboard);
		
		ElectronicScaleObserverStub scaleObs = new ElectronicScaleObserverStub();
		addButton = new Button("ADD");
		addButton.setBounds(x+45,y+25, 30,15);
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pluSplit [] = PLU.split("");
				if(pluSplit.length == 4) {
					Numeral [] pluArr = new Numeral[pluSplit.length];
					for (int i=0; i<pluArr.length; i++) {
						byte temp = (byte) Integer.parseInt(pluSplit[i]);
						pluArr[i] = Numeral.valueOf(temp);
					}
					PriceLookUpCode pluObj = new PriceLookUpCode(pluArr);
					if(ProductDatabases.PLU_PRODUCT_DATABASE.containsKey(pluObj)) {
						check.scale.enable();
						scaleObs.reactToEnabledEvent(check.scale);
						
						PLUCodedProduct p = ProductDatabases.PLU_PRODUCT_DATABASE.get(pluObj);
						box.addItem(p.getDescription() + " "+ PLU);
						PriceLookUpCodedUnit unit = new PriceLookUpCodedUnit(p.getPLUCode(), 1.5);
						
						check.scale.add(unit);
						scaleObs.reactToWeightChangedEvent(check.scale, unit.getWeight());
						
						addPLUProduct(p);
						check.scale.remove(unit); 
						check.scale.disable();
						scaleObs.reactToDisabledEvent(check.scale);
						success = true;
					} else
						success = false;
				}else {
					success = false;
				}
				
			}

			
		});
		frame.add(addButton);
		frame.setVisible(true);
	}
	
	public boolean getState() {
		return success;
	}
}

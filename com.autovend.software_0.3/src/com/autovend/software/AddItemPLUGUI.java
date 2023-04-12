/**
 * 
 */
package com.autovend.software;


import java.awt.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

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
public class AddItemPLUGUI extends AddItemGUI{
	private JComboBox<String> box;
	private JButton addButton, backButton;
	private Keyboard keyboard;
	private JFrame frame;
	private int x = 300,y = 225;
	private String PLU;
	private boolean success;
	private CustomerIO parent;
	private AddItemByPLU adder;
	/**
	 * Constructor for adding an item using PLU
	 * GUI is utilized 
	 * @param scs: SelfCheckoutStation
	 */
	
	public AddItemPLUGUI(CustomerIO parent,SelfCheckoutStation scs) {
		super(parent,"Add Item by PLU",scs);

		//success = false;
		check.screen.enable();
		adder = new AddItemByPLU(scs);

		setSize(600,600);
		PLU = "";
		//check.scale.enable();

		box = new JComboBox<String>(new String[] {""});
		//x = 600;//frame.getSize().width/2;
		//y = 425;//frame.getSize().height/2;


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

		add(box);



		backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				parent.showMainScreen();
			}

		});

		addButton = new JButton("Add");
		/*
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
						//scaleObs.reactToEnabledEvent(check.scale);

						PLUCodedProduct p = ProductDatabases.PLU_PRODUCT_DATABASE.get(pluObj);
						box.addItem(p.getDescription() + " "+ PLU);
						PriceLookUpCodedUnit unit = new PriceLookUpCodedUnit(p.getPLUCode(), 1.5);

						check.scale.add(unit);
						//scaleObs.reactToWeightChangedEvent(check.scale, unit.getWeight());

						adder.addPLUProduct(p);
						check.scale.remove(unit);
						check.scale.disable();
						//scaleObs.reactToDisabledEvent(check.scale);
						success = true;
					} else
						success = false;
				}else {
					success = false;
				}

			}


		});
*/
		backButton.setBounds(x,y+65, 80,50);
		addButton.setBounds(x,y+130, 80,50);
		check.screen.setVisible(true);
		add(backButton);
		add(addButton);
		setVisible(false);
		setLayout(null);

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
		//addButton = new Button("ADD");
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
						
						adder.addPLUProduct(p);
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
		add(addButton);
		//frame.setVisible(true);
	}
	
	//public boolean getState() {
	//	return success;
	//}
}

package com.autovend.software;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.autovend.Barcode;
import com.autovend.BarcodedUnit;
import com.autovend.Numeral;
import com.autovend.devices.AbstractDevice;
import com.autovend.devices.BarcodeScanner;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.observers.AbstractDeviceObserver;
import com.autovend.devices.observers.BarcodeScannerObserver;
import com.autovend.external.ProductDatabases;
import com.autovend.products.BarcodedProduct;
import com.autovend.software.observers.CustomerIOStub;
import com.autovend.software.observers.ElectronicScaleObserverStub;
/**
 * 
 * Wasay Siddiqi
 *
 */
public class ScanItemsGUI extends AddItemGUI implements BarcodeScannerObserver{
	private BarcodeScanner scanner;
	
	public ScanItemsGUI(CustomerIO parent,SelfCheckoutStation scs) {
		super(parent,"Scan",scs);
		//JTextField txtBox = new JTextField(16);
		JPanel panel = new JPanel();
		JLabel labelAdded  = new JLabel("Item Added");
		JLabel labelError  = new JLabel("Error");
		labelAdded.setVisible(false);
		labelError.setVisible(false);
		
		check.scale.enable();
		scanner = new BarcodeScanner ();
		ElectronicScaleObserverStub scaleObs = new ElectronicScaleObserverStub();
		
		Button scanButton = new Button("SCAN");
		scanButton.setBounds(620, 700, 60, 30);
		
		scanButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

					Barcode code = new Barcode(Numeral.two,Numeral.two,Numeral.two, Numeral.two,Numeral.two,Numeral.two );
					if(ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(code)) {

						BarcodedProduct p = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(code);


						PurchasedItems.addProduct(p);
					} else {
						labelAdded.setVisible(false);
						labelError.setVisible(true);
					}
				
			}
			
		});
		panel.add(scanButton);
		panel.add(back);
		
		add(panel);
		setVisible(false);
		setSize(800,640);

		
		
	}

	@Override
	public void reactToEnabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactToDisabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactToBarcodeScannedEvent(BarcodeScanner barcodeScanner, Barcode barcode) {
		// TODO Auto-generated method stub
		
        
		
	}
}

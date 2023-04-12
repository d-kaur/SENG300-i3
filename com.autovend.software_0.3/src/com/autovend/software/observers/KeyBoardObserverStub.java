/**
 * 
 */
package com.autovend.software.observers;

import com.autovend.devices.AbstractDevice;
import com.autovend.devices.Keyboard;
import com.autovend.devices.observers.AbstractDeviceObserver;
import com.autovend.devices.observers.KeyboardObserver;
import com.autovend.devices.observers.TouchScreenObserver;

/**
 * @author wasay
 *
 */
public class KeyBoardObserverStub implements KeyboardObserver{

	@Override
	public void reactToEnabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactToDisabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactToKeyPressedEvent(Keyboard k, char c) {
		// TODO Auto-generated method stub
		
	}

	

}

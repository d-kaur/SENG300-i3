package com.autovend.software;

import com.autovend.Card.CardData;
import com.autovend.devices.AbstractDevice;
import com.autovend.devices.CardReader;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.observers.AbstractDeviceObserver;
import com.autovend.devices.observers.CardReaderObserver;

public class EnterMembershipBySwiping extends Membership implements CardReaderObserver {

	protected boolean swipeFlag;
	
	public EnterMembershipBySwiping(SelfCheckoutStation selfCheckoutStation) {
		super(selfCheckoutStation);
		this.swipeFlag = false;
	}

	@Override
	public void reactToEnabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {}

	@Override
	public void reactToDisabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {}
	
	@Override
	public void reactToCardRemovedEvent(CardReader reader) {}

	// System should only respond to *swiped* membership cards
	@Override
	public void reactToCardInsertedEvent(CardReader reader) {
		this.swipeFlag = false;
	}

	@Override
	public void reactToCardTappedEvent(CardReader reader) {
		this.swipeFlag = false;
	}

	@Override
	public void reactToCardSwipedEvent(CardReader reader) {
		this.swipeFlag = true;
	}

	@Override
	public void reactToCardDataReadEvent(CardReader reader, CardData data) {
		if (this.swipeFlag) {
			try {
				MemberData member = lookupMember(data.getNumber());
				// Display member info on GUI or whatever
			} catch (Exception e) {
				// Display member not found on GUI or whatever
			}
			this.swipeFlag = false;
		}
	}

}

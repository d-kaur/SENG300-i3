package com.autovend.software;

import com.autovend.devices.SelfCheckoutStation;

public class EnterMembershipByTyping extends Membership {

	public EnterMembershipByTyping(SelfCheckoutStation selfCheckoutStation) {
		super(selfCheckoutStation);
	}
	
	// Can't do much here yet since it relies so heavily on the GUI
	public MemberData getMembershipFromTyping(String memberNumber) {
		try {
			return lookupMember(memberNumber);
		} catch (Exception e) {
			return null;
		}
	}
	

}

package com.autovend.software;

public class MemberData {
	private String memberName;
	private String memberNumber;
	public MemberData(String memberName, String memberNumber) {
		this.memberName = memberName;
		this.memberNumber = memberNumber;
	}
	public String getMemberName() {
		return this.memberName;
	}
	public String getMemberNumber() {
		return this.memberNumber;
	}
}
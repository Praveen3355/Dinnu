package com.pms.Entities;

import org.springframework.stereotype.Component;
@Component
public class PolicyReturnObject {

	private String policyName;
	private String companyName;
	private int termAmount;
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTermAmount() {
		return termAmount;
	}
	public void setTermAmount(int termAmount) {
		this.termAmount = termAmount;
	}
}

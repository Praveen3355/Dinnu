package com.pms.Entities;

import java.time.LocalDate;

public class PolicyRegistrationObject {
  
	private String policyId;
	private String policyName;
	private String policyType;
	private LocalDate startDate;
	private int duration;
	private double intialDeposit;
	private int termsPerYear;
	private int termAmount;
	private double interest;
	private String company;
	private String usertype;
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getIntialDeposit() {
		return intialDeposit;
	}
	public void setIntialDeposit(double intialDeposit) {
		this.intialDeposit = intialDeposit;
	}
	public int getTermsPerYear() {
		return termsPerYear;
	}
	public void setTermsPerYear(int termsPerYear) {
		this.termsPerYear = termsPerYear;
	}
	public int getTermAmount() {
		return termAmount;
	}
	public void setTermAmount(int termAmount) {
		this.termAmount = termAmount;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}

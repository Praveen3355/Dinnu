package com.pms.Entities;

import java.util.Date;

public class PolicyRegistrationObject {

	private String policyName;
	private Date startDate;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
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

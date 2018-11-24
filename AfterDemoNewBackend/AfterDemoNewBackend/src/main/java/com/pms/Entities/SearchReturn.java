package com.pms.Entities;

public class SearchReturn {

private String policyId;
private String policyName;
private double initialDeposit;
private int duration;
private int termsPerYear;
private int termAmount;
private double interest;
private double maturityAmount;
public String getPolicyId() {
	return policyId;
}
public void setPolicyId(String policyId) {
	this.policyId = policyId;
}
public String getPolicyName() {
	return policyName;
}
public void setPolicyName(String policyName) {
	this.policyName = policyName;
}
public double getInitialDeposit() {
	return initialDeposit;
}
public void setInitialDeposit(double initialDeposit) {
	this.initialDeposit = initialDeposit;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
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
public double getMaturityAmount() {
	return maturityAmount;
}
public void setMaturityAmount(double maturityAmount) {
	this.maturityAmount = maturityAmount;
}



}

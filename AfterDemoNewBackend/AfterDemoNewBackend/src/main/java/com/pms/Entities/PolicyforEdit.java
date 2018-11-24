package com.pms.Entities;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PolicyforEdit {
	
	
	private String policyId;
	private String policyName;
	private String policyType;
	private LocalDate startDate;
	private int duration;
	private double intialDeposit;
	private int termsPerYear;
	private double maturityAmount;
	private int termAmount;
	private double interest;
	private String comp;
	private int type1;
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
	public double getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
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
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public int getType1() {
		return type1;
	}
	public void setType1(int type1) {
		this.type1 = type1;
	}
	
	
	
}
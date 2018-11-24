package com.pms.Entities;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PolicyPaymentDisplay {
private String PolicyId;
private String PolicyName;
private LocalDate CurrentDate;
private LocalDate DueDate;
private String UserId;
private double Amount;
private double fine;
public LocalDate getDueDate() {
	return DueDate;
}
public void setDueDate(LocalDate dueDate) {
	DueDate = dueDate;
}

	public String getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(String policyId) {
		PolicyId = policyId;
	}
	public String getPolicyName() {
		return PolicyName;
	}
	public void setPolicyName(String policyName) {
		PolicyName = policyName;
	}
	public LocalDate getCurrentDate() {
		return CurrentDate;
	}
	public void setCurrentDate(LocalDate currentDate) {
		CurrentDate = currentDate;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	
	
	
	

}

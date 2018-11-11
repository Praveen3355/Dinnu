package com.pms.Entities;

import java.time.LocalDate;

public class PolicyRegisterReturnObject {

	private String policyId;
	private String policyType;
	private LocalDate startDate;
	private LocalDate endDate;
	private int nthPolicy;
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
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getNthPolicy() {
		return nthPolicy;
	}
	public void setNthPolicy(int nthPolicy) {
		this.nthPolicy = nthPolicy;
	}
}

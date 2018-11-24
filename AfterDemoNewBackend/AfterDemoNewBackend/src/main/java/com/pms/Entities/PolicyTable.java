package com.pms.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PolicyTable")
public class PolicyTable {
	public Usertype getType() {
		return type;
	}
	public void setType(Usertype type) {
		this.type = type;
	}
	@Id
	private String policyId;
	@Column(name="policy_name")
	private String policyName;
	@Column(name="policy_type")
	private String policyType;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="duration")
	private int duration;
	@Column(name="initial_deposit")
	private double intialDeposit;
	@Column(name="terms_per_year")
	private int termsPerYear;
	

	private double maturityAmount;
	@Column(name="term_amount")
	private int termAmount;
	@Column(name="interest")
	private double interest;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	@OneToMany(mappedBy="policy")
	private List<UserEnrolledPolicy> peu =new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usertype type;
	/*@Transient
	private int t1;
	@Transient
	private String t;
	*/
	public double getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<UserEnrolledPolicy> getPeu() {
		return peu;
	}
	public void setPeu(List<UserEnrolledPolicy> peu) {
		this.peu = peu;
	}
	
	
}
	
	

package com.pms.Entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Company")
public class Company {
@Id
private String companyId;
@Column(name="company_name")
private String companyName;
@OneToMany(mappedBy="company")
List<PolicyTable> policies = new ArrayList<>();
public String getCompanyId() {
	return companyId;
}
public void setCompanyId(String companyId) {
	this.companyId = companyId;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public List<PolicyTable> getPolicies() {
	return policies;
}
public void setPolicies(List<PolicyTable> policies) {
	this.policies = policies;
}

}

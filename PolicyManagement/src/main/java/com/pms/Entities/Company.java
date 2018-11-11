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

public List<PolicyTable> getPolicies() {
	return policies;
}
public void setPolicies(List<PolicyTable> policies) {
	this.policies = policies;
}
public String getCompany_Id() {
	return companyId;
}
public void setCompany_Id(String company_Id) {
	companyId = company_Id;
}
public String getCompany_Name() {
	return companyName;
}
public void setCompany_Name(String company_Name) {
	companyName = company_Name;
}

}

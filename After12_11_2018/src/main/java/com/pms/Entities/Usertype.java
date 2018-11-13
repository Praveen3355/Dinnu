package com.pms.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usertype")
public class Usertype {
	@Id
	private int typeid;
	@Column(name="type_variable")
	private String typeVariable;
	
	@OneToMany(mappedBy="type")
	private List<PolicyTable> policy = new ArrayList<>();
	
	public List<PolicyTable> getPolicy() {
		return policy;
	}
	public void setPolicy(List<PolicyTable> policy) {
		this.policy = policy;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypeVariable() {
		return typeVariable;
	}
	public void setTypeVariable(String typeVariable) {
		this.typeVariable = typeVariable;
	}
	

}

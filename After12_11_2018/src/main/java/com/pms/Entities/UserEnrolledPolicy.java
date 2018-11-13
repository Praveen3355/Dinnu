package com.pms.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserEnrolledPolicy {
	
	@Id
	private int id;
	@ManyToOne
	Mainuser user;
	@ManyToOne
	PolicyTable policy;
	@Column(name="enrolled_date")
	private Date enrolledDate;
	public Mainuser getUser() {
		return user;
	}
	public void setUser(Mainuser user) {
		this.user = user;
	}
	public PolicyTable getPolicy() {
		return policy;
	}
	public void setPolicy(PolicyTable policy) {
		this.policy = policy;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getEnrolledDate() {
		return enrolledDate;
	}
	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}
	
	
	

}

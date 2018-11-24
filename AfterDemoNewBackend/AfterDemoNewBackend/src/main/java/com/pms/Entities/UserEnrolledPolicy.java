package com.pms.Entities;

import java.time.LocalDate;
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
	private LocalDate enrolledDate;
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
	
	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}
	public void setEnrolledDate(LocalDate enrolledDate) {
		this.enrolledDate = enrolledDate;
	}
	
	
	

}

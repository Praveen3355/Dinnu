package com.pms.Entities;

import org.springframework.stereotype.Component;

@Component
public class PaymentObject {
	
	private String user;
	private String policy;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	

}

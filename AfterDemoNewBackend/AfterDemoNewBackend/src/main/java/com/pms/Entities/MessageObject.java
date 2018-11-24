package com.pms.Entities;

import org.springframework.stereotype.Component;

@Component
public class MessageObject {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	}

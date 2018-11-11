package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.service.Service1;



@RestController
@CrossOrigin
public class LoginController {
	@Autowired
    Service1 simple;
	LoginObject value=null;
	@RequestMapping(value="/login/",method=RequestMethod.POST)
	public String loginMethod(@RequestBody LoginObject value) {
        // @RequestBody LoginObject value   2. value
		String message=simple.authenticate(value); 
		System.out.println("controller");     
		return message;
		//return new ResponseEntity<Map<String,String>>(value , HttpStatus.OK);
	}
	
	@PostMapping(value="/register/")
	public ResponseEntity<?> registerMethod1(@RequestBody Mainuser user) {
		
		String message=simple.registerUser(user);
        
		return new ResponseEntity<String>(message , HttpStatus.OK);
			}

	
}

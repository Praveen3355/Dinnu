package com.pms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.PolicyTable;
import com.pms.service.Service1;
@RestController
@CrossOrigin
@ComponentScans(value = { @ComponentScan("com.pms.dao"), @ComponentScan("com.pms.service") })
public class LoginController {
	@Autowired
    Service1 simple;
	LoginObject value=null;
	@RequestMapping(value="/login/",method=RequestMethod.POST)
	public ResponseEntity<String> loginMethod(@RequestBody LoginObject value) {
        // @RequestBody LoginObject value   2. value
		String message=simple.authenticate(value); 
		System.out.println("controller");     
		//return message;
		return new ResponseEntity<String>(message , HttpStatus.OK);
	}
	
	
	@GetMapping("/getPolicyList/")
	public List<PolicyTable> polList(@RequestParam ("userid") String user){
		
		List<PolicyTable> tab=new ArrayList<>();
		System.out.println(user);
		return tab;
		
	}
	
	@RequestMapping(value="/register/",method=RequestMethod.POST)
	public ResponseEntity<?> registerMethod1(@RequestBody Mainuser user) {
		 System.out.println("hi gowtham");
		String a=simple.registerUser(user);
        System.out.println(user.getEmailId());
		return new ResponseEntity<String>(a, HttpStatus.OK);
			}

	
}

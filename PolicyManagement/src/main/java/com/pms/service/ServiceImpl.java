package com.pms.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.PolicyTable;
import com.pms.dao.MainDataRepo;
import com.pms.dao.PolicyDataRepo;
@Service
public class ServiceImpl implements Service1{

	// Register and Login 
	
	@Autowired
    private MainDataRepo dao1;
	
	@Autowired
	private PolicyDataRepo dao2;
    
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	Mainuser name;
    
    
	@Override
	public String authenticate(LoginObject log) {
		       
		       name=null;
		       String mess="";
		       name= dao1.findByName(log.getUser());
		       if(name!=null) {
		       if(name.getPasscode().equals(log.getPass()))
		    	  mess="authenticated "+ name.getPasscode();
		       else
		    	  mess="incorrect password ";
		       }
		       else mess="User not found";
		       
		    	return mess;			
	}
	@Override
	public String registerUser(Mainuser user) {
		Calendar cal=Calendar.getInstance();
		name=null;
		String b="";
		name=dao1.findByPanNoAndEmaiId(user.getPanNo(), user.getEmailId());
		System.out.println("user id "+user.getPanNo() +" passcode "+user.getPasscode() );
		double a=user.getSalary();
		if(a<=5) b="A";
		else if(a<=10) b="B";
		else if(a<=15) b="C";
		else if(a<=20) b="D";
		else if(a<=25) b="E";
		else if(a<=30 || a>30) b="F";
		if(name==null) {
			name= dao1.findByUserId(b);
				String[] val=name.getUserId().split("-");
			user.setUserId(b+"-"+(Integer.parseInt(val[1])+1));
			String pass=""+(new SimpleDateFormat("dd").format(cal.getTime()))+(new SimpleDateFormat("MMM").format(cal.getTime())).toLowerCase()+""
			                      +((new Random().nextInt(998-100))+100)+"";
			user.setPasscode(pass);
			dao1.saveAndFlush(user);
			
		}
		//dao1.saveAndFlush(user);
		return null;
	}
	
  // Policy Registration 
	
	public String registerPolicy(PolicyTable obj) {
		
		
		//Checks Start Date VAlidation
		LocalDate today =  LocalDate.now(); 
		LocalDate date = obj.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    if(today.isBefore(date)) return "Start date is not correct please redefine the policy";
		
	    // Save the object with required values. 
	    PolicyTable tab1= dao2.findByPolicyType(obj.getPolicyType());
		String[] val=tab1.getPolicyId().split("-");
		obj.setPolicyId(val[0]+"-"+val[1]+"-"+(Integer.parseInt(val[2])+1));
		dao2.saveAndFlush(obj);
		date.plusYears(obj.getDuration());
		//Maturityamount = (initial deposit) + (duration * term_in_years * term amount) + ((duration * term_in_years * term amount) * (interest /100))
		return "   The policy"+ obj.getPolicyId() +"is available to the users from "+ obj.getStartDate() +" to"+ date.format(dateTimeFormatter) +
				"This is the"+ (val[2]+1) +"th policy in the "+ obj.getPolicyType();
		
	}
	@Override
	public String save(PolicyTable policy) {
		LocalDate today =  LocalDate.now(); 
		LocalDate date = policy.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		 if(today.isBefore(date)) return "Start date is not correct please redefine the policy";
		 else
		 {
			 PolicyTable tab1= dao2.findByPolicyType(policy.getPolicyType());
				String[] val=tab1.getPolicyId().split("-");
				policy.setPolicyId(val[0]+"-"+val[1]+"-"+(Integer.parseInt(val[2])+1));
			 date.plusYears(policy.getDuration());
			 dao2.saveAndFlush(policy);
			double  Maturityamount = (policy.getIntialDeposit()) + (policy.getDuration() * policy.getTermsPerYear() * policy.getTermAmount()) + ((policy.getDuration() * policy.getTermsPerYear() * policy.getTermAmount()) * (policy.getInterest() /100));
			  return ("The policy has been succesfully updated and the end date for the updated policy is "+ " "+ date.format(dateTimeFormatter)+" "+",it's maturity amount is"+ " "
+Maturityamount);		 
			
	}
	}
	@Override
	public Optional<PolicyTable> findById(String policyId) {
		
		return dao2.findById(policyId);
	}
	@Override
	public int findNumber(String userid, String var) {
		
		return findNumber(userid,var);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

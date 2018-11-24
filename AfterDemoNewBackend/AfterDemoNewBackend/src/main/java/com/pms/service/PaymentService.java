
package com.pms.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.Entities.Mainuser;
import com.pms.Entities.MessageObject;
import com.pms.Entities.Payment;
import com.pms.Entities.PaymentObject;
import com.pms.Entities.PolicyPaymentDisplay;
import com.pms.Entities.PolicyTable;
import com.pms.Entities.UserEnrolledPolicy;
import com.pms.dao.MainDataRepo;
import com.pms.dao.PaymentAcessDao;
import com.pms.dao.PolicyDataRepo;
import com.pms.dao.UserEnrolledPolicyDataRepo;

@Service
public class PaymentService implements PaymentServiceInterface {
@Autowired
PaymentAcessDao  pad;
@Autowired
PolicyDataRepo dao2;
@Autowired
UserEnrolledPolicyDataRepo uepd;
UserEnrolledPolicy uep;

Payment payment ;
@Autowired
MessageObject mess;
@Autowired
PolicyPaymentDisplay pd;
PolicyTable pinfo;
LocalDate ld ;
String  policyName=null;
Mainuser u;
@Autowired
MainDataRepo uad;
@Override
public ResponseEntity<?> generateBill(PaymentObject obj) {

    payment= pad.findByName(obj.getUser(),obj.getPolicy());
    System.out.print(obj.getPolicy()+"gskdhsb");
 /*   System.out.println(payment.getBillId());
    System.out.println(payment.getBillDate());
    System.out.println(payment.getDueDate());
    System.out.println(payment.getFine());
    System.out.println(payment.getUser());*/
    
    policyName=dao2.getpolicyname(obj.getPolicy());
    System.out.println(policyName);
    pd.setPolicyId(obj.getPolicy());
    pd.setPolicyName(policyName);
    ld =java.time.LocalDate.now(); 
    pd.setCurrentDate(ld);
    pd.setUserId(obj.getUser());
    pinfo=dao2.findByPolicyId(obj.getPolicy());
    System.out.println(pinfo.getTermAmount());
    if(payment==null) {
    	Mainuser user=uad.findByUserid(obj.getUser());
    	String[] a = obj.getPolicy().split("-",-2);
		System.out.println(a[1] +"");
    	int noOfPolicies=uepd.countPolicies(obj.getUser(),a[1]);
    	System.out.println(noOfPolicies);
    	double sumOfPolicies=0;
    	ArrayList<String> pol =uepd.getNoOfPoliciesEnrolled(obj.getUser());
    	System.out.println("no of policies of A"+pol.size());
    	for(String policyid: pol) {
    		int x=dao2.findPolicyTermAmount(policyid);
    		int y= dao2.findPolicyYears(policyid);
    		sumOfPolicies+=(x*y);
    	}
    	sumOfPolicies+=dao2.findPolicyTermAmount(obj.getPolicy())*dao2.findPolicyYears(obj.getPolicy());
    	
    	
    	double income=0.4*user.getSalary();
    	System.out.println(sumOfPolicies);
		System.out.println(income);
    	
    	MessageObject mess =new MessageObject();
    	if(sumOfPolicies>income) {
    		System.out.println("Sorry too many policies registered");
    		
    		mess.setMessage("Sorry too many policies registered");
    		return new ResponseEntity<MessageObject>( mess,HttpStatus.OK);
    		
    	}
    	if(noOfPolicies>=2) {
    		System.out.println("Sorry you cannot register more than two polices under this policy type");
    		
    		mess.setMessage("Sorry you cannot register more than two polices under this policy type");
    		return new ResponseEntity<MessageObject>(mess ,HttpStatus.OK);
    		
    	}
    	
    	
    	
    	
    	else {
    	
    	
    	pd.setFine(0);
    	System.out.println(pinfo.getTermAmount());
    	pd.setAmount(pinfo.getIntialDeposit()+pinfo.getTermAmount());
    	pd.setDueDate(ld.plusMonths((long)pinfo.getTermsPerYear()));
    	System.out.println(user.getAddress());
    	
    	
    	}
    	return new ResponseEntity<PolicyPaymentDisplay>(pd,HttpStatus.OK) ;
    }  
    
    else {
    	
    	
    	if(ld.isBefore(payment.getDueDate())||(ld.compareTo(payment.getDueDate())==0)) {
    		pd.setFine(0);
    		pd.setAmount(pinfo.getTermAmount());
    		pd.setDueDate(payment.getDueDate().plusMonths((long)pinfo.getTermsPerYear()));
    		
    	}
    	else {
    		System.out.println("Hello Maven");
    		LocalDate d1 = payment.getDueDate();
    		LocalDate d2=d1;
    		while(d1.isBefore(ld)) {
    			d1=d1.plusMonths((long)pinfo.getTermsPerYear());
    		}
    		long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(ld, d2);
    		System.out.println(daysBetween);
    		String polId=obj.getPolicy();
    		String[] a = polId.split("-",-2);
    		System.out.println(a[1]);
    		double finepercent=0;
    		 switch(a[1]) {
    		 case "VL":finepercent=5;
    		 			break;
    		 case "TI":finepercent=4.5;
    		 			break;
    		 case "LI":finepercent=4;
    		 			break;
    		 case "HI":finepercent=4;
    		 			break;
    		 case "CP":finepercent=4.75;
	 			break;
    		 case "RP":finepercent=2.5;
	 			break;
    		 
    		 }
    		 System.out.println(finepercent);
    		
    		 
    		double fine = (finepercent*pinfo.getTermAmount())/100;
    		
    		double amtToPay=fine*Math.abs(daysBetween)+pinfo.getTermAmount();
    		pd.setAmount(amtToPay);
    		pd.setFine(fine*Math.abs(daysBetween));
    		System.out.println(pd.getFine());
    		pd.setDueDate(d1);
    		
    	}
    	return new ResponseEntity<PolicyPaymentDisplay>(pd,HttpStatus.OK) ;
    }
    
}
public String sucessMsg(PolicyPaymentDisplay ppd) {
	payment= pad.findByName(ppd.getUserId(),ppd.getPolicyId());
	Mainuser user=uad.findByUserid(ppd.getUserId());
	if(payment==null) {
	uep= new UserEnrolledPolicy();
	
	Integer i = uepd.findLatestUserId(ppd.getUserId());
	if(i==null) {
	uep.setId(1);
	}
	else {
		uep.setId(i.intValue()+1);
	}
	uep.setUser(user);
	uep.setEnrolledDate(ld);
	uep.setPolicy(pinfo);
	uepd.save(uep);
	}
	 
	String billId=pad.findLatestBill();
	String wfof=null;
	if(billId==null) {
		if(ppd.getFine()==0)
		{
			wfof="ON";
		}
		else
			wfof="WF";
		billId=ppd.getPolicyId()+"-"+wfof+"-"+String.format("%03d", 1);
		
	}
	else {
	String a[]= billId.split("-",-3);
	
	int p =Integer.parseInt(a[a.length-1]);
	p=p+1;
	
	if(ppd.getFine()==0)
	{
		wfof="ON";
	}
	else
		wfof="WF";
	
	billId=ppd.getPolicyId()+"-"+wfof+"-"+String.format("%03d", p);
	
	}
	
	System.out.println(billId);
	
	System.out.println(user.getFirstName());
	
	//pad.insertNewBill(ppd.getCurrentDate(),ps.getBillId(),ppd.getDueDate(),ppd.getFine(),ppd.getAmount(),user);
	Payment pay= new Payment();
	pay.setBillId(billId);
	pay.setBillDate(ppd.getCurrentDate());
	pay.setDueDate(ppd.getDueDate());
	pay.setFine(ppd.getFine());
	pay.setPaidAmt(ppd.getAmount());
	pay.setUser(user);
	pad.save(pay);
	return "Payment Sucessfull.Your Bill Id is "+billId+"Next DueDate is "+ppd.getDueDate();
	
	
}
}


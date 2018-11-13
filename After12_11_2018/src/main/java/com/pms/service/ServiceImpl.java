package com.pms.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.Entities.Hint;
import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.PolicyTable;
import com.pms.Entities.UserEnrolledPolicy;
import com.pms.dao.MainDataRepo;
import com.pms.dao.PolicyDataRepo;
@Service
public class ServiceImpl implements Service1{

	// Register and Login 
	
	@Autowired
    private MainDataRepo dao1;
   List<com.pms.Entities.Mainuser> name;
   com.pms.Entities.Mainuser name1;
	@Autowired
	private PolicyDataRepo dao2;
    
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Override
	public String authenticate(LoginObject log) {
		       
		       name1=null;
		       String mess="";
		       name1= dao1.findByName(log.getUser());
		       if(name1!=null) {
		       if(name1.getPasscode().equals(log.getPass()))
		    	  mess="authenticated " +((name1.getUserid().matches("admin(.*)"))?"admin":"user");
		       else
		    	  mess="incorrect password ";
		       }
		       else mess="User not found";
		       
		    	return mess;			
	}
	@Override
	public String registerUser(Mainuser user) {
		
		Calendar cal=Calendar.getInstance();
		name=null;List<Mainuser> test=null;
		String b="",mess="";
		name=dao1.findByPanNoOrEmaiId(user.getPanNo(), user.getEmailId());
		System.out.println("user id "+user.getAddress() +" passcode ");
		double a=user.getSalary();
		System.out.println("before salary");
		if(a<=5) b="A";
		else if(a<=10) b="B";
		else if(a<=15) b="C";
		else if(a<=20) b="D";
		else if(a<=25) b="E";
		else if(a<=30 || a>30) b="F";
		System.out.println("before if");
		if(name==null) {
			System.out.println("after if");
			//String str = String.format("%04d", 9);
			test= dao1.findByUseridStartingWithOrderByUseridDesc(b);
			System.out.println("after func");
			String[] val=test.get(0).getUserid().split("-");
			user.setUserid(b+"-"+String.format("%03d",(Integer.parseInt(val[1])+1)));
			String pass=""+(new SimpleDateFormat("dd").format(cal.getTime()))+(new SimpleDateFormat("MMM").format(cal.getTime())).toLowerCase()+""
			                      +((new Random().nextInt(998-100))+100)+"";
			System.out.println("after passcode");
			user.setPasscode(pass);
			Hint t=new Hint();
			
 			t.setHintId(user.getHintid());
 			user.setHint(t);
   /*     System.out.println(user.getAddress());
			
			create calendar object for current day
		      long currentTime = System.currentTimeMillis();
			LocalDate today =  LocalDate.now(); 
			Date today= new Date();
		      Calendar now = Calendar.getInstance();
		      now.setTime(today);
		      now.setTimeZone(today);
		    create calendar object for birth day
		      Calendar birthDay = Calendar.getInstance();
		      String s=user.getDob();
		      SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		      Date d=sd.parse(s);
		      birthDay.setTime(user.getDob());
		     long y1=now.getTimeInMillis();
		      long y2=birthDay.getTimeInMillis();
		      double age=((y1-y2)/1000*60*60*24*365);
		     char first=user.getFirstName().charAt(0);
		      char last=user.getLastName().charAt(0); */
			DateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			String str2=sd.format(user.getDob());
			
			LocalDate ld2=LocalDate.parse(str2,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate ld1=LocalDate.now();
			Period p = Period.between(ld2, ld1);
			int age=p.getYears();
			//long diff=ChronoUnit.SECONDS.between(ld1, ld2);
			//double age=((diff)/60*60*24*(365.2425));
		      if( age>18 && age<=60)
		      {
		    	  //String.format("[A-Z]{3}%S%S[0-9]{4}%S,first,last,)
			if(user.getPanNo().matches(("^[A-Z]{5}[0-9]{4}[A-Z]{1}$")))
			{
			dao1.saveAndFlush(user);
			mess="The user id is "+user.getUserid()+" and password "+user.getPasscode();
			}
			else
			{
				mess="Sorry.! Pan number you entered is invalid";
			}
		}
		      else
		      {
		    	  mess="Sorry..! Your age is not matching with our requirements to register you "; 
		      }
		}
		else
		mess="Sorry ..! PAN Number or the EMAIL ID already exists or are not valid. Please Check for the credentials";
		
	return mess;
		/*Calendar cal=Calendar.getInstance();
		name=null;  List<Mainuser> test=null;//Mainuser test =null;//
		String b="",mess="";
		//name=dao1.findByPanNo.0EmaiId(user.getPanNo(), user.getEmailId());
		System.out.println("user id "+user.getAddress() +" passcode ");
		
		double a=user.getSalary();
		System.out.println("before salary");
		if(a<=500000) b="A";
		else if(a<=1000000) b="B";
		else if(a<=1500000) b="C";
		else if(a<=2000000) b="D";
		else if(a<=2500000) b="E";
		else if(a<=3000000 || a>3000000) b="F";
		
		System.out.println(b);
		if(name==null) {
			System.out.println("after if");
			//String str = String.format("%04d", 9);
			test= dao1.findByUseridStartingWithOrderByUseridDesc(b);
		    System.out.println(test.get(0).getUserid());
			System.out.println(test.get(0).getPasscode());
			System.out.println(test.get(0).getDob());
			if(!(test==null)) {
				String[] val=test.get(0).getUserid().split("-");
				System.out.println(val[0]);
				System.out.println(val[1]);
				user.setUserid(b+"-"+String.format("%03d",(Integer.parseInt(val[1])+1)));
				
			}
			else {

				user.setUserid(b+"-"+String.format("%03d",1));
				
				
			}
		//	System.out.println(name.getDob());
			String pass=""+(new SimpleDateFormat("dd").format(cal.getTime()))+(new SimpleDateFormat("MMM").format(cal.getTime())).toLowerCase()+""
			                      +((new Random().nextInt(998-100))+100)+"";
			System.out.println("after passcode");
			user.setPasscode(pass);
			Hint t=new Hint();
			
 			t.setHintId(user.getHintid());
     //	     System.out.println(user.getAddress());
			user.setHint(t);
			dao1.saveAndFlush(user);
			mess="The user id is "+user.getUserid()+" and password "+user.getPasscode();
		}
		else
		mess="Sorry ..! PAN Number or the EMAIL ID already exists or are not valid. Please Check for the credentials";
		
	return mess;*/
	}
	
	public String registerPolicy(PolicyTable obj) {
		
		double f=0;
		//Checks Start Date VAlidation
		LocalDate today =  LocalDate.now(); 
		LocalDate date = obj.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    if(today.isBefore(date)) return "Start date is not correct please redefine the policy";
		System.out.println(obj.getPolicyType());
		List<PolicyTable> tab1= dao2.findByPolicyType(obj.getPolicyType());
		int m=tab1.size();
		String[] val=tab1.get(m-1).getPolicyId().split("-");
		obj.setPolicyId(val[0]+"-"+val[1]+"-"+String.format("%03d",(Integer.parseInt(val[2])+1)));
		/*Company compT=new Company();
		compT.setCompanyId(obj.getT());
		Usertype typT1=new Usertype();
		typT1.setTypeid(obj.getT1());
		obj.setCompany(compT);
		obj.setType(typT1);*/
		dao2.save(obj);
		date.plusYears(obj.getDuration());
		//Maturity amount = (initial deposit) + (duration * term_in_years * term amount) + ((duration * term_in_years * term amount) * (interest /100))
		return "The policy"+ obj.getPolicyId() +"is available to the users from "+ obj.getStartDate() +" to"+ date.format(dateTimeFormatter) +
				"This is the"+ (Integer.parseInt(val[2])+1) +" th policy in the "+ obj.getPolicyType();
		 
			
		
	}
	
	
	@Override
	public String save(PolicyTable policy) {
		LocalDate today =  LocalDate.now(); 
		LocalDate date = policy.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		 if(today.isBefore(date)) return "Start date is not correct please redefine the policy";
		 else
		 {
			 //List<PolicyTable> tab1= dao2.findByPolicyTypeOrderByPolicyIdDesc(policy.getPolicyType());
			 List<PolicyTable> tab1= dao2.findByPolicyType(policy.getPolicyType());
			 int k=tab1.size();
				String[] val=tab1.get(k-1).getPolicyId().split("-");
				policy.setPolicyId(val[0]+"-"+val[1]+"-"+(Integer.parseInt(val[2])+1));
			 date.plusYears(policy.getDuration());
			 if(val[1]=="VL")
				 policy.setInterest(5*(policy.getTermAmount()/100));
			 else if(val[1]=="TL")
				 policy.setInterest(4.5*(policy.getTermAmount()/100));
			 else if(val[1]=="LF")
				 policy.setInterest(4*(policy.getTermAmount()/100));
			 else if(val[1]=="HL")
				 policy.setInterest(4*(policy.getTermAmount()/100));
			 else if(val[1]=="CP")
				 policy.setInterest(4.75*(policy.getTermAmount()/100));
			 else if(val[1]=="RT")
				 policy.setInterest(2.5*(policy.getTermAmount()/100));
			 
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
		
		return dao2.findNumber(userid,var);
	}
	@Override
	public List<UserEnrolledPolicy> findByUserId(String userid) {
		
		return dao2.findByUserId(userid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}


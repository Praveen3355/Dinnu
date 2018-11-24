package com.pms.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.Entities.Hint;
import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.MessageObject;
import com.pms.Entities.PolicyReturnObject;
import com.pms.Entities.PolicyTable;
import com.pms.Entities.PolicyforEdit;
import com.pms.Entities.SearchReturn;
import com.pms.Entities.UserEnrolledPolicy;
import com.pms.dao.CompanyDataRepo;
import com.pms.dao.MainDataRepo;
import com.pms.dao.PolicyDataRepo;
import com.pms.dao.UserEnrolledPolicyDataRepo;
@Service
public class ServiceImpl implements Service1{

	// Register and Login 

	@Autowired
	private MainDataRepo dao1;
	List<com.pms.Entities.Mainuser> name;
	
	
	PolicyReturnObject p;
	
	com.pms.Entities.Mainuser name1;
	@Autowired
	private PolicyDataRepo dao2;

	@Autowired
	private CompanyDataRepo dao4;
	 @Autowired
		PolicyforEdit pd =null ;
	
	@Autowired
	private UserEnrolledPolicyDataRepo dao3;

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Override
	public String authenticate(HttpServletRequest request,LoginObject log) {
        String ip ="10.230.166.92";
		name1=null;
		String mess="";
		System.out.println(request.getRemoteAddr());
		name1= dao1.findByName(log.getUser());
		if(name1!=null) {
			if(name1.getPasscode().equals(log.getPass())  && (name1.getUserid().matches("admin(.*)"))) 
				mess="authenticated admin";
			else if(name1.getPasscode().equals(log.getPass())  && !(name1.getUserid().matches("admin(.*)")))	
				mess="authenticated user";
			else if(name1.getPasscode().equals(log.getPass()) && !request.getRemoteAddr().equals(ip) && (name1.getUserid().matches("admin(.*)")))
					mess="Admin Access denied";
			else if(!name1.getPasscode().equals(log.getPass()) )
				mess="incorrect password ";
		}
			
				
		
		else mess="User not found";

		return mess;			
	}
	@Override
	public String registerUser1(Mainuser user) {

		Calendar cal=Calendar.getInstance();
		name=null;List<Mainuser> test=null;
		String b="",mess="";
		name=dao1.findByPanNoOrEmaiId(user.getPanNo(), user.getEmailId());
		if(!(name==null)) {
			System.out.println((name==null) +" "+ name.size() );
			//System.out.println(name.get(0).getEmailId() +" "+ name.get(0).getPanNo() +" "+name.size());
		}
		System.out.println("user id "+user.getAddress() +" passcode ");
		double a=user.getSalary();
		System.out.println("before salary");
		if(a<=500000) b="A";
		else if(a<=1000000) b="B";
		else if(a<=1500000) b="C";
		else if(a<=2000000) b="D";
		else if(a<=2500000) b="E";
		else if(a<=3000000 || a>3000000) b="F";
		System.out.println("before if");
		if(name.size() == 0) {
			System.out.println("after if");
			//String str = String.format("%04d", 9);
			test= dao1.findByUseridStartingWithOrderByUseridDesc(b);
			System.out.println("after func");
			if(!test.isEmpty()) {
				
				String[] val=test.get(0).getUserid().split("-");
				System.out.println(val[0]);
				user.setUserid(b+"-"+String.format("%02d",(Integer.parseInt(val[1])+1)));
			}
			else {
				
				user.setUserid(b+"-"+String.format("%02d",1));
			}
			/*String pass=""+(new SimpleDateFormat("dd").format(cal.getTime()))+(new SimpleDateFormat("MMM").format(cal.getTime())).toLowerCase()+""
					+((new Random().nextInt(998-100))+100)+"";
			System.out.println("after passcode");
			user.setPasscode(pass);*/
			Hint t=new Hint();

t.setHintId(user.getHintid());
			user.setHint(t);
			LocalDate dat1 = user.getDob();
			LocalDate dat2= LocalDate.now();
			Period interval =Period.between(dat1,dat2);
			System.out.println(interval.getYears());   //.getDisplayName(TextStyle.FULL ,   Locale.CANADA_FRENCH 
		    System.out.println(user.getFirstName().charAt(0) + " "+ user.getLastName().charAt(0) +" " +dat1.getMonth().getDisplayName(TextStyle.FULL, Locale.UK).charAt(0));
			
		    if( interval.getYears()>18 && interval.getYears()<=60)
			{   System.out.println(user.getPanNo());
				if(user.getPanNo().matches(("^[A-Za-z]{3}["+user.getFirstName().toUpperCase().charAt(0)+"]["+user.getLastName().toUpperCase().charAt(0)+"][0-9]{4}["+dat1.getMonth().getDisplayName(TextStyle.FULL, Locale.UK).charAt(0)+"]$")))
				{
					//dao1.saveAndFlush(user);
					mess="your user id is"+" " +user.getUserid()+","+ " " +"create your password now";
					System.out.println(user.getPasscode()+" passcode ");
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
		
	}
///////
	@Override
	public String registerUser2(Mainuser user) {
		Calendar cal=Calendar.getInstance();
		name=null;List<Mainuser> test=null;
		String b="",mess="";
		name=dao1.findByPanNoOrEmaiId(user.getPanNo(), user.getEmailId());
		if(!(name==null)) {
			System.out.println((name==null) +" "+ name.size() );
			//System.out.println(name.get(0).getEmailId() +" "+ name.get(0).getPanNo() +" "+name.size());
		}
		System.out.println("user id "+user.getAddress() +" passcode ");
		System.out.println(user.getPasscode());
		double a=user.getSalary();
		System.out.println("before salary");
		if(a<=500000) b="A";
		else if(a<=1000000) b="B";
		else if(a<=1500000) b="C";
		else if(a<=2000000) b="D";
		else if(a<=2500000) b="E";
		else if(a<=3000000 || a>3000000) b="F";
		System.out.println("before if");
		if(name.size() == 0) {
			System.out.println("after if");
			//String str = String.format("%04d", 9);
			test= dao1.findByUseridStartingWithOrderByUseridDesc(b);
			System.out.println("after func");
			if(!test.isEmpty()) {
				
				String[] val=test.get(0).getUserid().split("-");
				System.out.println(val[0]);
				user.setUserid(b+"-"+String.format("%02d",(Integer.parseInt(val[1])+1)));
			}
			else {
				
				user.setUserid(b+"-"+String.format("%02d",1));
			}
			/*String pass=""+(new SimpleDateFormat("dd").format(cal.getTime()))+(new SimpleDateFormat("MMM").format(cal.getTime())).toLowerCase()+""
					+((new Random().nextInt(998-100))+100)+"";
			System.out.println("after passcode");
			user.setPasscode(pass);*/
			Hint t=new Hint();

			t.setHintId(user.getHintid());
			user.setHint(t);
			LocalDate dat1 = user.getDob();
			LocalDate dat2= LocalDate.now();
			Period interval =Period.between(dat1,dat2);
			System.out.println(interval.getYears());   //.getDisplayName(TextStyle.FULL ,   Locale.CANADA_FRENCH 
		    System.out.println(user.getFirstName().charAt(0) + " "+ user.getLastName().charAt(0) +" " +dat1.getMonth().getDisplayName(TextStyle.FULL, Locale.UK).charAt(0));
			
		    if( interval.getYears()>18 && interval.getYears()<=60)
			{   System.out.println(user.getPanNo());
				if(user.getPanNo().matches(("^[A-Za-z]{3}["+user.getFirstName().toUpperCase().charAt(0)+"]["+user.getLastName().toUpperCase().charAt(0)+"][0-9]{4}["+dat1.getMonth().getDisplayName(TextStyle.FULL, Locale.UK).charAt(0)+"]$")))
				{
					dao1.saveAndFlush(user);
					mess="your user id is"+" " +user.getUserid()+ " " +"create your password now";
					System.out.println(user.getPasscode());
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
	}
		

/////////	
	public String registerPolicy(PolicyTable obj) {

		
		//Checks Start Date VAlidation
		LocalDate today =  LocalDate.now(); 
		LocalDate date = obj.getStartDate();//.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(today.isAfter(date)) return "Start date is not correct please redefine the policy";
		else
		{
			String[] val=new String[] {};
			String test = null;
		System.out.println(obj.getPolicyType());
		
		List<PolicyTable> tab1= dao2.findByPolicyTypeOrderByPolicyIdDesc(obj.getPolicyType());
		//List<PolicyTable> tab1= dao2.findByPolicyTypeandName(obj.getPolicyType(),obj.getPolicyName());
		//int n=tab1.size();
		//String[] val=tab1.get(n-1).getPolicyId().split("-");
		if(tab1.isEmpty()) {
			if(obj.getPolicyType().equalsIgnoreCase("life")) test="LF";
			else if(obj.getPolicyType().equalsIgnoreCase("Vehicle")) test="VL";
			else if(obj.getPolicyType().equalsIgnoreCase("Child")) test="CH";
			else if(obj.getPolicyType().equalsIgnoreCase("Retirement")) test="RT";
			else if(obj.getPolicyType().equalsIgnoreCase("Health")) test="HL";
			else if(obj.getPolicyType().equalsIgnoreCase("Travel")) test="TL";
		    obj.setPolicyId(obj.getCompany().getCompanyId()+"-"+test+"-"+String.format("%03d",1));	
		}
		else {
	    val=tab1.get(0).getPolicyId().split("-");
		obj.setPolicyId(val[0]+"-"+val[1]+"-"+String.format("%03d",(Integer.parseInt(val[2])+1)));
		}
		LocalDate d2=date.plusYears(obj.getDuration());
		
	
	System.out.println(obj.getInterest());
		//Maturity amount = (initial deposit) + (duration * term_in_years * term amount) + ((duration * term_in_years * term amount) * (interest /100))
		double maturityAmount = (obj.getIntialDeposit()) + (obj.getDuration() * obj.getTermsPerYear() * obj.getTermAmount()) + ((obj.getDuration() * obj.getTermsPerYear() * obj.getTermAmount()) * (obj.getInterest() /100));
		obj.setMaturityAmount(maturityAmount);
		dao2.save(obj);
		return "The policy"+ obj.getPolicyId() +"is available to the users from "+ obj.getStartDate() +" to"+ d2.format(dateTimeFormatter) +
				"This is the"+ ((obj.getPolicyId().split("-"))[2]) +"  policy in the "+ obj.getPolicyType() ;

	}
	}
////pass
	

	@Override
	public String editPolicy(PolicyTable policy) {
		LocalDate today =  LocalDate.now(); 
		LocalDate date = policy.getStartDate() ;//.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		if(today.isAfter(date)) return "Start date is not correct please redefine the policy";
		else
		{
			List<PolicyTable> tab1= dao2.findByPolicyTypeandName(policy.getPolicyType(),policy.getPolicyName());
			//int n=tab1.size();
			//System.out.println(n);
			String[] val=tab1.get(0).getPolicyId().split("-");
			policy.setIntialDeposit(tab1.get(0).getIntialDeposit());
			policy.setPolicyId(val[0]+"-"+val[1]+"-"+String.format("%03d",Integer.parseInt(val[2])+1));
			//policy.setTermAmount(tab1.get(0).getTermAmount());
			policy.setTermsPerYear(tab1.get(0).getTermsPerYear());
			policy.setInterest(tab1.get(0).getInterest());
			LocalDate d2= date.plusYears(policy.getDuration());
			System.out.println(d2);
			System.out.println(policy.getTermAmount());
			System.out.println(policy.getDuration());
			System.out.println(policy.getTermsPerYear());
			System.out.println(policy.getIntialDeposit());
			System.out.println(val[1]);
		/*	if(val[1].equals("VL"))
				 policy.setInterest(5*(policy.getTermAmount()/100));
			 else if(val[1].equals("TL"))
				 policy.setInterest(4.5*(policy.getTermAmount()/100));
			 else if(val[1].equals("LF"))
				 policy.setInterest(4*(policy.getTermAmount()/100));
			 else if(val[1].equals("HL"))
			 {
				 
				 policy.setInterest(4*(policy.getTermAmount()/100));
			 }
			 else if(val[1].equals("CP"))
				 policy.setInterest(4.75*(policy.getTermAmount()/100));
			 else if(val[1].equals("RP"))
				 policy.setInterest(2.5*(policy.getTermAmount()/100));*/
			
			System.out.println(policy.getInterest());
			double maturityAmount = (policy.getIntialDeposit()) + (policy.getDuration() * policy.getTermsPerYear() * policy.getTermAmount()) + ((policy.getDuration() * policy.getTermsPerYear() * policy.getTermAmount()) * (policy.getInterest() /100));
			System.out.println(maturityAmount);

			policy.setMaturityAmount(maturityAmount);
			//.policy.getCompany().setCompanyId(companyId);
			dao2.saveAndFlush(policy);

			return ("The policy has been succesfully updated and the end date for the updated policy is "+ " "+ d2.format(dateTimeFormatter)+" "+",it's maturity amount is"+ " "
					+policy.getMaturityAmount());		 

		}
	}
	
	
	
	
	
	
	
	
	
	// search policy
	

	public List<SearchReturn> searchPolicy(String companyName,int years,String policyType,String policyName){
		List<PolicyTable> e=new ArrayList<>();
		List<SearchReturn> sr=new ArrayList<>();
		e= dao2.searchPolicy(companyName, years, policyType, policyName);
		for(int i=0;i<e.size();i++) {
			SearchReturn ssr =new SearchReturn();
			ssr.setPolicyId(e.get(i).getPolicyId());
			ssr.setPolicyName(e.get(i).getPolicyName());
			ssr.setDuration(e.get(i).getDuration());
			System.out.println();
			ssr.setInitialDeposit(e.get(i).getIntialDeposit());
			System.out.println(e.get(i).getIntialDeposit());
			ssr.setInterest(e.get(i).getInterest());
			System.out.println(e.get(i).getInterest());
			ssr.setMaturityAmount(e.get(i).getMaturityAmount());
			System.out.println(e.get(i).getMaturityAmount());
			ssr.setTermsPerYear(e.get(i).getTermsPerYear());
			ssr.setTermAmount(e.get(i).getTermAmount());
			sr.add(ssr);

		}


		return sr;

	}


	// return policy to user dashboard

	//
	@Override
	public ResponseEntity<?> findById(String policyId) {
       
		PolicyTable pt= null;
		pt=dao2.findByPolicyId(policyId);
		
		if(pt != null) {
			pd.setPolicyId(pt.getPolicyId());
			pd.setPolicyName(pt.getPolicyName());
			pd.setPolicyType(pt.getPolicyType());
			pd.setDuration(pt.getDuration());
			pd.setInterest(pt.getInterest());
			pd.setComp(pt.getCompany().getCompanyId());
			pd.setStartDate(pt.getStartDate());
			pd.setMaturityAmount(pt.getMaturityAmount());
			pd.setIntialDeposit(pt.getIntialDeposit());
			pd.setTermAmount(pt.getTermAmount());
			pd.setTermsPerYear(pt.getTermsPerYear());
			pd.setType1(pt.getType().getTypeid());
			return new ResponseEntity<PolicyforEdit>(pd,HttpStatus.OK);//	
		}
		
		else {
			MessageObject mess=new MessageObject();
			mess.setMessage("Wrong policy Id");
			return new ResponseEntity<MessageObject>(mess,HttpStatus.OK);
		}
			
	}
	
	
	
	public PolicyReturnObject findById1(String policy)
	{
		
		PolicyTable pt= null;
		pt=dao2.findByPolicyId(policy);	
		p=new PolicyReturnObject();
				
		//System.out.println(pt.getCompany().getCompanyName());
		p.setCompanyName(pt.getCompany().getCompanyName());
		//System.out.println(pt.getPolicyName());
		p.setPolicyName(pt.getPolicyName());
		//System.out.println(pt.getTermAmount());
		p.setTermAmount(pt.getTermAmount());
		return p;
		
	}
	@Override
	public int findNumber(String userid, String var) {

		
		return dao2.findNumber(userid,var);
	}
	@Override
	public List<UserEnrolledPolicy> findByUserId(String userid) {

		return dao3.findByUserId(userid);
	}
            
	@Override
	public List<Map<String,String>> selectCompany(){
		return dao4.selectCustomer() ;
		
	}
	


@Override
	public List<PolicyTable> sortRecentService() {
		
		return dao2.findTop4ByOrderByStartDateDesc();
	}
	
	
	
	
	
}


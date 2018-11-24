package com.pms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.Entities.PolicyTable;

@Repository
public interface PolicyDataRepo  extends JpaRepository<PolicyTable, String>  {

  
    public List<PolicyTable> findByPolicyTypeOrderByPolicyIdDesc(@Param ("policy") String userid);
    
    @Query("select count(uep.policy.policyId) from UserEnrolledPolicy uep where uep.user.userid= :userid and uep.policy.policyId like %:var% ")
    public int findNumber(@Param ("userid") String userid, @Param("var") String var);
    //started from here 
    @Query("select pt from PolicyTable pt where pt.policyType =policyType and pt.policyName=policyName order by pt.policyId")
	 public List<PolicyTable> findByPolicyTypeandName(@Param ("policyType") String policyType,@Param ("policyName") String policyName);

    @Query("select p from  PolicyTable p where p.company.companyId= :companyName and p.policyName= :policyName and ( p.duration= :years or  p.policyType = :policyType) ")
    public List<PolicyTable> searchPolicy(@Param ("companyName") String companyName,@Param ("years") int years,@Param ("policyType") String policyType, @Param ("policyName") String policyName);

	public PolicyTable findByPolicyId(String policyId);
	
	@Query(value="select * from policy_table p where p.policy_id=:policy",nativeQuery=true)
	PolicyTable findPolicyTerm(String policy);
	@Query(value="select p.policy_name from Policy_Table p where p.policy_id=:policy",nativeQuery=true)
	String getpolicyname(String policy);
	@Query(value="select p.term_amount from policy_table p where p.policy_id=:policyid",nativeQuery=true)
	public int findPolicyTermAmount(String policyid);
	@Query(value="select p.terms_per_year from policy_table p where p.policy_id=:policyid",nativeQuery=true)
	public int findPolicyYears(String policyid);
    //sort recent
	//@Query("select pt from PolicyTable pt order by pt.startDate DESC limit 4")
    public List<PolicyTable> findTop4ByOrderByStartDateDesc();
    
}
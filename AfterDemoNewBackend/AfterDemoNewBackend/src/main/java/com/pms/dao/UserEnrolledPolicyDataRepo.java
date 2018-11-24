package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.Entities.UserEnrolledPolicy;
@Repository
public interface UserEnrolledPolicyDataRepo  extends JpaRepository<UserEnrolledPolicy, Integer> {
	@Query("select uep from UserEnrolledPolicy uep where uep.user.userid= :userid")
    public List<UserEnrolledPolicy> findByUserId(@Param ("userid") String userid);
	
	@Query(value="select uep.id from user_enrolled_policy uep order by uep.id desc limit 1",nativeQuery=true)
    public Integer findLatestUserId(@Param ("userid") String userid);
	@Query(value ="select count(*) from user_enrolled_policy  uep where uep.user_user_id =:user and uep.policy_policy_id like %:policy%",nativeQuery=true)
	public int countPolicies(String user, String policy);

	@Query(value="select uep.policy_policy_id from user_enrolled_policy  uep where uep.user_user_id=:user",nativeQuery=true)
	public ArrayList<String> getNoOfPoliciesEnrolled(String user);
}

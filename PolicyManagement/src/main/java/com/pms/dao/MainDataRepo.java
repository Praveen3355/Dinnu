package com.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.Entities.Mainuser;

@Repository
public interface MainDataRepo  extends JpaRepository<Mainuser, String>  {

  
    //public List<Mainuser> findByIdEquals(String a);
    
    @Query("select mu from Mainuser mu where mu.userid like :userid ")
    public Mainuser findByName(@Param ("userid") String userid);
    
    @Query("select mu from Mainuser mu where mu.panNo = ?1 and mu.emailId= ?2")
    public Mainuser findByPanNoAndEmaiId(String pan,String email);
    
    @Query("select mu from Mainuser mu where mu.userId like :id% order by mu.userId DESC limit 1")
    public Mainuser findByUserId(@Param ("id") String a );
    
	

}

/*

package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cts.entities.User;


@Repository("dao")
@Component
public interface Dao extends JpaRepository<User, String>{
	
	@Query("select mu.first_name from mainuser mu where mu.user_id= userid and mu.pass=password")
	String findByName(String userid,String password);

}
*/
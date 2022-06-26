package com.swamy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swamy.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.emailId=?1")
	User findByEmailId(String from);

}

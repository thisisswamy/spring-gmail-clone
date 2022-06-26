package com.swamy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swamy.entity.Sent;

public interface SentRepo extends JpaRepository<Sent,Long> {
	
	@Query("select u from Sent u where u.id=?1")
	Sent findById(long id);
}

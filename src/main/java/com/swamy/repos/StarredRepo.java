package com.swamy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swamy.entity.Starred;

public interface StarredRepo extends JpaRepository<Starred, Long> {
	@Query("select u from Starred u where u.id=?1")
	Starred findById(long id);
	
	@Query("select u from Starred u where u.uniqueMailId=?1")
	Starred findByUniqueId(String uniqueId);

}

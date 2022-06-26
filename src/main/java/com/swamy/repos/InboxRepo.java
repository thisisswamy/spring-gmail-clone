package com.swamy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swamy.entity.Inbox;

public interface InboxRepo extends JpaRepository<Inbox, Long> {
	
	@Query("select u from Inbox u where u.id=?1")
	Inbox findById(long id);

}

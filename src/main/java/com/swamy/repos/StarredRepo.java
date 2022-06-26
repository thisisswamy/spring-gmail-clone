package com.swamy.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swamy.entity.Starred;

public interface StarredRepo extends JpaRepository<Starred, Long> {

}

package com.ozod.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozod.policy.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	boolean existsByAdharNo(String adharNo);
	
	boolean existsByPanNo(String panNo);

}

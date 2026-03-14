package com.ozod.policy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozod.policy.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	boolean existsByAdharNo(String adharNo);
	
	boolean existsByPanNo(String panNo);
	
	boolean existsByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

}

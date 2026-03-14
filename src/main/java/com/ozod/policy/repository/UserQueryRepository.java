package com.ozod.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozod.policy.entity.UserQuery;

public interface UserQueryRepository extends JpaRepository<UserQuery, String>{

}

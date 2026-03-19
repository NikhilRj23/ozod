package com.ozod.policy.service;

import java.util.List;

import com.ozod.policy.dto.UserQueryDto;

public interface UserQueryService{
	
	UserQueryDto addUserQuery(UserQueryDto dto);

	UserQueryDto findUserQuery(String id);

	List<UserQueryDto> findAllUserQuery(Integer page, Integer size);

}

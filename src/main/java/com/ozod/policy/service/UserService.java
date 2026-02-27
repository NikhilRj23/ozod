package com.ozod.policy.service;

import java.util.List;

import com.ozod.policy.dto.UserDto;

public interface UserService{
	
	UserDto addUser(UserDto dto);

	UserDto findUser(String id);

	List<UserDto> findAllUser();

}

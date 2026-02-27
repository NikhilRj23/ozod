package com.ozod.policy.service;

import java.util.List;

import com.ozod.policy.dto.AdminDto;

public interface AdminService{
	
	AdminDto addAdmin(AdminDto dto);

	AdminDto findAdmin(String id);

	List<AdminDto> findAllAdmin();

}

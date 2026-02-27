package com.ozod.policy.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozod.policy.dto.AdminDto;
import com.ozod.policy.entity.Admin;
import com.ozod.policy.exception.UserNotFoundException;
import com.ozod.policy.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminDto addAdmin(AdminDto dto) {

		if (adminRepository.existsByAdharNo(dto.getAdharNo())) {
			throw new IllegalArgumentException("Aadhar number::" + dto.getAdharNo() + " already exists");
		}
		if (dto.getPanNo() != null && adminRepository.existsByPanNo(dto.getPanNo())) {
			throw new IllegalArgumentException("Pan number::" + dto.getPanNo() + " already exists");
		}
		Admin adminDto = modelMapper.map(dto, Admin.class);
		Admin save = adminRepository.save(adminDto);
		return modelMapper.map(save, AdminDto.class);
	}

	@Override
	public AdminDto findAdmin(String id) {
		Admin adminDto = adminRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Admin not available with id::" + id));
		return modelMapper.map(adminDto, AdminDto.class);
	}

	@Override
	public List<AdminDto> findAllAdmin() {
		return adminRepository.findAll().stream().map(ed -> modelMapper.map(ed, AdminDto.class)).toList();
	}

}

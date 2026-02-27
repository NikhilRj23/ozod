package com.ozod.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozod.policy.dto.AdminDto;
import com.ozod.policy.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/add")
	public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto dto) {
		AdminDto adminDto = service.addAdmin(dto);
		return new ResponseEntity<>(adminDto, HttpStatus.CREATED);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<AdminDto> findAdmin(@PathVariable String id) {
		AdminDto adminDto = service.findAdmin(id);
		return new ResponseEntity<>(adminDto, HttpStatus.OK);
	}

	@GetMapping("/find/all")
	public ResponseEntity<List<AdminDto>> findAllAdmin() {
		List<AdminDto> adminDto = service.findAllAdmin();
		return new ResponseEntity<>(adminDto, HttpStatus.OK);
	}

}

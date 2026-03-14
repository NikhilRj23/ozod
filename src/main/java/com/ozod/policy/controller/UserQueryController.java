package com.ozod.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozod.policy.dto.UserQueryDto;
import com.ozod.policy.service.UserQueryService;

@RestController
@RequestMapping("/user/query")
@CrossOrigin(origins = "http://localhost:3000")
public class UserQueryController {

	@Autowired
	private UserQueryService service;

	@PostMapping("/add")
	public ResponseEntity<UserQueryDto> saveUserQuery(@RequestBody UserQueryDto dto) {
		UserQueryDto userQueryDto = service.addUserQuery(dto);
		return new ResponseEntity<>(userQueryDto, HttpStatus.CREATED);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<UserQueryDto> findUserQuery(@PathVariable String id) {
		UserQueryDto userQueryDto = service.findUserQuery(id);
		return new ResponseEntity<>(userQueryDto, HttpStatus.OK);
	}

	@GetMapping("/find/all")
	public ResponseEntity<List<UserQueryDto>> findAllUserQuery() {
		List<UserQueryDto> userQueryDto = service.findAllUserQuery();
		return new ResponseEntity<>(userQueryDto, HttpStatus.OK);
	}

}

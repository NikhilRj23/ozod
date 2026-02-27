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

import com.ozod.policy.dto.UserDto;
import com.ozod.policy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto) {
		UserDto user = service.addUser(dto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<UserDto> findUser(@PathVariable String id) {
		UserDto user = service.findUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/find/all")
	public ResponseEntity<List<UserDto>> findAllUser() {
		List<UserDto> users = service.findAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}

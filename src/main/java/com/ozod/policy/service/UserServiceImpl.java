package com.ozod.policy.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozod.policy.dto.UserDto;
import com.ozod.policy.entity.User;
import com.ozod.policy.exception.UserNotFoundException;
import com.ozod.policy.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto dto) {

		if (userRepository.existsByAdharNo(dto.getAdharNo())) {
			throw new IllegalArgumentException("Aadhar number::" + dto.getAdharNo() + " already exists");
		}
		if (dto.getPanNo() != null && userRepository.existsByPanNo(dto.getPanNo())) {
			throw new IllegalArgumentException("Pan number::" + dto.getPanNo() + " already exists");
		}
		if (dto.getEmail() != null && userRepository.existsByEmail(dto.getEmail())) {
			throw new IllegalArgumentException("Email::" + dto.getEmail() + " already exists");
		}
		User user = modelMapper.map(dto, User.class);
		User save = userRepository.save(user);
		save.setCreatedBy(save.getId());
		save.setUpdatedBy(save.getId());
		userRepository.save(user);
		return modelMapper.map(save, UserDto.class);
	}

	@Override
	public UserDto findUser(String id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not available with id::" + id));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> findAllUser() {
		return userRepository.findAll().stream().map(ed -> modelMapper.map(ed, UserDto.class)).toList();
	}

	@Override
	public UserDto findByEmailPassword(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email,password)
				.orElseThrow(() -> new UserNotFoundException("User not available"));
		return modelMapper.map(user, UserDto.class);
	}

}

package com.ozod.policy.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ozod.policy.constants.ResolveStatus;
import com.ozod.policy.constants.Status;
import com.ozod.policy.constants.UserType;
import com.ozod.policy.constants.ViewStatus;
import com.ozod.policy.dto.UserQueryDto;
import com.ozod.policy.entity.UserQuery;
import com.ozod.policy.exception.UserNotFoundException;
import com.ozod.policy.repository.UserQueryRepository;

@Service
public class UserQueryServiceImpl implements UserQueryService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserQueryRepository userQueryRepository;

	@Override
	public UserQueryDto addUserQuery(UserQueryDto dto) {
		UserQuery userQueryDto = modelMapper.map(dto, UserQuery.class);

		userQueryDto.setResolveStatus(ResolveStatus.UN_RESOLVED.getValue());
		userQueryDto.setViewStatus(ViewStatus.UN_VIEWED.getValue());
		userQueryDto.setStatus(Status.ACTIVE.getValue());
		if(userQueryDto.getUserId()!=null) {
			userQueryDto.setCreatedBy(userQueryDto.getUserId());
			userQueryDto.setUpdatedBy(userQueryDto.getUserId());
			userQueryDto.setUserType(UserType.INTERNAL.getValue());
		}else {
			userQueryDto.setUserType(UserType.EXTERNAL.getValue());
		}
		UserQuery save = userQueryRepository.save(userQueryDto);
		return modelMapper.map(save, UserQueryDto.class);
	}

	@Override
	public UserQueryDto findUserQuery(String id) {
		UserQuery userQueryDto = userQueryRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("UserQuery not available with id::" + id));
		return modelMapper.map(userQueryDto, UserQueryDto.class);
	}

	@Override
	public List<UserQueryDto> findAllUserQuery(Integer page, Integer size) {
		return userQueryRepository.findAll(PageRequest.of(page, size ,Sort.by("createdDate").descending()))
				.stream()
				.map(ed -> modelMapper.map(ed, UserQueryDto.class))
				.toList();
	}

}

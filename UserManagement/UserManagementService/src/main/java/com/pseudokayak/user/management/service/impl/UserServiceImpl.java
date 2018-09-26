package com.pseudokayak.user.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.pseudokayak.internal.user.InternalUser;
import com.pseudokayak.user.management.service.api.UserService;
import com.pseudokayak.user.model.User;
import com.pseudokayak.user.repository.UserRepository;
import com.psuedokayak.user.dtos.UserConverterUtils;

public class UserServiceImpl implements UserService {

	private UserRepository repo;
	
	public UserServiceImpl(@NotNull(message="A user repository is required") UserRepository repos) 
	{
		this.repo = repos;
	}
	
	@Override
	public List<User> loadAllUsers() {
		List<InternalUser> uzers = repo.findAll();
		return uzers.stream()
				.map(UserConverterUtils::convertInternalUserToUser)
				.collect(Collectors.toList());
	}

	@Override
	public User saveUser(User user) {
		if (true)
				throw new UnsupportedOperationException("Unimplemented Functionality, come back later!");
		return null;
	}

	@Override
	public void deleteUser(User user) {
		if (true)
			throw new UnsupportedOperationException("Unimplemented Functionality, come back later!");
	}

}

package com.pseudokayak.user.management.service.api;

import java.util.List;

import com.pseudokayak.user.model.User;

public interface UserService {
	public List<User> loadAllUsers();
	public User saveUser(User user);
	public void deleteUser(User user);
}

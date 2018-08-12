package com.pseudokayak.user.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.pseudokayak.user.management.service.api.UserService;
import com.pseudokayak.user.management.service.impl.UserServiceImpl;
import com.pseudokayak.user.repository.UserRepository;

@Configuration
@Import(DataConfig.class)
public class ServiceConfig {

	@Bean
	public UserService userService(@Autowired UserRepository userRepo) {
		return new UserServiceImpl(userRepo);
	}
	
}

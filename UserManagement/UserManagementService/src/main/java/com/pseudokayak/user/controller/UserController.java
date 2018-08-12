package com.pseudokayak.user.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pseudokayak.user.management.service.api.UserService;
import com.pseudokayak.user.model.User;

@RestController
public class UserController {

	@Inject
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> loadAllUsers(){
		return ResponseEntity.ok(userService.loadAllUsers());
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("Everything is A.OK!");
	}
	
}

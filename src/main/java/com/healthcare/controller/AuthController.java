package com.healthcare.controller;

import com.healthcare.model.User;
import com.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User newUser = userService.registerUser(user);
		return ResponseEntity.ok(newUser);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		if (userService.validateUser(user.getUsername(), user.getPassword())) {
			return ResponseEntity.ok("Login successful!");
		} else {
			return ResponseEntity.status(401).body("Invalid credentials.");
		}
	}
}
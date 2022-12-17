package com.ucsi_sis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucsi_sis.entity.User;
import com.ucsi_sis.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_PLAIN_VALUE},value = "/login")
	public HttpEntity<?> login(@RequestBody User user) {
		
		if(user != null) {
			if(loginService.authenticateUser(user)) {
				return ResponseEntity.ok(user);
			}
		}
		return ResponseEntity.badRequest().body(user);
	}
	@GetMapping("/")
	public User hello() {
		return new User("Hi","123");
	}

}

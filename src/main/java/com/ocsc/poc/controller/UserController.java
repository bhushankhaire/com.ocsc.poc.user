package com.ocsc.poc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocsc.poc.model.LoginDetails;
import com.ocsc.poc.model.UserDetails;
import com.ocsc.poc.service.UserService;
import com.ocsc.poc.ulti.LoginException;

@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = "application/json")
	public UserDetails getUserbyId(@PathVariable("id") Integer userId) {

		return userService.getUserById(userId);
	}

	@GetMapping(path = "/email/{emailId}", produces = "application/json")
	public UserDetails getUserByEmailId(@PathVariable("emailId") String emailId) {

		return userService.getUserByEmailId(emailId);
	}

	@PostMapping(path = "/", produces = "application/json")
	public UserDetails createUser(@Valid @RequestBody UserDetails user) {

		return userService.saveUser(user);

	}

	@PostMapping(path = "/login", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void login(@Valid @RequestBody LoginDetails login) throws LoginException {
		userService.login(login);
	}

	@PostMapping(path = "/oldurl", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public String newUrl() throws LoginException {
		return "this is my old url";
	}
}

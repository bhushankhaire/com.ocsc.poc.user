package com.ocsc.poc.service;

import com.ocsc.poc.model.LoginDetails;
import com.ocsc.poc.model.UserDetails;
import com.ocsc.poc.ulti.LoginException;

public interface UserService {

	public UserDetails saveUser(UserDetails userDetails);

	public UserDetails getUserById(Integer userId);

	public UserDetails getUserByEmailId(String emailId);

	public void login(LoginDetails login) throws LoginException;

}

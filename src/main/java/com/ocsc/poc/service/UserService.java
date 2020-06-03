package com.ocsc.poc.service;

import com.ocsc.poc.model.UserDetails;

public interface UserService {

	public UserDetails saveUser(UserDetails userDetails);

	public UserDetails getUserById(Integer userId);

	public UserDetails getUserByEmailId(String emailId);

}

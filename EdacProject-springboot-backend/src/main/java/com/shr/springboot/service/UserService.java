package com.shr.springboot.service;

import org.springframework.stereotype.Service;

import com.shr.springboot.model.Users;
@Service
public interface UserService {
	Users AuthenticationUser(String email, String password);
	
	public Users createUser(Users user);

}

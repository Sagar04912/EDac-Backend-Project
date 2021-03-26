package com.shr.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.springboot.model.Users;
import com.shr.springboot.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userService;
	
	
	@Override
	public Users createUser(Users user) {
		return userService.save(user);
	}

	@Override
	public Users AuthenticationUser(String email, String password) {
		// TODO Auto-generated method stub
		return userService.findUsersByEmailAndPassword(email, password);
	}

}

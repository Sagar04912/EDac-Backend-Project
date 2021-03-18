package com.shr.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.springboot.model.Users;
import com.shr.springboot.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userLogin;
	//private UserDao userLogin;
	


	@Override
	public Users AuthenticationUser(String email, String password) {
		// TODO Auto-generated method stub
		return userLogin.findUsersByEmailAndPassword(email, password);
	}

	

//	@Override
//	public Users fetchUserByEmailAndPassword(String email, String password) {
//		
//		return userLogin.findUsersByEmailAndPassword(email, password);
//	}

}

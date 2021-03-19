package com.shr.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shr.springboot.model.Users;
@Service
public interface UserService {
	Users AuthenticationUser(String email, String password);
	//Users fetchUserByEmailAndPassword(String email, String password);
	// Users Addtocart(Users user);
	
	 Optional<Users> getAllUserCourses(long id);
}

package com.shr.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.springboot.model.UserCart;
import com.shr.springboot.model.Users;
import com.shr.springboot.repository.UserCartRepository;
import com.shr.springboot.repository.UsersRepository;

@Service
public class UserCartServiceImpl implements UserCartService {
	
	@Autowired
	private UserCartRepository userCartService;
	
	@Autowired
	private UsersRepository userService;
	
	@Override
	public Optional<Users> getUserCartCourses(long id) {
		
		return userService.userCartByUserId(id);
	}

	@Override
	public void deleteFromCart(long userId, long courseId) {
		 userCartService.deleteFromCart(userId, courseId);;
	}

	@Override
	public int getUserIdByEmail(String email) {
		return userService.findUserIdbyEmail(email);
	}

	@Override
	public Optional<UserCart> checkCourseIfExist(long userId, long courseId) {
		return userCartService.checkIfExists(userId, courseId);
	}

	@Override
	public void addToUserCart(long userId, long courseId) {
		
		userCartService.addToCart(userId, courseId);
	}

}

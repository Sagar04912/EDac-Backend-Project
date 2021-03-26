package com.shr.springboot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shr.springboot.model.UserCart;
import com.shr.springboot.model.Users;

@Service
public interface UserCartService {
	public Optional<Users> getUserCartCourses(long id);
	
	public void deleteFromCart(long userId, long courseId);
	
	public int getUserIdByEmail(String email);
	
	public Optional<UserCart> checkCourseIfExist(long userId, long courseId);
	
	public void addToUserCart(long userId, long courseId);
}

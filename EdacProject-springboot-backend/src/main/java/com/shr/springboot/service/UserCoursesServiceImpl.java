package com.shr.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.springboot.model.UserCourse;
import com.shr.springboot.model.Users;
import com.shr.springboot.repository.UserCoursesRepository;
import com.shr.springboot.repository.UsersRepository;
@Service
public class UserCoursesServiceImpl implements UserCoursesService {
	
	@Autowired
	private UserCoursesRepository userCourseService;
	
	@Autowired
	private UsersRepository userService;
	
	@Override
	public Optional<Users> getAllUserCourses(long id) {
		return userService.fetchUserCoursesByUserId(id);
	}

	@Override
	public void addToUserCourse(long userId, long courseId) {
		userCourseService.addToUserCourses(userId, courseId);
	}

	@Override
	public Optional<UserCourse> checkCourseIfExist(long userId, long courseId) {
		return userCourseService.checkIfExists(userId, courseId);
	}
	
	
}

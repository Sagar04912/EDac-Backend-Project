package com.shr.springboot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shr.springboot.model.UserCourse;
import com.shr.springboot.model.Users;
@Service
public interface UserCoursesService {
	
	public Optional<Users> getAllUserCourses(long id);
	
	public void addToUserCourse(long userId, long courseId );
	
	public Optional<UserCourse> checkCourseIfExist(long userId, long courseId );
}

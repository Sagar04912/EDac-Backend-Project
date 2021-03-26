package com.shr.springboot.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shr.springboot.model.UserCourse;
import com.shr.springboot.model.Users;
import com.shr.springboot.service.UserCartService;
import com.shr.springboot.service.UserCoursesService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserCoursesController {
	
	@Autowired	
	private UserCoursesService userCourseService;
	
	@Autowired	
	private UserCartService userCartService;
	

	//Courses : add to User Account
	@PostMapping("/checkout")
	@ResponseBody
	public ResponseEntity<String> addToUsersAccount(@RequestParam("id") long id, @RequestParam("cid") long courseId) {
		
		Optional<UserCourse> userCarts = userCourseService.checkCourseIfExist(id, courseId);	// Show All User_Courses using User ID and Course ID

		if (userCarts.isPresent()) {				// Check if the Course exist in User Courses or not
			return ResponseEntity.badRequest().body("Course already exists");
		} else {
			userCourseService.addToUserCourse(id, courseId);
			userCartService.deleteFromCart(id, courseId);
			return ResponseEntity.ok("User's Course added successfully");
		}
	
	}
	
	//display all user courses
		@PostMapping("/userAllCourses")
		@ResponseBody
		
		public Optional<Users> userCourses(@RequestParam("id") long userId) {
			return userCourseService.getAllUserCourses(userId);
		}
	
}

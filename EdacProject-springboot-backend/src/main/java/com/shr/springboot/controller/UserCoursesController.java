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
import com.shr.springboot.repository.UserCartRepository;
import com.shr.springboot.repository.UserCoursesRepository;
import com.shr.springboot.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserCoursesController {
	
	@Autowired	
	private UserService userLogin;
	
	@Autowired
	private UserCoursesRepository userCourse;
	
	@Autowired
	private UserCartRepository userCart;

	//Courses : add to User Account
	@PostMapping("/checkout")
	@ResponseBody
	public ResponseEntity<String> addToUsersAccount(@RequestParam("id") long id, @RequestParam("cid") long courseId) {
		
		Optional<UserCourse> userCarts = userCourse.checkIfExists(id, courseId);	// Show All User_Courses using User ID and Course ID

		if (userCarts.isPresent()) {				// Check if the Course exist in User Courses or not
			return ResponseEntity.badRequest().body("Course already exists");
		} else {
			userCourse.addToCart(id, courseId);
			userCart.deleteFromCart(id, courseId);
			return ResponseEntity.ok("User's Course added successfully");
		}
	
	}
	
	//display all user courses
		@PostMapping("/userAllCourses")
		@ResponseBody
		@Transactional
		public Optional<Users> userCourses(@RequestParam("id") long userId) {
			return userLogin.getAllUserCourses(userId);
		}
	
}

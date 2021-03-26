package com.shr.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shr.springboot.model.UserCart;
import com.shr.springboot.model.Users;
import com.shr.springboot.service.UserCartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserCartController {

	@Autowired
	private UserCartService userCartService;

	// Courses : add to cart
	@PostMapping("/addtocart")
	@ResponseBody
	public ResponseEntity<String> addToCart(@RequestParam("id") long id, @RequestParam("cid") long courseId) {

		Optional<UserCart> userCourses = userCartService.checkCourseIfExist(id, courseId);	// Show All User_Courses using User ID and Course ID

		if (userCourses.isPresent()) {				// Check if the Course exist in User Courses or not
			return ResponseEntity.badRequest().body("Course already exists");
		} else {
			userCartService.addToUserCart(id, courseId);
			return ResponseEntity.ok("User's Course added successfully");
		}

	}

	// get User Id from Email
	@PostMapping("/getuserid")
	@ResponseBody
	public int getUserId(@RequestParam("email") String email) {
		return userCartService.getUserIdByEmail(email);
	}

	// delete from cart
	@PostMapping("/deletefromcart")
	@ResponseBody
	public ResponseEntity<String> deleteFromCarts(@RequestParam("id") long id, @RequestParam("cid") long courseId) {
		Optional<UserCart> userCourses = userCartService.checkCourseIfExist(id, courseId);	
		if (userCourses.isPresent()) {
			userCartService.deleteFromCart(id, courseId);		
			return ResponseEntity.ok("User's Course deleted successfully");
		} else {
			return ResponseEntity.badRequest().body("Invalid Id's");
		}

	}

	// display all user cart courses
	@PostMapping("/displaycartcourses")
	@ResponseBody
	public Optional<Users> userCartCourses(@RequestParam("id") long userId) {
		return userCartService.getUserCartCourses(userId);
	}
}

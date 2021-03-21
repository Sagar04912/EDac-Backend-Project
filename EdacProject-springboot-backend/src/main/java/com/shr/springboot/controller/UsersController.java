
package com.shr.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shr.springboot.model.UserCourse;
import com.shr.springboot.model.Users;
import com.shr.springboot.repository.UserCourseRepository;
import com.shr.springboot.repository.UsersRepository;
import com.shr.springboot.service.UserService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserService userLogin;
	
	
	@Autowired
	private UserCourseRepository userCourse;

	
	@PostMapping("/registration")
	public Users createUser(@RequestBody Users user) {
		return userRepository.save(user);
	}
	
	//login rest api
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> LoginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("processing " + email + " " + password);
		
		try {  Users user = userLogin.AuthenticationUser(email, password);

			if (user.getRole() == 1)
				return   ResponseEntity.ok("admin");
			if (user.getRole() == 0)
				return   ResponseEntity.ok("user");

		} catch (RuntimeException e) {
			System.out.println("Error in Controller " + e);
			return   ResponseEntity.badRequest().body("wrong email pass");
		}

		return   ResponseEntity.badRequest().body("wrong email pass");
	}
	
	//add to cart
	@PostMapping("/addtocart")
	@ResponseBody
	public ResponseEntity<String> addToCart(@RequestParam("id") long id, @RequestParam("cid") long courseId)
	{
				Optional<UserCourse> userCourses = userCourse.checkIfExists(id, courseId);
			
				if(userCourses.isPresent()) {
					return ResponseEntity.badRequest().body("Course already exists");
				}
				else {
					userCourse.addToCart(id, courseId);
					return ResponseEntity.ok("User's Course added successfully");
				}
	
	}
	
	@GetMapping("/getuserid")
	@ResponseBody
	public int getUserId(@RequestParam("email") String email) {
		return userLogin.getUserIdByEmail(email);
	}
	
	
	//delete from cart
	@PostMapping("/deletefromcart")
	@ResponseBody
	public ResponseEntity<String> deleteFromCarts(@RequestParam("id") long id, @RequestParam("cid") long courseId)
	{
		Optional<UserCourse> userCourses = userCourse.checkIfExists(id, courseId);
		if(userCourses.isPresent())
		{
			userCourse.deleteFromCart(id, courseId);
			return ResponseEntity.ok("User's Course deleted successfully");
		}
		else {
			return ResponseEntity.badRequest().body("Invalid Id's");
		}
		
	}
	
	//display all user courses
	@GetMapping("/userAllCourses")
	@ResponseBody
	public Optional<Users> userCourses(@RequestParam("id") long userId) {
		return userLogin.getAllUserCourses(userId);
	}
	 
	
}

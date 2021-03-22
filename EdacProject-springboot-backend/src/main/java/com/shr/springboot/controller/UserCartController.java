package com.shr.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shr.springboot.dto.ErrorResponse;
import com.shr.springboot.model.UserCart;
import com.shr.springboot.model.Users;
import com.shr.springboot.repository.UserCartRepository;
import com.shr.springboot.repository.UsersRepository;
import com.shr.springboot.service.UserService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserCartController {

	
	@Autowired
	private UserService userLogin;
	
	
	@Autowired
	private UserCartRepository userCart;

	
	
	//add to cart
		@PostMapping("/addtocart")
		@ResponseBody
		public ResponseEntity<String> addToCart(@RequestParam("id") long id, @RequestParam("cid") long courseId)
		{
				
			
					Optional<UserCart> userCourses = userCart.checkIfExists(id, courseId);
				
					if(userCourses.isPresent()) {
						return ResponseEntity.badRequest().body("Course already exists");
					}
					else {
						userCart.addToCart(id, courseId);
						return ResponseEntity.ok("User's Course added successfully");
					}
					
					
		
		}
		
		@PostMapping("/getuserid")
		@ResponseBody
		public int getUserId(@RequestParam("email") String email) {
			return userLogin.getUserIdByEmail(email);
		}
		
		
		//delete from cart
		@PostMapping("/deletefromcart")
		@ResponseBody
		public ResponseEntity<String> deleteFromCarts(@RequestParam("id") long id, @RequestParam("cid") long courseId)
		{
			Optional<UserCart> userCourses = userCart.checkIfExists(id, courseId);
			if(userCourses.isPresent())
			{
				userCart.deleteFromCart(id, courseId);
				return ResponseEntity.ok("User's Course deleted successfully");
			}
			else {
				return ResponseEntity.badRequest().body("Invalid Id's");
			}
			
		}
		
		//display all user cart courses
				@PostMapping("/displaycartcourses")
				@ResponseBody
				public Optional<Users> userCartCourses(@RequestParam("id") long userId) {
					return userLogin.getUserCartCourses(userId);
				}
}

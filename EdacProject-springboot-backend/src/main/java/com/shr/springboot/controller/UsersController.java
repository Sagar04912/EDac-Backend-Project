
package com.shr.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shr.springboot.model.Users;
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
	
	//get all users
	
	/*
	 * @GetMapping("/registration") public List <Users> getAllUsers(){ return
	 * userRepository.findAll(); }
	 */
	
	//create user rest api(registration)
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
	
	
	
	
}

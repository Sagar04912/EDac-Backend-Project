package com.shr.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shr.springboot.custom_exceptions.UsersHandlingException;
import com.shr.springboot.dto.ErrorResponse;
import com.shr.springboot.model.Courses;
import com.shr.springboot.service.CourseService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CourseController {
	
	
	@Autowired
	private CourseService courseService;
	
	//Get All Courses
	@GetMapping("/courses")
	public List<Courses> getCourses() {
	
		return courseService.getCourses();
	}
	
	//Add courses
	@PostMapping("/courses")
	public Courses addNewCourse(@RequestBody Courses course) {
		return courseService.addCourse(course);
	}
	
	// Update Courses
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		return courseService.updateCourse(course);
	}
	
	// Delete Courses
	@DeleteMapping("/courses")
	public ResponseEntity<String> deleteCourse(@RequestBody Long courseId){
		try {
				courseService.deleteCourse(courseId);
			return ResponseEntity.ok("Course deleted Suceesfully..");
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Invalid Course Id...");
		}
	}
	
	
}

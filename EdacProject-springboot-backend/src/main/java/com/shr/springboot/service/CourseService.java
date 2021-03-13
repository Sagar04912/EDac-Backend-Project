package com.shr.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shr.springboot.model.Courses;

@Service
public interface CourseService {
	
	public List<Courses> getCourses();
	
	public Courses addCourse(Courses course);
	
	public Courses updateCourse(Courses course);
	
	public void deleteCourse(Long courseId);
}

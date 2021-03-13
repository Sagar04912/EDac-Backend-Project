package com.shr.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.springboot.model.Courses;
import com.shr.springboot.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	public CourseRepository courseDao;
	
	@Override
	public List<Courses> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(Long courseId) {
		Courses entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}

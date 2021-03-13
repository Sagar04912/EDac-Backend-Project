package com.shr.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shr.springboot.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long>{
	
}

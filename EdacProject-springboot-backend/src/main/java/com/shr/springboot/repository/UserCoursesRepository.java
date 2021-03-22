package com.shr.springboot.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shr.springboot.model.UserCourse;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCourse, Long> {
	
	@Modifying
	@Query(value = "insert into user_course (user_id,course_id) values (:id,:courseId)" , nativeQuery = true)
	@Transactional
	public void addToCart(@Param("id") long id, @Param("courseId") long courseId);
	
	@Query(value = "select * from user_course where user_id=:id and course_id=:courseId " , nativeQuery = true)
	@Transactional
	public Optional<UserCourse> checkIfExists(@Param("id") long id, @Param("courseId") long courseId);
	
}

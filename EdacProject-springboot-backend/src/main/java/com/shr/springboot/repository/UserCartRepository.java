package com.shr.springboot.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shr.springboot.model.UserCart;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Long>{

	@Modifying
	@Query(value = "insert into user_cart (user_id,course_id) values (:id,:courseId)" , nativeQuery = true)
	@Transactional
	public void addToCart(@Param("id") long id, @Param("courseId") long courseId);
	
	
	@Query(value = "select * from user_cart where user_id=:id and course_id=:courseId " , nativeQuery = true)
	@Transactional
	public Optional<UserCart> checkIfExists(@Param("id") long id, @Param("courseId") long courseId);
	
	@Modifying
	@Query(value = "delete from user_cart where user_id=:id and course_id=:courseId", nativeQuery = true)
	@Transactional
	public void deleteFromCart(@Param("id") long id, @Param("courseId") long courseId);
	

}

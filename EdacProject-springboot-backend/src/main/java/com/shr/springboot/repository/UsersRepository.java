package com.shr.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shr.springboot.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{ 
	
	public Users findUsersByEmailAndPassword(String email, String password);

	@Query("select u.id from Users u where u.email= :email")
	public int findUserIdbyEmail(@Param("email") String email);	// getting User Id from user Email ID 
	
	@Query("select u from Users u inner join fetch u.userCart where u.id=:id")
	Optional<Users> userCartByUserId(@Param("id")long id);	//getting the User Cart data in User database;
	
	@Query("select u from Users u inner join fetch u.userCourse where u.id=:id")
	Optional<Users> fetchUserCoursesByUserId(@Param("id")long id); //getting the User Course data in User database;
}

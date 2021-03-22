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

	
	@Query("select u from Users u inner join fetch u.userCourse where u.id=:id")
	Optional<Users> fetchUserCoursesByUserId(@Param("id")long id);
	
	@Query("select u from Users u inner join fetch u.userCart where u.id=:id")
	Optional<Users> UserCartByUserId(@Param("id")long id);
	
	@Query("select u.id from Users u where u.email= :email")
	public int findUserIdbyEmail(@Param("email") String email);
}

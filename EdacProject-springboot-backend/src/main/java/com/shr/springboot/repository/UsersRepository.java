package com.shr.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shr.springboot.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{ 
	
	public Users findUsersByEmailAndPassword(String email, String password);
}

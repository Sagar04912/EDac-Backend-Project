package com.shr.springboot.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shr.springboot.model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public Users authenticateUser(String email, String pwd) {
		String jpql = "select u from Users u where u.email=:em and u.password=:pass";
		return mgr.createQuery(jpql, Users.class).setParameter("em", email).setParameter("pass", pwd).getSingleResult();
		
	}

}

package com.shr.springboot.dao;

import com.shr.springboot.model.Users;

public interface UserDao {
	Users authenticateUser(String email, String pwd);
}

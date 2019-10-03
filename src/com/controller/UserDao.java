package com.controller;

import com.controller.UserDao;

public interface UserDao {
	public boolean AddUser(User user);
	public boolean ValidateUser(User user);
}

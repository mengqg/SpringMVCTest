package com.springmvc04.part1.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc04.part1.dao.UserDAO;
import com.springmvc04.part1.entity.User;

@Service
public class UserService {
	private UserDAO userDAO;
	
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public User login(String name, String pwd) throws Exception {
		try {
			User user = userDAO.findByName(name);
			if(pwd.equals(user.getPwd())) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
}

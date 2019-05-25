package com.springmvc04.part1.service;


import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc04.part1.dao.UserDAO;
import com.springmvc04.part1.entity.User;

@Service
public class UserService implements Serializable{
	private UserDAO userDAO;
	
//	@Resource
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public User login(String name, String pwd) throws Exception {
		try {
			if(name == null || "".equals(name) || pwd == null || "".equals(pwd)) {
				throw new NullParamException("登录参数不能为空.");
			}
			User user = userDAO.findByName(name);
			if(pwd.equals(user.getPwd())) {
				return user;
			}else {
				throw new NameOrPwdException("用户名和密码错误");
			}
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			throw new NameOrPwdException(e);
		} catch (NullParamException e) {
			e.printStackTrace();
			throw new NameOrPwdException(e);
		} catch (Exception e) {
			throw e;
		}
		
		
	}
}

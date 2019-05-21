package com.springmvc04.part1.dao;

import com.springmvc04.part1.entity.User;

/**
 * 用户数据访问对象接口
 * @author meng
 */
public interface UserDAO {
	/**
	 * 根据唯一用户名查询系统用户,如果找不到返回null
	 * @param name
	 * @return
	 */
	public User findByName(String name) throws Exception ;
}

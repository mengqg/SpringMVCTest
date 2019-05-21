package com.springmvc04.part1;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvc04.part1.dao.JDBCDataSource;
import com.springmvc04.part1.entity.User;
import com.springmvc04.part1.service.UserService;

public class TestCase {
	@Test
	public void testUserService() throws Exception {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
			Properties prop = ac.getBean("jdbcProps", Properties.class);
			JDBCDataSource jdbcSource = ac.getBean("jdbcDataSource", JDBCDataSource.class);
			System.out.println(prop);
			System.out.println(jdbcSource);
			System.out.println(jdbcSource.getConnection());
			UserService service = ac.getBean("userService", UserService.class);
			User user = service.login("Tom", "123");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}

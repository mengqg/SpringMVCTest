package com.springmvc.helloWorld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.Controller;

public class TestCase {
	
	@Test
	public void testViewResolver() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		ViewResolver vr = ac.getBean("viewResolver", ViewResolver.class);
		System.out.println(vr);
	}
	
	@Test
	public void testHelloController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		Controller c = ac.getBean("helloController", Controller.class);
		System.out.println(c);
	}
	
	@Test
	public void testHandlerMapping() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		HandlerMapping handlerMapping = ac.getBean("handlerMapping", HandlerMapping.class);
		System.out.println(handlerMapping);
	}
}

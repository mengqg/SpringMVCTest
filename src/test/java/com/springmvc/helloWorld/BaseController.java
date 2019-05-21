package com.springmvc.helloWorld;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	@ExceptionHandler
	public String execute(HttpServletRequest req, Exception ex) {
		req.setAttribute("ex", ex);
		//可根据异常类型不同返回不同视图名
		return "error";
	}
}

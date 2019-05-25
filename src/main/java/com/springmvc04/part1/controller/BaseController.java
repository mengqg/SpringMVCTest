package com.springmvc04.part1.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController implements Serializable{
	
	@ExceptionHandler
	public String execut(HttpServletRequest req, Exception ex) {
		req.setAttribute("ex", ex);
		req.setAttribute("message", ex.getMessage());
		return "error";
	}
}

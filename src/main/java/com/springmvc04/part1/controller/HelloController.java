package com.springmvc04.part1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring")
public class HelloController {
	@RequestMapping("/hello.form")
	public String execute() {
		System.out.println("执行hello.form");
		return "hello";
	}
}

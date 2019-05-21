package com.springmvc03.part2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day01")
public class HelloController {
	@RequestMapping("/hello.form")
	public String execute() {
		return "hello";
	}
}

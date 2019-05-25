package com.springmvc04.part1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc04.part1.entity.User;
import com.springmvc04.part1.service.NameOrPwdException;
import com.springmvc04.part1.service.NullParamException;
import com.springmvc04.part1.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Resource
	private UserService userService = null;
	
	@RequestMapping("/login-form.form")
	public String loginForm() {
		
		return "login-form";//映射到login-form.jsp
	}
	
	@RequestMapping("/login-action1.form")
	public String checkLogin1(HttpServletRequest req) throws Exception {
		System.out.println("---方法一---");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);
		String s = null;
		try {
			s.length();
			User user = userService.login(name, pwd);
			req.setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch(NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "redirect:login-form";
		} catch(RuntimeException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action2.form")
	public String checkLogin2(String name, /*@RequestParam("pwd")*/ String pwd, 
			HttpServletRequest req) throws Exception{
		try {
			System.out.println("---方法二---");
			System.out.println(name);
			System.out.println(pwd);
			User user = userService.login(name, pwd);
			System.out.println(user);
			req.getSession().setAttribute("user", user);
			return "success";
		} catch(NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch(NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch(RuntimeException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action3.form")
	public String checkLogin3(User user, HttpServletRequest req) throws Exception {
		try {
			System.out.println(user);
			user = userService.login(user.getName(), user.getPwd());
			req.getSession().setAttribute("user", user);
			return "success";
		} catch(NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch(NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch(RuntimeException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action4.form")
	public ModelAndView checkLogin4(String name, String pwd, HttpServletRequest req) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			User user = userService.login(name, pwd);
			req.getSession().setAttribute("user", user);
			return new ModelAndView("success", data);
		} catch(NameOrPwdException e) {
			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login-form", data);
		} catch(NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			data.put("message", e.getMessage());
			return new ModelAndView("login-form", data);
		} catch(RuntimeException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			data.put("message", e.getMessage());
			return new ModelAndView("error", data);
		}
	}
}

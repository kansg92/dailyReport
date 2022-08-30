package com.kanne.dailyreport.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kanne.dailyreport.service.UserService;
import com.kanne.dailyreport.vo.UserVO;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String main(Model model,HttpSession session) {
		
		model.addAttribute("left","left");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model,UserVO users) {
		try {
			userService.register(users);
		} catch (Exception e) {
			e.printStackTrace();
			return "401";
		}
		
		return "login";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model model,String id, String pwd,HttpSession session) {
		UserVO users = null;
		
		try {
			users = userService.get(id);
			if(users.getPwd().equals(pwd)) {
				session.setAttribute("loginuser", users);
				model.addAttribute("loginuser", users);
			}
		} catch (Exception e) {
			return "login";
		}
		return "redirect:/";
	}
	
}

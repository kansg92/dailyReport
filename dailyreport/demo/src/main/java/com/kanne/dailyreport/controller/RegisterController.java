package com.kanne.dailyreport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanne.dailyreport.service.UserService;

@RestController
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/idCheck")
	public boolean idCheck(String id) {
		
		try {
			if(userService.get(id) == null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}

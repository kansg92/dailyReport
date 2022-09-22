package com.kanne.dailyreport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanne.dailyreport.service.HabitCardService;
import com.kanne.dailyreport.service.HabitService;
import com.kanne.dailyreport.vo.HabitCardVO;
import com.kanne.dailyreport.vo.HabitVO;

@RestController
public class HabitController {

	@Autowired
	HabitCardService habitcardService;
	@Autowired
	HabitService habitService;
	
	@RequestMapping("addHabitCard")
	public Object addHabitCard(HabitCardVO habitcard,HabitVO habit) {
		System.out.println(habitcard);
		System.out.println(habit);
		try {
			habitService.register(habit);
			habitcardService.register(habitcard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return habitcard;
		
	}
	
}

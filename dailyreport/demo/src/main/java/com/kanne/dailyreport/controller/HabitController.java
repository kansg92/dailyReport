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
		try {
			habitService.register(habit);
			habitcardService.register(habitcard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return habitcard;
		
	}
	
	@RequestMapping("deleteHabitCard")
	public void deleteHabitCard(Integer id) {
		try {
			habitcardService.trueRemove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("updateStatus")
	public void updateStatus(int id, int statusCode) {
		try {
			habitcardService.updateStatus(id, statusCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("modifyHabit")
	public void modifyHabit(HabitCardVO habit) {
		System.out.println(habit);
		try {
			habitcardService.modify(habit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

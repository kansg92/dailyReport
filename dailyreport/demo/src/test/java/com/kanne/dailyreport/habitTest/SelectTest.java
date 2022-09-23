package com.kanne.dailyreport.habitTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.HabitCardService;
import com.kanne.dailyreport.service.HabitService;
import com.kanne.dailyreport.vo.HabitCardVO;

@SpringBootTest
class SelectTest {

	@Autowired
	HabitService service;
	@Autowired
	HabitCardService cardService;
	
	@Test
	void contextLoads() {
		List<HabitCardVO> list = null;
		try {
			list = cardService.getHabitList2("2022-09-22");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (HabitCardVO obj : list) {
			System.out.println(obj);
			try {
				cardService.register(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}

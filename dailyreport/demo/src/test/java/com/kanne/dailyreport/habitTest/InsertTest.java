package com.kanne.dailyreport.habitTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.HabitService;
import com.kanne.dailyreport.vo.HabitVO;

@SpringBootTest
class InsertTest {

	@Autowired
	HabitService service;
	
	@Test
	void contextLoads() {
		HabitVO obj = new HabitVO(null, null, null, "kansg");
				
		
		try {
			service.register(obj);
			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

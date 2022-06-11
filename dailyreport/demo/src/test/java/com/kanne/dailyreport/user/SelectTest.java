package com.kanne.dailyreport.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.UserService;

@SpringBootTest
class SelectTest {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {

		
		try {
			System.out.println(service.get("id01")); 
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}

package com.kanne.dailyreport.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.UserService;
import com.kanne.dailyreport.vo.UserVO;

@SpringBootTest
class DeleteTest {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		UserVO obj = new UserVO("id02");
		
		try {
			service.remove(obj);
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.kanne.dailyreport.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.UserService;
import com.kanne.dailyreport.vo.UserVO;

@SpringBootTest
class InsertTest {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		UserVO obj = new UserVO("id03","kan","pwd02","kansg@naver.com");
		
		try {
			service.register(obj);
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.kanne.dailyreport.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.UserService;
import com.kanne.dailyreport.vo.UserVO;

@SpringBootTest
class SelectAllTest {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		List<UserVO> list = null;
		
		try {
			list = service.get();
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (UserVO obj : list) {
			System.out.println(obj);
		}
	}

}

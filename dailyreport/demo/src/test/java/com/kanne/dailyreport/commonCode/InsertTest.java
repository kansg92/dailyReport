package com.kanne.dailyreport.commonCode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.CommonCodeService;
import com.kanne.dailyreport.vo.CommonCodeVO;

@SpringBootTest
class InsertTest {

	@Autowired
	CommonCodeService service;
	
	@Test
	void contextLoads() {
		CommonCodeVO obj = new CommonCodeVO(1050,1000,"하");
		
		try {
			service.register(obj);
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

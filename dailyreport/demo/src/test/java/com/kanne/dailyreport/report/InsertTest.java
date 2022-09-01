package com.kanne.dailyreport.report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.ReportService;
import com.kanne.dailyreport.vo.ReportVO;

@SpringBootTest
class InsertTest {

	@Autowired
	ReportService service;
	
	@Test
	void contextLoads() { 
		
		ReportVO obj = new ReportVO(null,"2022-09-01",null,null,null,"feedback","test");
		
		try {
			service.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

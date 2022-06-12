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
		ReportVO obj = new ReportVO("00:00", "06:00", "sleep", 2020, 1010, "feedback", "ID01");
		
		try {
			service.register(obj);
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.kanne.dailyreport.reportDetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.ReportDetailService;
import com.kanne.dailyreport.vo.ReportDetailVO;

@SpringBootTest
class SelectAllTest {

	@Autowired
	ReportDetailService service;
	
	@Test
	void contextLoads() {
		List<ReportDetailVO> list = null;
		
		try {
			list = service.get();
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ReportDetailVO obj : list) {
			System.out.println(obj);
		}
	}

}

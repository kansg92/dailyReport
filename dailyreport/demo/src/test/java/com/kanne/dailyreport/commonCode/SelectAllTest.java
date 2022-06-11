package com.kanne.dailyreport.commonCode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kanne.dailyreport.service.CommonCodeService;
import com.kanne.dailyreport.vo.CommonCodeVO;

@SpringBootTest
class SelectAllTest {

	@Autowired
	CommonCodeService service;
	
	@Test
	void contextLoads() {
		List<CommonCodeVO> list = null;
		
		try {
			list = service.get();
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CommonCodeVO commonCodeVO : list) {
			System.out.println(commonCodeVO);
		}
	}

}

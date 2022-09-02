package com.kanne.dailyreport.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanne.dailyreport.service.CommonCodeService;
import com.kanne.dailyreport.service.ReportDetailService;
import com.kanne.dailyreport.service.ReportService;
import com.kanne.dailyreport.vo.CommonCodeVO;
import com.kanne.dailyreport.vo.ReportDetailVO;
import com.kanne.dailyreport.vo.ReportVO;

@RestController
public class AjaxController {

	@Autowired
	CommonCodeService commonCode;
	@Autowired
	ReportDetailService reportDetailService;
	@Autowired
	ReportService reportService;
	
	@RequestMapping("/getCode")
	public List<CommonCodeVO> getCode(){
		List<CommonCodeVO> category = null;
		try {
			category = commonCode.selectCommonCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return category;
	}
	
	@RequestMapping("/getimmersion")
	public List<CommonCodeVO> getimmersion(){
		List<CommonCodeVO> immersion = null;
		try {
			immersion = commonCode.getImmersion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return immersion;
	}
	@RequestMapping("/dailyReportsubmit")
	public String dailyReportsubmit(String jsonString, ReportVO report,String check) {
		JSONParser parser = new JSONParser();
		System.out.println(jsonString);
		System.out.println(report);
		try {
			JSONArray jsonarr = (JSONArray) parser.parse(jsonString);
			HashMap<String, String> map = new HashMap<String, String>();
			String key = "";
			String value = "";
			List<ReportVO> checkDate = reportService.checkDate(report.getUid());
			// day 중복체크...
			if(check.equals("save")) {
				for (ReportVO obj : checkDate) {
					if(obj.getDay() == report.getDay()) {
						return "dayoverwrite";
					}
				}
			}
			
			//리포트 인서트....
			reportService.register(report);
			
			// 리포트 상세 인서트...
			for(int i = 1; i < jsonarr.size()+1; i++) {
				JSONObject jsonObj = (JSONObject) jsonarr.get(i-1);
				key = jsonObj.get("name").toString();
				value = jsonObj.get("value").toString();
				System.out.println("i ::"+i+", key::"+key+", value::"+value);
				map.put(jsonObj.get("name").toString(), jsonObj.get("value").toString());
				
				if(i % 6 == 0) {
					map.put("report_id", Integer.toString(report.getId()));
					System.out.println("map::"+map);
					reportDetailService.insertMap(map);
				}
				
			 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		return "success";
	}
	
}

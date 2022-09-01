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
	public String dailyReportsubmit(String jsonString, ReportVO report) {
		JSONParser parser = new JSONParser();
		try {
			System.out.println(report);
			System.out.println("day::"+reportService.checkDate(report.getDay()));
			if(reportService.checkDate(report.getDay()) != null) {
				return "dayoverwrite";
			}
			JSONArray jsonarr = (JSONArray) parser.parse(jsonString);
			HashMap<String, String> map = new HashMap<String, String>();
			String key = "";
			String value = "";
			reportService.register(report);
			for(int i = 0; i < jsonarr.size(); i++) {
				JSONObject jsonObj = (JSONObject) jsonarr.get(i);
				key = jsonObj.get("name").toString();
				value = jsonObj.get("value").toString();
				map.put(jsonObj.get("name").toString(), jsonObj.get("value").toString());
				if(i % 4 == 0 && i != 0) {
					map.put("report_id", Integer.toString(report.getId()));
					System.out.println("map::"+map);
					reportDetailService.inserMap(map);
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
}

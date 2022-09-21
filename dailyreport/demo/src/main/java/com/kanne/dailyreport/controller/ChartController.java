package com.kanne.dailyreport.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kanne.dailyreport.service.ReportDetailService;
import com.kanne.dailyreport.vo.ReportDetailVO;

@Controller
public class ChartController {

	@Autowired
	ReportDetailService detailSerivice;
	
	@RequestMapping("/chart/dailychart")
	public String dailychart(Model model) {
		String day = "2022-09-03";
		String uid = "test";
		int qscore = 0;
		HashMap<String, String> map = new HashMap<String, String>();
		List<ReportDetailVO> SpecifiedTable = null;
		map.put("day", day);
		map.put("uid", uid);
		try {
			SpecifiedTable = detailSerivice.getSpecifiedTable(map);
			qscore = detailSerivice.getqscore(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("qscore", qscore);
		model.addAttribute("SpecifiedTable", SpecifiedTable);
		model.addAttribute("left","/left");
		model.addAttribute("center","/chart/dailychart");
		return "index";
	}
	
}

package com.kanne.dailyreport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kanne.dailyreport.service.ReportDetailService;

@Controller
public class ChartController {

	@Autowired
	ReportDetailService detailSerivice;
	
	@RequestMapping("/chart/dailychart")
	public String dailychart(Model model) {
		model.addAttribute("left","/left");
		model.addAttribute("center","/chart/dailychart");
		return "index";
	}
	
}

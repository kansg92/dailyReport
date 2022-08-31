package com.kanne.dailyreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {
	
	@RequestMapping("/dailyreport/reportwrite")
	public String reportWrite(Model model) {
		
		model.addAttribute("left","/left");
		model.addAttribute("center","/dailyreport/reportwrite");
		return "/index";
	}
}

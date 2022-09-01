package com.kanne.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kanne.dailyreport.service.CommonCodeService;
import com.kanne.dailyreport.vo.CommonCodeVO;

@Controller
public class ReportController {
	
	@Autowired
	CommonCodeService commonCode;
	
	@RequestMapping("/dailyreport/reportwrite")
	public String reportWrite(Model model) {
		
		List<CommonCodeVO> cateList = null;
		List<CommonCodeVO> immersion = null;
		try {
			cateList = commonCode.selectCommonCode();
			immersion = commonCode.getImmersion();
			model.addAttribute("category",cateList);
			model.addAttribute("immersion",immersion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("left","/left");
		model.addAttribute("center","/dailyreport/reportwrite");
		return "/index";
	}
	
	
}

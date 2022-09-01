package com.kanne.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kanne.dailyreport.service.CommonCodeService;
import com.kanne.dailyreport.service.ReportDetailService;
import com.kanne.dailyreport.service.ReportService;
import com.kanne.dailyreport.vo.CommonCodeVO;
import com.kanne.dailyreport.vo.ReportDetailVO;
import com.kanne.dailyreport.vo.ReportVO;
import com.kanne.dailyreport.vo.UserVO;

@Controller
public class ReportController {
	
	@Autowired
	CommonCodeService commonCode;
	@Autowired
	ReportService reportService;
	@Autowired
	ReportDetailService reportDetailService;
	
	@RequestMapping("/dailyreport/reportwrite")
	public String reportWrite(Model model,HttpSession session) {
		if(session.getAttribute("loginuser") == null) {
			return "401.html";
		}
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
	
	@RequestMapping("/dailyreport/dailyView")
	public String dailyView(Model model,HttpSession session) {
		if(session.getAttribute("loginuser") == null) {
			return "401.html";
		}
		UserVO user = (UserVO) session.getAttribute("loginuser");
		List<ReportVO> reportList = null;
		try {
			reportList = reportService.getReportList(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("report",reportList);
		model.addAttribute("left","/left");
		model.addAttribute("center","/dailyreport/dailyView");
		return "/index";
	}
	@RequestMapping("/dailyreport/reportDetail")
	public String reportDetail(Model model,int report_id) {
		List<ReportDetailVO> detailList = null;
		ReportVO report = null;
		try {
			detailList = reportDetailService.getDetail(report_id);
			report = reportService.get(report_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("selectedReport",report);
		model.addAttribute("report",detailList);
		model.addAttribute("left","/left");
		model.addAttribute("center","/dailyreport/detail");
		return "/index";
	}
	
	@RequestMapping("/dailyreport/reportModify")
	public String reportModify(Model model,HttpSession session,int report_id,String day) {
//		if(session.getAttribute("loginuser") == null) {
//			return "401.html";
//		}
		List<CommonCodeVO> cateList = null;
		List<CommonCodeVO> immersion = null;
		List<ReportDetailVO> detailList = null;
		ReportVO report = null;
		try {
			cateList = commonCode.selectCommonCode();
			immersion = commonCode.getImmersion();
			detailList = reportDetailService.getDetail(report_id);
			report = reportService.get(report_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("selectedReport",report);
		model.addAttribute("detailList",detailList);		
		model.addAttribute("category",cateList);
		model.addAttribute("immersion",immersion);		
		model.addAttribute("left","/left");
		model.addAttribute("center","/dailyreport/reportModify");
		return "/index";
	}
	
	
}

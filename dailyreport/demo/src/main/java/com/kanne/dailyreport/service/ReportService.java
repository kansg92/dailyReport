package com.kanne.dailyreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kanne.dailyreport.dao.ReportDao;
import com.kanne.dailyreport.frame.Service;
import com.kanne.dailyreport.vo.ReportVO;

@org.springframework.stereotype.Service
public class ReportService implements Service<ReportVO, Integer> {

	@Autowired
	ReportDao dao;
	
	@Override
	public void register(ReportVO v) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(v);
	}

	@Override
	public void trueRemove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(k);
	}

	@Override
	public void modify(ReportVO v) throws Exception {
		// TODO Auto-generated method stub
		dao.update(v);
	}

	@Override
	public ReportVO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	@Override
	public List<ReportVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void remove(ReportVO v) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(v);
	}
	
	public ReportVO checkDate(String day) throws Exception{
		return dao.checkDate(day);
	}
	
	public List<ReportVO> getReportList(String id) throws Exception{
		return dao.getReportList(id);
	}
}

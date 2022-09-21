package com.kanne.dailyreport.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kanne.dailyreport.dao.ReportDetailDao;
import com.kanne.dailyreport.frame.Service;
import com.kanne.dailyreport.vo.ReportDetailVO;

@org.springframework.stereotype.Service
public class ReportDetailService implements Service<ReportDetailVO, Integer> {
	
	@Autowired
	ReportDetailDao dao;
	
	@Override
	public void register(ReportDetailVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(ReportDetailVO v) throws Exception {
		dao.delete(v);
	}

	@Override
	public void trueRemove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ReportDetailVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ReportDetailVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReportDetailVO> get() throws Exception {
		return dao.selectAll();
	}
	
	public void insertMap(HashMap<String, String> map) throws Exception{
		dao.insertMap(map);
	}
	
	public List<ReportDetailVO> getDetail(int report_id) throws Exception {
		return dao.getDetail(report_id);
	}
	
	public List<ReportDetailVO> getSpecifiedTable(HashMap<String, String> map) throws Exception {
		
		return dao.getSpecifiedTable(map);
	}
	
	public int getqscore(HashMap<String, String> map) throws Exception {
		
		return dao.getqscore(map);
	}
}

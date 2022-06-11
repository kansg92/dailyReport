package com.kanne.dailyreport.dao;

import java.util.List;

import com.kanne.dailyreport.vo.ReportVO;

public interface ReportDao {
	public void insert(ReportVO report) throws Exception;
	public void update(ReportVO report) throws Exception;
	public void delete(int id) throws Exception;
	
	public ReportVO select(int id) throws Exception;
	public List<ReportVO> selectAll() throws Exception;
}

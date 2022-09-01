package com.kanne.dailyreport.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kanne.dailyreport.vo.ReportDetailVO;

@Mapper
@Repository
public interface ReportDetailDao {
	public void insert(ReportDetailVO report) throws Exception;
	public void update(ReportDetailVO report) throws Exception;
	public void delete(int id) throws Exception;
	public void delete(ReportDetailVO report) throws Exception;
	public ReportDetailVO select(int id) throws Exception;
	public List<ReportDetailVO> selectAll() throws Exception;
	
	public void insertMap(HashMap<String, String> map) throws Exception;
}

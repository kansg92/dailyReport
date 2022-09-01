package com.kanne.dailyreport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kanne.dailyreport.vo.ReportVO;

@Repository
@Mapper
public interface ReportDao {
	public void insert(ReportVO report) throws Exception;
	public void update(ReportVO report) throws Exception;
	public void delete(int id) throws Exception;
	public void delete(ReportVO report) throws Exception;
	public ReportVO select(int id) throws Exception;
	public List<ReportVO> selectAll() throws Exception;
	public ReportVO checkDate(String day) throws Exception;
}

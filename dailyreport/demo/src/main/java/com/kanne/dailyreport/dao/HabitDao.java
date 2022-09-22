package com.kanne.dailyreport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kanne.dailyreport.vo.HabitVO;

@Mapper
@Repository
public interface HabitDao {
	public void insert(HabitVO obj) throws Exception;
	public void update(HabitVO obj) throws Exception;
	public void delete(String id) throws Exception;
	public HabitVO select(String id) throws Exception;
	public List<HabitVO> selectAll() throws Exception;
	
}

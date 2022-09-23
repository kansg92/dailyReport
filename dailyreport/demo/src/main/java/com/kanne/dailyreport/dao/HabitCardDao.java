package com.kanne.dailyreport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kanne.dailyreport.vo.HabitCardVO;

@Mapper
@Repository
public interface HabitCardDao {
	public void insert(HabitCardVO obj) throws Exception;
	public void update(HabitCardVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public HabitCardVO select(int id) throws Exception;
	public List<HabitCardVO> selectAll() throws Exception;
	public List<HabitCardVO> getHabitList(@Param("uid") String uid,@Param("reg_date") String reg_date) throws Exception;
	public List<HabitCardVO> getHabitList2(String reg_date) throws Exception;
	public void updateStatus(@Param("id") int id, @Param("statusCode") int statusCode) throws Exception;
}

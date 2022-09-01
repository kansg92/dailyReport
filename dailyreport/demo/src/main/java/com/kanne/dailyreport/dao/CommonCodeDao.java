package com.kanne.dailyreport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kanne.dailyreport.vo.CommonCodeVO;

@Mapper
@Repository
public interface CommonCodeDao {
	public void insert(CommonCodeVO code) throws Exception;
	public void update(CommonCodeVO code) throws Exception;
	public void delete(CommonCodeVO code) throws Exception;
	
	public CommonCodeVO select(int detail_code) throws Exception;
	public List<CommonCodeVO> selectAll() throws Exception;
	public List<CommonCodeVO> selectCommonCode() throws Exception;
	public List<CommonCodeVO> getimmersion() throws Exception;
}

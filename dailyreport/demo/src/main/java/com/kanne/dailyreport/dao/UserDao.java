package com.kanne.dailyreport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kanne.dailyreport.vo.UserVO;

@Repository
@Mapper
public interface UserDao {
	public void insert(UserVO user) throws Exception;
	public void delete(UserVO user) throws Exception;
	public void update(UserVO user) throws Exception;
	public UserVO select(String id) throws Exception;
	public List<UserVO> selectAll() throws Exception;
}

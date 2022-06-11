package com.kanne.dailyreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kanne.dailyreport.dao.UserDao;
import com.kanne.dailyreport.frame.Service;
import com.kanne.dailyreport.vo.UserVO;

@org.springframework.stereotype.Service
public class UserService implements Service<UserVO, String> {

	@Autowired
	UserDao dao;

	@Override
	public void register(UserVO v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(UserVO v) throws Exception {
		dao.delete(v);
		
	}

	@Override
	public void modify(UserVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public UserVO get(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	@Override
	public List<UserVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
	

}

package com.kanne.dailyreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kanne.dailyreport.dao.CommonCodeDao;
import com.kanne.dailyreport.frame.Service;
import com.kanne.dailyreport.vo.CommonCodeVO;

@org.springframework.stereotype.Service
public class CommonCodeService implements Service<CommonCodeVO, Integer> {
	
	@Autowired
	CommonCodeDao dao;
	
	@Override
	public void register(CommonCodeVO v) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(v);
	}

	@Override
	public void remove(CommonCodeVO v) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(v);
	}

	@Override
	public void modify(CommonCodeVO v) throws Exception {
		// TODO Auto-generated method stub
		dao.update(v);
	}

	@Override
	public CommonCodeVO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	@Override
	public List<CommonCodeVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
	public List<CommonCodeVO> getComCode(Integer k) throws Exception{
		return dao.selectComCode(k);
	}

}

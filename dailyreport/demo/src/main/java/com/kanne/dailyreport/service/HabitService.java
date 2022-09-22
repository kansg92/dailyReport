package com.kanne.dailyreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kanne.dailyreport.dao.HabitDao;
import com.kanne.dailyreport.frame.Service;
import com.kanne.dailyreport.vo.HabitVO;

@org.springframework.stereotype.Service
public class HabitService implements Service<HabitVO, String> {

	@Autowired
	HabitDao dao;
	
	@Override
	public void register(HabitVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(HabitVO v) throws Exception {
		
	}

	@Override
	public void trueRemove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(HabitVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public HabitVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<HabitVO> get() throws Exception {
		return dao.selectAll();
	}

}

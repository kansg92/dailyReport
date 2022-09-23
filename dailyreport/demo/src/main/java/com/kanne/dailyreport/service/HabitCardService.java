package com.kanne.dailyreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kanne.dailyreport.dao.HabitCardDao;
import com.kanne.dailyreport.frame.Service;
import com.kanne.dailyreport.vo.HabitCardVO;

@org.springframework.stereotype.Service
public class HabitCardService implements Service<HabitCardVO, Integer> {

	@Autowired
	HabitCardDao dao;
	
	@Override
	public void register(HabitCardVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(HabitCardVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trueRemove(Integer id) throws Exception {
		dao.delete(id);
		
	}

	@Override
	public void modify(HabitCardVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public HabitCardVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<HabitCardVO> get() throws Exception {
		return dao.selectAll();
	}
	
	public List<HabitCardVO> getHabitList(String uid,String reg_date) throws Exception {
		return dao.getHabitList(uid,reg_date);
	}
	
	public List<HabitCardVO> getHabitList2(String reg_date) throws Exception {
		return dao.getHabitList2(reg_date);
	}
	
	public void updateStatus(int id, int statusCode) throws Exception {
		dao.updateStatus(id, statusCode);
	}
	
}

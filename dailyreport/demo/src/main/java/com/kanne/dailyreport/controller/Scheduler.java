package com.kanne.dailyreport.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kanne.dailyreport.service.HabitCardService;
import com.kanne.dailyreport.service.HabitService;
import com.kanne.dailyreport.service.UserService;
import com.kanne.dailyreport.vo.HabitCardVO;
import com.kanne.dailyreport.vo.HabitVO;
import com.kanne.dailyreport.vo.UserVO;

@Component
public class Scheduler {

	@Autowired
	UserService userService;
	@Autowired
	HabitService habitService;
	@Autowired
	HabitCardService habitcardService;
	
	
	@Scheduled(cron="0 0 0 * * *")	
	public void habitUpdate() {
		System.out.println("----------- Scheduler Start ------------");
		
		// 1. 날짜 표시 format
				SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");    
				// 2. 오늘날짜 Data 클래스로 구하기(기준날짜가 오늘이 아니면 생략가능)
				Date today = new Date();
				// 3. 오늘날짜 format에 맞춰서 String 으로 변경(기준날짜가 오늘이 아니면 생략가능)
				String date =  formatter.format(today);
				// 4. 기준이 되는 날짜(format에 맞춘)
				Date setDate = null;
				try {
					setDate = formatter.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// 5. 한국 날짜 기준 Calendar 클래스 선언
				Calendar cal = new GregorianCalendar(Locale.KOREA);
				// 6. 선언된 Calendar 클래스에 기준 날짜 설정
				cal.setTime(setDate);
				// 7. 하루전으로 날짜 설정
				cal.add(Calendar.DATE, -1);
				// 8. 하루전으로 설정된 날짜를 설정된 format으로 String 타입 변경
				String yesterday = formatter.format(cal.getTime());
				System.out.println(yesterday);
				
				//1. 모든 유저 데이터 가져온다.
				List<UserVO> users = null;
				try {
					users = userService.get();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//2. habit 오늘날짜로 삽입한다.
				for (UserVO user : users) {
					HabitVO habit = new HabitVO(null, null, null, user.getId());
					try {
						habitService.register(habit);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//3. habitcard 전일날짜데이터를 가져와서 오늘날짜로 삽입한다.
				List<HabitCardVO> habit = null;
				try {
					habit = habitcardService.getHabitList2(yesterday);
				} catch (Exception e) {
					e.printStackTrace();
				}
				for (HabitCardVO obj : habit) {
					try {
						habitcardService.register(obj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		
		
		System.out.println("----------- Scheduler End ------------");
	}
	
}

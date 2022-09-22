package com.kanne.dailyreport.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class HabitCardVO {

	private int id;
	private int num;
	private String habit;
	private int statusCode;
	private String status;
	private int valueCode;
	private String value;
	private String reg_date;
	private String up_date;
	private String uid;
}

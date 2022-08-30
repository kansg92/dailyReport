package com.kanne.dailyreport.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabitVO {
	private int id;
	private String habit1;
	private String habit2;
	private String habit3;
	private String habit4;
	private String uid;
}

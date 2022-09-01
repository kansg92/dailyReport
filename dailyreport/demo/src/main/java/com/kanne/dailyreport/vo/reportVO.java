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
public class ReportVO {
	private Integer id;
	private String day;
	private String reg_date;
	private String up_date;
	private String del_date;
	private String feedback;
	private String uid;
	private double score;
}

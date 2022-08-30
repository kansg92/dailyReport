package com.kanne.dailyreport.vo;

import java.util.Date;

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
	private int id;
	private Date reg_date;
	private String start_time;
	private String end_time;
	private String contents;
	private int catecode;
	private String category;
	private int immercode;
	private String immersion;
	private String feedback;
	private String uid;
	
	public ReportVO(String start_time, String end_time, String contents, int catecode, int immercode, String feedback,
			String uid) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.contents = contents;
		this.catecode = catecode;
		this.immercode = immercode;
		this.feedback = feedback;
		this.uid = uid;
	}
	
	
}

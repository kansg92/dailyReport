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
public class ReportDetailVO {
	private int id;
	private String start_time;
	private String end_time;
	private String contents;
	private int catecode;
	private String category;
	private int immercode;
	private String immersion;
	private String reg_date;
	private String up_date;
	private String del_date;
	private int report_id;
	public ReportDetailVO(int id, String start_time, String end_time, String contents, int catecode, int immercode,
			String reg_date) {
		this.id = id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.contents = contents;
		this.catecode = catecode;
		this.immercode = immercode;
		this.reg_date = reg_date;
	}
	public ReportDetailVO(String start_time, String end_time, int catecode, int immercode) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.catecode = catecode;
		this.immercode = immercode;
	}
	
	
	
	
}

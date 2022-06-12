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
	private Date regdate;
	private String stime;
	private String etime;
	private String contents;
	private int catecode;
	private String category;
	private int immercode;
	private String immersion;
	private String feedback;
	private String uid;
	public ReportVO(String stime, String etime, String contents, int catecode, int immercode, String feedback,
			String uid) {
		this.stime = stime;
		this.etime = etime;
		this.contents = contents;
		this.catecode = catecode;
		this.immercode = immercode;
		this.feedback = feedback;
		this.uid = uid;
	}
	
	
}

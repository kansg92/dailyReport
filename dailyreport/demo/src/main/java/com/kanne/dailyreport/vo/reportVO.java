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
	private String category;
	private String immersion;
	private String feedback;
	private String uid;
}

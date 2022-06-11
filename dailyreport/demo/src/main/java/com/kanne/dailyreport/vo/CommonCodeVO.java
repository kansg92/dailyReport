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
public class CommonCodeVO {
	private int scode;
	private Integer comcode;
	private String name;
	private Date regdate;
	private Date udate;
	private Date ddate;
	
	public CommonCodeVO(int scode, Integer comcode, String name) {
		this.scode = scode;
		this.comcode = comcode;
		this.name = name;
	}

	public CommonCodeVO(int scode, String name) {
		this.scode = scode;
		this.name = name;
	}

	public CommonCodeVO(int scode) {
		this.scode = scode;
	}
	
	
}

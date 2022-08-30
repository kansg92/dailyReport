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
	private int detail_code;
	private Integer common_code;
	private String name;
	private Date reg_date;
	private Date up_date;
	private Date del_date;
	
	public CommonCodeVO(int detail_code, Integer common_code, String name) {
		this.detail_code = detail_code;
		this.common_code = common_code;
		this.name = name;
	}

	public CommonCodeVO(int detail_code, String name) {
		this.detail_code = detail_code;
		this.name = name;
	}

	public CommonCodeVO(int detail_code) {
		this.detail_code = detail_code;
	}
	
	
}

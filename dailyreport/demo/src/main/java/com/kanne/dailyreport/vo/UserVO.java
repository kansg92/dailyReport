package com.kanne.dailyreport.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private Date reg_date;
	private Date up_date;
	private Date del_date;
	public UserVO(String id, String name, String pwd, String email) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
	}
	public UserVO(String id) {
		
		this.id = id;
	}
	
	
	
}

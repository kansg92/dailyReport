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
	private String first_name;
	private String last_name;
	private String pwd;
	private String email;
	private Date reg_date;
	private Date up_date;
	private Date del_date;

	
	
	public UserVO(String id) {
		
		this.id = id;
	}

	/** 회원가입시 필요 정보 */
	public UserVO(String id, String first_name, String last_name, String pwd, String email) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.pwd = pwd;
		this.email = email;
	}
	
	
	
}

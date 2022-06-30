package com.springbook.biz.user;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password, name, role;

}

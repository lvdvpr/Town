package com.town.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUser {

	private int userNo;
	private String id;
	private String encryptPassword;
	private String name;
	private String email;
	private String phone;
	private String userStatus;
	private String roleName;
}

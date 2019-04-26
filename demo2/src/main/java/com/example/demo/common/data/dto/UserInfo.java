package com.example.demo.common.data.dto;

import com.example.demo.common.constants.enump.USER_DIV;

/**
 * ユーザ情報.
 */
public class UserInfo {

	/**　 ユーザID. */
	private String userId;

	/**　 パスワード. */
	private String password;
	
	/**　 ユーザ区分. */
	private USER_DIV userDiv;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public USER_DIV getUserDiv() {
		return userDiv;
	}

	public void setUserDiv(USER_DIV userDiv) {
		this.userDiv = userDiv;
	}

}
package com.example.demo.common.data.dto;

import com.example.demo.common.constants.enump.UserDivEnum;

/**
 * ユーザ情報.
 */
public class UserInfo {

	/**　 ユーザID. */
	private String userId;

	/**　 パスワード. */
	private String password;
	
	/**　 ユーザ区分. */
	private UserDivEnum userDiv;
	
	/**　 ユーザ詳細情報. */
	private UserDetailInfo userDetailInfo;
	
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

	public UserDivEnum getUserDiv() {
		return userDiv;
	}

	public void setUserDiv(UserDivEnum userDiv) {
		this.userDiv = userDiv;
	}

	public UserDetailInfo getUserDetailInfo() {
		return userDetailInfo;
	}

	public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
		this.userDetailInfo = userDetailInfo;
	}

}
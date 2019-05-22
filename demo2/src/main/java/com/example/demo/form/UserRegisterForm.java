package com.example.demo.form;

import javax.validation.constraints.Size;

/**
 * ユーザ詳細情報Form.
 */
public class UserRegisterForm {
	
	/**　 ユーザID. */
	@Size(min = 1, max = 10)
	private String userId;

	/**　 名前. */
	private String userName;

	/**　 生年月日. */
	private String birthday;
	
	/**　 メールアドレス. */
	private String maiAddress;
	
	/**　 エンジニア開始日. */
	private String engineerStartDate;
	
	/**　 備考. */
	private String note;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMaiAddress() {
		return maiAddress;
	}

	public void setMaiAddress(String maiAddress) {
		this.maiAddress = maiAddress;
	}

	public String getEngineerStartDate() {
		return engineerStartDate;
	}

	public void setEngineerStartDate(String engineerStartDate) {
		this.engineerStartDate = engineerStartDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}



}
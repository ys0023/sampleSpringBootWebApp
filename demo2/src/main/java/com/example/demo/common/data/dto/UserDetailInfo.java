package com.example.demo.common.data.dto;

/**
 * ユーザ詳細情報.
 */
public class UserDetailInfo {

	/**　 ユーザID. */
	private String userId;

	/**　 名前. */
	private String userName;

	/**　 生年月日. */
	private String birthday;
	
	/**　 メールアドレス. */
	private String mailAddress;
	
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

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
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
package com.example.demo.form;

import javax.validation.constraints.Size;

/**
 * ログイン情報Form.
 */
public class LoginForm {

	/**　 ユーザID. */
	@Size(min = 1, max = 10)
	private String user;
	
	/**　 パスワード. */
	@Size(min = 1, max = 20)
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
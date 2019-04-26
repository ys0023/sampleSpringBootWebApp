package com.example.demo.common.data.datamemory;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.common.data.dto.UserInfo;

/**
 * メモリ情報.
 */
public class DemoDataMemory {
	
	/** ユーザ情報Map. */
	public static Map<String, UserInfo> USER_INFO_MAP = new HashMap<String, UserInfo>();

	/**
	 * メモリから全ユーザ情報の取得する.
	 * @return 全ユーザ情報
	 */
	public static Map<String, UserInfo> getAllUserLoginInfo() {
		return USER_INFO_MAP;
	}
	
	/**
	 * メモリからユーザ情報の取得する.
	 * @param ユーザID
	 * @return ユーザ情報
	 */
	public static UserInfo getUserLoginInfo(String userId) {
		return USER_INFO_MAP.get(userId);
	}

	/**
	 * メモリへユーザ情報を登録する.
	 * @param ユーザ情報
	 */
	public static void registUserLoginInfo(UserInfo userInfo) {
		USER_INFO_MAP.put(userInfo.getUserId(), userInfo);
	}

}

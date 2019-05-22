package com.example.demo.common.data.datamemory;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.ServletInitializer;
import com.example.demo.common.constants.CommonConstant;
import com.example.demo.common.constants.enump.UserDivEnum;
import com.example.demo.common.data.dto.UserInfo;

/**
 * メモリ情報.
 */
public class DemoDataMemory {
	
	/** 
	 * ユーザ情報Map. 
	 * <p>
	 * サーバ起動時に読み込んだ、以下のファイル情報を保持する
	 * <li>admin_user_info_data.txt</li>
	 * <li>user_login_info_data.txt</li>
	 * <li>user_detail_info_data.csv</li>
	 * </p>
	 * */
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
	
	/**
	 * メモリーデータの再読み込み処理.
	 */
	public static  void reroadMemoryData() {
		
		ServletInitializer si = new ServletInitializer();
		si.initUserInfoMemory(CommonConstant.USER_FILE_NAME, UserDivEnum.NOMAL_USER);
	}

	/**
	 * メモリへユーザ情報を初期化する.
	 */
	public static void clearUserLoginInfo() {
		USER_INFO_MAP.clear();
	}

}

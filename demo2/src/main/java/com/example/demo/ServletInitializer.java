package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.common.constants.enump.USER_DIV;
import com.example.demo.common.data.datamemory.DemoDataMemory;
import com.example.demo.common.data.dto.UserInfo;

/**
 * アプリケーション初期化クラス.
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	/** Logger. */
	private static Log LOG = LogFactory.getLog(ServletInitializer.class);

	// TODO 「admin_user_info_data.txt」の配置場所のフルパスを記載
	/**　管理ユーザ情報の設定ファイルpath. */
	public static final String ADMIN_USER_INFO_PATH = "C:\\\\Users\\\\yamashitayb\\\\Desktop\\\\山フォルダ\\\\98_GitHub\\\\wordspace\\\\demo2\\\\WebContext\\\\WEB-INF\\\\datafile\\\\admin_user_info_data.txt";

	// TODO 「user_login_info_data.txt」の配置場所のフルパスを記載
	/**　通常ユーザ情報の設定ファイルpath. */
	public static final String USER_INFO_PATH = "C:\\\\Users\\\\yamashitayb\\\\Desktop\\\\山フォルダ\\\\98_GitHub\\\\wordspace\\\\demo2\\\\WebContext\\\\WEB-INF\\\\datafile\\\\user_login_info_data.txt"; 

	/**
	 * アプリケーション初期化処理.
	 * <p>
	 * サーバ起動時に実行されます.
	 * 注）Demo2Application.javaからアプリケーションを起動した場合は実行されません。
	 * <p>
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		// 管理者ファイルより管理者ユーザ情報をメモリに設定
		this.initUserInfoMemory(ADMIN_USER_INFO_PATH, USER_DIV.MASTER_USER);
		
		// ユーザファイルよりユーザ情報をメモリに設定
		this.initUserInfoMemory(USER_INFO_PATH, USER_DIV.NOMAL_USER);
		
		return application.sources(Demo2Application.class);
	}
	
	/**
	 * ユーザ情報のメモリ登録処理.
	 * <p>
	 * ファイルのユーザ情報をメモリに登録する.
	 * </p>
	 * @param filePath ユーザ情報設定ファイルパス
	 * @param userDiv ユーザ区分（Enum）
	 */
	public void initUserInfoMemory(String filePath, USER_DIV userDiv) {
		
	    File file = new File(filePath);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			String text = null;
			while ((text = br.readLine()) != null) {
				
				String[] userLoginInfo = text.split(",");
				String userId = userLoginInfo[0];
				String pasword = userLoginInfo[1];
				
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(userId);
				userInfo.setPassword(pasword);
				userInfo.setUserDiv(userDiv);
				
				DemoDataMemory.registUserLoginInfo(userInfo);
			}
		} catch (FileNotFoundException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		}
	}

}

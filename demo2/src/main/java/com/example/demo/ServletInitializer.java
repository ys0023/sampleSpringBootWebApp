package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.common.constants.CommonConstant;
import com.example.demo.common.constants.enump.UserDivEnum;
import com.example.demo.common.data.datamemory.DemoDataMemory;
import com.example.demo.common.data.dto.FileDataInfo;
import com.example.demo.common.data.dto.UserDetailInfo;
import com.example.demo.common.data.dto.UserInfo;
import com.example.demo.common.util.CommonUtil;
import com.example.demo.service.DataFileService;

/**
 * アプリケーション初期化クラス.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * アプリケーション初期化処理.
	 * <p>
	 * サーバ起動時に実行されます. 注）Demo2Application.javaからアプリケーションを起動した場合は実行されません。
	 * <p>
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		// 管理者ファイルより管理者ユーザ情報をメモリに設定
		this.initUserInfoMemory(CommonConstant.ADMIN_USER_FILE_NAME, UserDivEnum.MASTER_USER);

		// ユーザファイルよりユーザ情報をメモリに設定
		this.initUserInfoMemory(CommonConstant.USER_FILE_NAME, UserDivEnum.NOMAL_USER);

		return application.sources(Demo2Application.class);
	}

	/**
	 * ユーザ情報のメモリ登録処理.
	 * <p>
	 * ファイルのユーザ情報をメモリに登録する.
	 * </p>
	 * 
	 * @param filePath ユーザ情報設定ファイルパス
	 * @param userDiv  ユーザ区分（Enum）
	 */
	public void initUserInfoMemory(String fileName, UserDivEnum userDiv) {
        
		// 読み込みファイルのフルPATH
        String readFilePath = CommonUtil.readFilePath(fileName);

		// ファイルのユーザ情報の取得
		DataFileService dataFileService = new DataFileService();
		FileDataInfo fileDataInfo = dataFileService.getFileData(readFilePath, CommonConstant.FILE_HEADER_NOT_EXIST);
		
		// ファイルのユーザ詳細情報の取得
		List<UserDetailInfo> userDetailInfoList = this.initUserDetailInfo();

		for (String fileValue : fileDataInfo.getFileDataList()) {

			String[] userLoginInfo = fileValue.split(",");
			String userId = userLoginInfo[0];
			String pasword = userLoginInfo[1];

			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(userId);
			userInfo.setPassword(pasword);
			userInfo.setUserDiv(userDiv);

			for (UserDetailInfo userDetailInfo : userDetailInfoList) {
				
				if (userDetailInfo.getUserId().equals(userId)) {
					userInfo.setUserDetailInfo(userDetailInfo);
					break;
				}
			}

			DemoDataMemory.registUserLoginInfo(userInfo);
		}
	}

	/**
	 * ユーザ詳細情報の取得処理.
	 * <p>
	 * ファイルのユーザ詳細情報を取得する.
	 * </p>
	 * 
	 * @return ユーザ詳細情報
	 */
	public List<UserDetailInfo> initUserDetailInfo() {

		List<UserDetailInfo> userDetailInfoList = new ArrayList<UserDetailInfo>();
		
		// 読み込みファイルのフルPATH
		String readFilePath = CommonUtil.readFilePath(CommonConstant.USER_DETAIL_FILE_NAME);

		// ファイルのユーザ詳細情報の取得
		DataFileService dataFileService = new DataFileService();
		FileDataInfo fileDataInfo = dataFileService.getFileData(readFilePath, CommonConstant.FILE_HEADER_EXIST);

		for (String fileValue : fileDataInfo.getFileDataList()) {

			String[] userDetailInfoText = fileValue.split(",");
			String userId = userDetailInfoText[0];
			String userName = userDetailInfoText[1];
			String birthday = userDetailInfoText[2];
			String mailAddress = userDetailInfoText[3];
			String engineerStartDate = userDetailInfoText[4];
			String note = userDetailInfoText[5];

			UserDetailInfo userDetailInfo = new UserDetailInfo();
			userDetailInfo.setUserId(userId);
			userDetailInfo.setUserName(userName);
			userDetailInfo.setBirthday(birthday);
			userDetailInfo.setMailAddress(mailAddress);
			userDetailInfo.setEngineerStartDate(engineerStartDate);
			userDetailInfo.setNote(note);
			
			userDetailInfoList.add(userDetailInfo);
		}

		return userDetailInfoList;
	}

}

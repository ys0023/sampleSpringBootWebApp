package com.example.demo.service;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.common.constants.CommonConstant;
import com.example.demo.common.constants.MessageConstant;
import com.example.demo.common.data.datamemory.DemoDataMemory;
import com.example.demo.common.data.dto.FileDataInfo;
import com.example.demo.common.data.dto.UserInfo;
import com.example.demo.common.exception.AppException;
import com.example.demo.common.util.CommonUtil;
import com.example.demo.common.util.MessageUtil;
import com.example.demo.form.UserRegisterForm;

/**
 * ユーザサービス.
 */
@Component
@Service
public class UserService {

	/** データ書込みサービス. */
	@Autowired
	private DataFileService dataWriteService;

	/**
	 * ユーザ情報の取得する.
	 * 
	 * @param user ユーザID
	 * @return ユーザ情報
	 */
	public UserInfo getUserInfo(String user) {

		return DemoDataMemory.USER_INFO_MAP.get(user);
	}

	/**
	 * 全ユーザ情報の取得する.
	 * 
	 * @return 全ユーザ情報
	 */
	public Map<String, UserInfo> getAllUserInfo() {

		return DemoDataMemory.USER_INFO_MAP;
	}

	// TODO まだ呼ばれてない
	/**
	 * ユーザ詳細情報を登録する.
	 * 
	 * @param userRegisterForm ユーザ詳細情報Form
	 * @throws AppException 
	 */
	public void registerUserInfo(UserRegisterForm userRegisterForm) throws AppException {

		// ユーザ情報の取得
		UserInfo userInfo = this.getUserInfo(userRegisterForm.getUserId());
		
		// 既にユーザ詳細が登録されている場合は登録させない
		if (userInfo.getUserDetailInfo().getUserName() != null) {
			throw new AppException(MessageUtil.getMessage(MessageConstant.MESSAGE_ERROR_ID_002));
		}

		// ファイル情報に加工
		FileDataInfo userDetailValue = this.createFileDataInfo(userRegisterForm);
		
		// 読み込みファイルのフルPATH
		String readFilePath = CommonUtil.readFilePath(CommonConstant.USER_DETAIL_FILE_NAME);

		// 新規登録
		dataWriteService.addData(readFilePath, userDetailValue, StandardOpenOption.APPEND);
		
		// ユーザ詳細情報のメモリ初期化
		DemoDataMemory.reroadMemoryData();

	}
	
	/**
	 * ユーザ詳細情報を削除する.
	 * 
	 * @param userId ユーザID
	 */
	public void deleteUserInfo(String userId) {
		
		// 読み込みファイルのフルPATH
		String readFilePath = CommonUtil.readFilePath(CommonConstant.USER_DETAIL_FILE_NAME);

		// データ削除
		dataWriteService.deleteData(readFilePath, userId);
		
		// ユーザ詳細情報のメモリ初期化
		DemoDataMemory.reroadMemoryData();
	}

	/**
	 * データ書込み用のユーザ詳細情報(ファイル情報)に加工する.
	 * 
	 * @param userRegisterForm ユーザ詳細情報Form
	 * @return データ書込み用のファイル情報
	 */
	private FileDataInfo createFileDataInfo(UserRegisterForm userRegisterForm) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(userRegisterForm.getUserId());
		sb.append(",");
		sb.append(userRegisterForm.getUserName());
		sb.append(",");
		sb.append(userRegisterForm.getBirthday());
		sb.append(",");
		sb.append(userRegisterForm.getMaiAddress());
		sb.append(",");
		sb.append(userRegisterForm.getEngineerStartDate());
		sb.append(",");
		sb.append(userRegisterForm.getNote());
		
		List<String> writeValueList = new ArrayList<String>();
		writeValueList.add(sb.toString());
		
		FileDataInfo fileDataInfo = new FileDataInfo();
		fileDataInfo.setFileDataList(writeValueList);
		
		return fileDataInfo;
	}
	
}

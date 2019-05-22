package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.example.demo.common.constants.CommonConstant;
import com.example.demo.common.data.dto.FileDataInfo;

/**
 * データファイル書込みサービス.
 */
@Component
@Service
public class DataFileService {
	
	/** ヘッダー行. */
	public static final int FILE_HEADER_LINE = 1;

	/**
	 * データ登録処理.
	 * 
	 * @param dataFilePath 書込みデータファイルのPath
	 * @param fileDataInfo ファイル情報DTO
	 * @param mode 書込みモード
	 */
	public void addData(String dataFilePath, FileDataInfo fileDataInfo, StandardOpenOption mode) {

		try {

			List<String> writeValueList = fileDataInfo.getFileWriteDataList();

			Path path = Paths.get(dataFilePath);
			Files.write(path, writeValueList, Charset.forName(CommonConstant.SHIFT_JIS), mode);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * データ削除処理.
	 * <p>
	 * 指定したユーザIDのデータを対象ファイルより削除する.
	 * </p>
	 * 
	 * @param filePath ユーザ情報設定ファイルパス
	 * @param userId   ユーザID
	 */
	public void deleteData(String filePath, String userId) {

		// ファイル書込み情報の取得
		FileDataInfo fileDataInfo = this.getFileData(filePath, CommonConstant.FILE_HEADER_EXIST);

		// 削除対象ユーザの除外
		List<String> fileDataList = fileDataInfo.getFileDataList();
		for (int i = 0; i < fileDataList.size(); i++) {
			String fileUserId = fileDataList.get(i).split(",")[0];
			if (fileUserId.equals(userId)) {
				fileDataList.remove(i);
			}
		}

		// ファイル上書
		this.addData(filePath, fileDataInfo, StandardOpenOption.TRUNCATE_EXISTING);
	}

	/**
	 * ファイル情報取得処理.
	 * <p>
	 * 指定したPATHのファイル情報をリストに追加して返却する。<br>
	 * </p>
	 * 
	 * @value filePath ファイルPATH
	 * @value isExistHeader ファイルヘッダーフラグ（true：ヘッダー有、false：ヘッダー無）
	 * @return ファイル情報DTO
	 */
	public FileDataInfo getFileData(String filePath, boolean isExistHeader) {

		File readFile = new File(filePath);
		BufferedReader br = null;

		FileDataInfo fileDataInfo = new FileDataInfo();

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(readFile), CommonConstant.SHIFT_JIS));

			String text = null;
			int lineCount = 0;

			List<String> fileValueList = new ArrayList<>();

			while ((text = br.readLine()) != null) {

				lineCount++;

				String[] fileDataText = text.split(",");

				StringBuffer valueSb = new StringBuffer();
				for (String value : fileDataText) {
					valueSb.append(value);
					valueSb.append(",");
				}

				// ヘッダー情報
				if (isExistHeader && lineCount == FILE_HEADER_LINE) {
					fileDataInfo.setFileHeaderInfo(valueSb.toString());

					// ファイルの値
				} else {
					fileValueList.add(valueSb.toString());
				}
			}

			fileDataInfo.setFileDataList(fileValueList);

		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return fileDataInfo;
	}
	
}

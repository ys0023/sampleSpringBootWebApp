package com.example.demo.common.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.demo.common.constants.CommonConstant;

/**
 * 共通Utilクラス
 */
public class CommonUtil {
	
	/**
	 * 最後の文字列削除処理（String）.
	 * <p>
	 * 例）<br>
	 * 前："value1value2,value3"<br>
	 * 後："value1value2,value"
	 * </p>
	 * 
	 * @param value 対象文字列
	 * @return 最後の文字列削除した文字列
	 */
	public static String removeLastChar(String value) {

		return value.substring(0, value.length() - 2);
	}
	
	/**
	 * ファイルフルPATH取得処理.
	 * <p>
	 * 上手くファイルの早退パス指定が出来ないので苦肉の策
	 * </p>
	 * 
	 * @param fileName ファイル名
	 * @return ファイル名込みのフルPATH
	 */
	public static String readFilePath(String fileName) {
		
//        Path path = Paths.get(fileName);
//        String fileFullPath = path.toAbsolutePath().toString();
//        String convertFilePath = fileFullPath.replaceAll(fileName, "");
//        return convertFilePath + CommonConstant.DATA_FILE_PATH + fileName;
		return CommonConstant.DATA_FILE_PATH + fileName;
	}

}

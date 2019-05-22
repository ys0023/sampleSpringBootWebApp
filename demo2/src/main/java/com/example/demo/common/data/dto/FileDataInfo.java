package com.example.demo.common.data.dto;

import java.util.List;

/**
 * ファイル情報DTO.
 */
public class FileDataInfo {

	/**　 ファイルヘッダー情報（各項目はカンマ区切り）. */
	private String fileHeaderInfo;

	/**　 ファイルデータ情報リスト（各項目はカンマ区切り）. */
	private List<String> fileDataList;

	public String getFileHeaderInfo() {
		return fileHeaderInfo;
	}

	public void setFileHeaderInfo(String fileHeaderInfo) {
		this.fileHeaderInfo = fileHeaderInfo;
	}

	public List<String> getFileDataList() {
		return fileDataList;
	}

	public void setFileDataList(List<String> fileDataList) {
		this.fileDataList = fileDataList;
	}
	
	/**
	 * ヘッダーとファイル情報取得処理.
	 * <p>
	 * ヘッダーが存在しないファイルは追加されない<br>
	 * ヘッダーが存在する場合はリスト要素の1番目がヘッダー情報。それ以降の要素はデータ情報。
	 * </p>
	 * @return ファイル情報リスト
	 */
	public List<String> getFileWriteDataList() {
		
		if (fileHeaderInfo != null) {
			this.fileDataList.add(0, fileHeaderInfo);			
		}
		return fileDataList;
	}
	

}
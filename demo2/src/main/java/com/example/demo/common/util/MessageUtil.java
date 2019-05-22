package com.example.demo.common.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * メッセージUtilクラス
 */
public class MessageUtil {
	
	/**
	 * メッセージ取得処理.
	 * <p>
	 * メッセージIDに紐づくメッセージをメッセージプロパティから取得する<br>
	 * また引数に置換文字列が存在する場合は、メッセージ内の{0}、{1}…と置換する
	 * </p>
	 * 
	 * @param messageId メッセージID
	 * @param messageParams 置換文字列
	 * @return メッセージ内容
	 */
	public static String getMessage(String messageId, String... messageParams) {
		
        ResourceBundle rb = ResourceBundle.getBundle("properties/message");
        String message = rb.getString(messageId);
        
        MessageFormat mf = new MessageFormat(message);
        String convertMessage = mf.format(messageParams);
        
		return convertMessage;
	}

}

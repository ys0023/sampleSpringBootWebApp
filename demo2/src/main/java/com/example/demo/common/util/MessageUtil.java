package com.example.demo.common.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageUtil {
	
	public static String getMessage(String messageId, String... messageParam) {
		
        ResourceBundle rb = ResourceBundle.getBundle("properties/message");
        String message = rb.getString(messageId);
        
        MessageFormat mf = new MessageFormat(message);
        String convertMessage = mf.format(messageParam);
        
		return convertMessage;
	}

}

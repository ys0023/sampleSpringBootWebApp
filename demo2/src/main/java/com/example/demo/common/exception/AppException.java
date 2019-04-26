package com.example.demo.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	/** Logger. */
	private static Log LOG = LogFactory.getLog(AppException.class);

	public AppException(String str) {
		super(str);
		LOG.error(str);
	}

}

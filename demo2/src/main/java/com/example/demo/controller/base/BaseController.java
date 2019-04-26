package com.example.demo.controller.base;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 基底コントローラクラス.
 */
@Controller
public class BaseController {

	/** HttpSessionクラス. */
	@Autowired
	protected HttpSession session;

	/** エラーメッセージ追加key. */
	protected static final String MODEL_ERROR_MESSASE_KEY = "errorMsg";

}

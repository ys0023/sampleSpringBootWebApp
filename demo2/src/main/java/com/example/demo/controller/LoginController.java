package com.example.demo.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.constants.MessageConstant;
import com.example.demo.common.constants.enump.USER_DIV;
import com.example.demo.common.data.dto.UserInfo;
import com.example.demo.common.util.MessageUtil;
import com.example.demo.controller.base.BaseController;
import com.example.demo.form.LoginForm;
import com.example.demo.service.UserService;

/**
 * ログイン用のコントローラ.
 */
@Controller
public class LoginController extends BaseController {

	/** ユーザServiceクラス. */
	@Autowired
	private UserService userService;

	/**
	 * ログイン処理.
	 *<p>
	 *ログインするユーザにより通常メニュー又は、マスタメニューに遷移する
	 *</p> 
	 * 
	 * @param model Model
	 * @param loginForm ログイン情報Form
	 * @param bindingResult BindingResult
	 * @param request HttpServletRequest
	 * @return 遷移先画面文字列（メニュー画面）
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {

		// バリデーションチェックにひっかった場合はメッセージを設定
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ERROR_MESSASE_KEY, bindingResult.getAllErrors());
			return "index.html";
		}

		// ユーザ情報の取得
		UserInfo userInfo = userService.getUserInfo(loginForm.getUser());

		if (userInfo == null) {
			String errorMessage = MessageUtil.getMessage(MessageConstant.MESSAGE_ERROR_ID_001);
			model.addAttribute(MODEL_ERROR_MESSASE_KEY, errorMessage);
			return "index.html";
		}

		// ログイン時の時間を保持
		Date loginTime = (Date)session.getAttribute("loginTime");
		if (loginTime == null) {
			loginTime = new Date();
			session.setAttribute("loginTime", loginTime);			
		}
		model.addAttribute("loginTime", loginTime);
		
		if (USER_DIV.MASTER_USER.equals(userInfo.getUserDiv())) {
			return "admin_menu.html";
		}

		return "nomal_menu.html";
	}

	/**
	 * ユーザ情報取得API.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/user_api", method = RequestMethod.GET)
	public ResponseEntity<UserInfo> getUserApi(@RequestParam("user") String user, @RequestParam("password") String password) {

		// ユーザ情報の取得
		UserInfo userInfo = userService.getUserInfo(user);
		return ResponseEntity.ok(userInfo);
	}
	
	/**
	 * 全ユーザ情報取得API.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/all_user_api", method = RequestMethod.GET)
	public ResponseEntity<Map<String, UserInfo>> getAllUserApi() {

		// ユーザ情報の取得
		Map<String, UserInfo> allUserInfo = userService.getAllUserInfo();
		return ResponseEntity.ok(allUserInfo);
	}

}

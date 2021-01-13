package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.example.demo.common.data.dto.UserInfo;
import com.example.demo.common.exception.AppException;
import com.example.demo.common.util.MessageUtil;
import com.example.demo.controller.base.BaseController;
import com.example.demo.form.UserRegisterForm;
import com.example.demo.service.UserService;

/**
 * ユーザコントローラ.
 */
@Controller
public class UserController extends BaseController {

	/** ユーザServiceクラス. */
	@Autowired
	private UserService userService;

	/**
	 * ユーザ画面表示処理.
	 * 
	 * @param model Model
	 * @return 遷移先画面文字列（ユーザ画面）
	 */
	@RequestMapping(value = "/user_detail", method = RequestMethod.POST)
	public String showUserDetail(Model model) {
		
		String userId = (String)session.getAttribute("userId");

		// ユーザ情報の取得
		UserInfo userInfo = userService.getUserInfo(userId);

		if (userInfo == null) {
			String errorMessage = MessageUtil.getMessage(MessageConstant.MESSAGE_ERROR_ID_001);
			model.addAttribute(MODEL_ERROR_MESSASE_KEY, errorMessage);
			return "nomal_menu.html";
		}
		
		model.addAttribute("userInfo", userInfo);
		
		return "user_info.html";
	}
	
	/**
	 * ユーザ詳細情報登録処理.
	 * 
	 * @param model Model
	 * @param userRegisterForm ユーザ詳細情報Form
	 * @param bindingResult BindingResult
	 * @param request HttpServletRequest
	 * @return 遷移先画面文字列（ユーザ画面）
	 */
	@RequestMapping(value = "/register_user_detail", method = RequestMethod.POST)
	public String registerUserDetail(Model model, @Valid UserRegisterForm userRegisterForm, BindingResult bindingResult, HttpServletRequest request) {

		// バリデーションチェックにひっかった場合はメッセージを設定
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ERROR_MESSASE_KEY, bindingResult.getAllErrors());
			return "user_info.html";
		}

		try {
			// ユーザ情報の登録
			userService.registerUserInfo(userRegisterForm);
		} catch (AppException e) {
			model.addAttribute(MODEL_ERROR_MESSASE_KEY, e.getMessage());
			return "user_info.html";
		}
		
		// ユーザ情報の取得
		UserInfo userInfo = userService.getUserInfo(userRegisterForm.getUserId());
		
		model.addAttribute("userInfo", userInfo);
		
		return "user_info.html";
	}
	
	/**
	 * ユーザ詳細情報削除処理.
	 * 
	 * @param model Model
	 * @return 遷移先画面文字列（ユーザ画面）
	 */
	@RequestMapping(value = "/delete_user_detail", method = RequestMethod.POST)
	public String deleteUserDetail(Model model) {

		String userId = (String)session.getAttribute("userId");

		// ユーザ情報の削除
		userService.deleteUserInfo(userId);
		
		model.addAttribute(MODEL_MESSASE_KEY, "削除に成功しました");
		
		return "user_info.html";
	}

	/**
	 * ユーザ情報取得API.
	 * 
	 * @param user ユーザID
	 * @param password パスワード
	 * @return ユーザ情報
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
	 * @return 全ユーザ情報
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

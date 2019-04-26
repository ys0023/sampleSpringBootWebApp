package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.base.BaseController;

/**
 * トップ画面表示用のコントローラ.
 */
@Controller
public class HomeController extends BaseController  {

	/**
	   * トップ画面表示処理.
	   * 
	   * @param model Model
	   * @return 遷移先画面文字列（トップ画面）
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		session.invalidate();
		return "index.html";
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.base.BaseController;
import com.example.demo.entity.InventoryControlEntity;
import com.example.demo.service.DemoService;

@Controller
public class DemoController extends BaseController {

	@Autowired
	private DemoService demoService;

	@RequestMapping("/dbtest")
	public String dbTest(Model model) {

		// 在庫管理情報一覧取得
		List<InventoryControlEntity> list = demoService.selectInventoryControlList();
		model.addAttribute("inventoryControlList", list);

		// 在庫管理情報一覧取得(JDBC)
		List<InventoryControlEntity> rsList = demoService.selectJdbcInventoryControlList(30); // 在庫数：30
		model.addAttribute("jdbcInventoryControlList", rsList);

		// 在庫管理情報登録(JDBC)
		InventoryControlEntity entity = new InventoryControlEntity();
		entity.setInventoryId(101);
		entity.setProductName("商品名1");
		entity.setStock(22);
		entity.setPrice(3333);
		entity.setOrigin("産地1");
		entity.setItemType("品目1");
		demoService.insertJdbcInventoryControl(entity);

		return "db_test";
	}

}
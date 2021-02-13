package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.InventoryControlGenerateDao;
import com.example.demo.mybatis.generated.domain.InventoryControl;

/**
 * 在庫管理サービス.
 */
@Component
public class InventoryControlService {

	@Autowired
	private InventoryControlGenerateDao iCGenerateDao;

	/**
	 * 在庫管理情報を取得する.
	 * 
	 * @param inventoryId 在庫ID
	 * @return 在庫管理情報
	 */
	public InventoryControl selectByKey(Integer inventoryId) {
		InventoryControl inventoryControl = iCGenerateDao.selectByKey(inventoryId);
		return inventoryControl;
	}

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControl> selectAllList() {
		List<InventoryControl> list = iCGenerateDao.selectAllList();
		return list;
	}

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @param min 条件値(在庫数最小)
	 * @param max 条件値(在庫数最大)
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControl> selectStockList(Integer min, Integer max) {
		List<InventoryControl> list = iCGenerateDao.selectStockList(min, max);
		return list;
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.InventoryControlDao;
import com.example.demo.dao.InventoryControlJdbcDao;
import com.example.demo.entity.InventoryControlEntity;

/**
 * Demoサービス.
 */
@Component
public class DemoService {

	@Autowired
	private InventoryControlDao inventoryControlDao;

	@Autowired
	private InventoryControlJdbcDao inventoryControlJdbcDao;

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControlEntity> selectInventoryControlList() {
		return inventoryControlDao.selectList();
	}

	/**
	 * 在庫管理情報一覧を取得する(JDBC).
	 * 
	 * @param stock 在庫数
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControlEntity> selectJdbcInventoryControlList(int stock) {
		return inventoryControlJdbcDao.selectByStock(stock);
	}

	/**
	 * 在庫管理情報を登録する(JDBC).
	 * 
	 * @param entity 在庫管理エンティティクラス
	 */
	public void insertJdbcInventoryControl(InventoryControlEntity entity) {
		inventoryControlJdbcDao.insert(entity);
	}
}

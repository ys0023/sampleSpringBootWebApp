package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mybatis.generated.domain.InventoryControl;
import com.example.demo.mybatis.generated.domain.InventoryControlExample;
import com.example.demo.mybatis.generated.mapper.InventoryControlMapper;

/**
 * 在庫管理 DAOクラス(MyBatis自動生成利用).
 */
@Component
@MapperScan(basePackages = { "com.example.demo.mybatis.generated.mapper"})
public class InventoryControlGenerateDao {

	@Autowired
	private InventoryControlMapper mapper;

	/**
	 * 在庫管理情報を取得する.
	 * 
	 * @param inventoryId 在庫ID
	 * @return 在庫管理情報
	 */
	public InventoryControl selectByKey(Integer inventoryId) {
		InventoryControl inventoryControl = mapper.selectByPrimaryKey(inventoryId);
		return inventoryControl;
	}

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControl> selectAllList() {
		InventoryControlExample example = new InventoryControlExample();
		example.createCriteria().getAllCriteria();

		List<InventoryControl> list = mapper.selectByExample(example);
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
		InventoryControlExample example = new InventoryControlExample();
		example.createCriteria().andSTOCKBetween(min, max);

		List<InventoryControl> list = mapper.selectByExample(example);
		return list;
	}
}

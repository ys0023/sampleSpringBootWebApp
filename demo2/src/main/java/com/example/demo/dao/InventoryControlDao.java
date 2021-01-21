package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.InventoryControlEntity;
import com.example.demo.mapper.InventoryControlMapper;

/**
 * 在庫管理 DAOクラス.
 */
@Component
public class InventoryControlDao {

	@Autowired
	private InventoryControlMapper mapper;

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControlEntity> selectList() {
		return mapper.selectAll();
	}

}

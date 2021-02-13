package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.InventoryControlEntity;
import com.example.demo.mapper.InventoryControlCustomMapper;

/**
 * 在庫管理 DAOクラス.
 */
@Component
@MapperScan(basePackages = { "com.example.demo.mapper"})
public class InventoryControlDao {

	@Autowired
	private InventoryControlCustomMapper mapper;

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControlEntity> selectList() {
		return mapper.selectAll();
	}

}

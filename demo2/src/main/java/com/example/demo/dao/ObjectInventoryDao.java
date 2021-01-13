package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ObjectInventory;
import com.example.demo.mapper.ObjectInventoryMapper;

/**
 * ObjectInventory DAOクラス.
 */
@Component
public class ObjectInventoryDao {

    @Autowired
    private ObjectInventoryMapper objectInventoryMapper;

	/**
	 * ObjectInventoryリストを取得する.
	 * 
	 * @return ObjectInventoryリスト
	 */
    public List<ObjectInventory> selectObjectInventory() {
        return objectInventoryMapper.selectAll();
    }

}

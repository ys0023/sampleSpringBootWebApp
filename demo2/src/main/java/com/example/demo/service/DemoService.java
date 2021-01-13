package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ObjectInventoryDao;
import com.example.demo.entity.ObjectInventory;

/**
 * Demoサービス.
 */
@Component
public class DemoService {

    @Autowired
    private ObjectInventoryDao objectInventoryDao;

	/**
	 * ObjectInventoryリストを取得する.
	 * 
	 * @return ObjectInventoryリスト
	 */
    public List<ObjectInventory> selectObjectInventory() {
        return objectInventoryDao.selectObjectInventory();
    }

}

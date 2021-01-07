package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.ObjectInventory;

@Mapper
public interface ObjectInventoryMapper {
    List<ObjectInventory> selectAll();
}

package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.InventoryControlEntity;

@Mapper
public interface InventoryControlCustomMapper {
    List<InventoryControlEntity> selectAll();
}

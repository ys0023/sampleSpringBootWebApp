package com.example.demo.mybatis.generated.mapper;

import com.example.demo.mybatis.generated.domain.InventoryControl;
import com.example.demo.mybatis.generated.domain.InventoryControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InventoryControlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    long countByExample(InventoryControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int deleteByExample(InventoryControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int deleteByPrimaryKey(Integer INVENTORY_ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int insert(InventoryControl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int insertSelective(InventoryControl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    List<InventoryControl> selectByExample(InventoryControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    InventoryControl selectByPrimaryKey(Integer INVENTORY_ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int updateByExampleSelective(@Param("record") InventoryControl record, @Param("example") InventoryControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int updateByExample(@Param("record") InventoryControl record, @Param("example") InventoryControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int updateByPrimaryKeySelective(InventoryControl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    int updateByPrimaryKey(InventoryControl record);
}
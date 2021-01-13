package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.ObjectInventory;

/**
 * ObjectInventory DAOクラス.
 */
@Component
public class ObjectInventoryRsDao {

	/**
	 * ObjectInventoryリストを取得する.
	 * 
	 * @param objectCount 在庫数
	 * @return ObjectInventoryリスト
	 */
	public List<ObjectInventory> selectObjectInventory(int objectCount) {

		List<ObjectInventory> list = new ArrayList<ObjectInventory>();

		Connection conn = null;
		String url = "jdbc:mysql://localhost/mydb?serverTimezone=JST";
		String user = "root";
		String password = "admin";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			StringBuilder sb = new StringBuilder();
			sb.append("select ");
			sb.append("       id");
			sb.append("       , object_name");
			sb.append("       , object_count");
			sb.append("       , object_price");
			sb.append("       , object_origin");
			sb.append("       , object_type");
			sb.append("  from ");
			sb.append("       db_object_inventory ");
			sb.append(" where ");
			sb.append("       object_count = ?");

			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, objectCount);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ObjectInventory obj = new ObjectInventory();
				obj.setId(rs.getString("id"));
				obj.setObjectName(rs.getString("object_name"));
				obj.setObjectCount(rs.getString("object_count"));
				obj.setObjectPrice(rs.getString("object_price"));
				obj.setObjectOrigin(rs.getString("object_origin"));
				obj.setObjectType(rs.getString("object_type"));
				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

}

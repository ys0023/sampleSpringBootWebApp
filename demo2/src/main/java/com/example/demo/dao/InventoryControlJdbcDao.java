package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.InventoryControlEntity;

/**
 * 在庫管理 DAOクラス (JDBC).
 */
@Component
public class InventoryControlJdbcDao {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/mydb?serverTimezone=JST";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	/**
	 * 在庫管理情報一覧を取得する.
	 * 
	 * @param stock 在庫数
	 * @return 在庫管理情報一覧
	 */
	public List<InventoryControlEntity> selectByStock(int stock) {

		List<InventoryControlEntity> list = new ArrayList<InventoryControlEntity>();

		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sb = new StringBuilder();
			sb.append("select ");
			sb.append("         inventory_id");
			sb.append("       , product_name");
			sb.append("       , stock");
			sb.append("       , price");
			sb.append("       , origin");
			sb.append("       , item_type");
			sb.append("  from ");
			sb.append("       inventory_control ");
			sb.append(" where ");
			sb.append("       stock = ?");

			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, stock);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				InventoryControlEntity entity = new InventoryControlEntity();
				entity.setInventoryId(rs.getInt("inventory_id"));
				entity.setProductName(rs.getString("product_name"));
				entity.setStock(rs.getInt("stock"));
				entity.setPrice(rs.getInt("price"));
				entity.setOrigin(rs.getString("origin"));
				entity.setItemType(rs.getString("item_type"));
				list.add(entity);
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

	/**
	 * 在庫管理情報を登録する.
	 * 
	 * @param entity 在庫管理エンティティクラス
	 */
	public void insert(InventoryControlEntity entity) {

		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sb = new StringBuilder();
			sb.append("insert into ");
			sb.append("    inventory_control ( ");
			sb.append("        inventory_id");
			sb.append("       , product_name");
			sb.append("       , stock");
			sb.append("       , price");
			sb.append("       , origin");
			sb.append("       , item_type");
			sb.append(" ) values (");
			sb.append("       ?, ?, ?, ?, ?, ? ");
			sb.append(" ) ");

			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, entity.getInventoryId());
			pstmt.setString(2, entity.getProductName());
			pstmt.setInt(3, entity.getStock());
			pstmt.setInt(4, entity.getPrice());
			pstmt.setString(5, entity.getOrigin());
			pstmt.setString(6, entity.getItemType());
			int registCnt = pstmt.executeUpdate();

			System.out.println("在庫管理情報登録成功 登録件数：" + registCnt + "件");

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

	}

}

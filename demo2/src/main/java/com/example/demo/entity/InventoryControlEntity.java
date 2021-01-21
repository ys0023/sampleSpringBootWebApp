package com.example.demo.entity;

import java.sql.Timestamp;

/**
 * 在庫管理エンティティクラス.
 */
public class InventoryControlEntity {

	/** 在庫ID. */
	private Integer inventoryId;

	/** 商品名. */
	private String productName;

	/** 在庫数. */
	private Integer stock;

	/** 価格. */
	private Integer price;

	/** 産地. */
	private String origin;

	/** 品目. */
	private String itemType;

	/** 登録日時. */
	private Timestamp createDate;

	/** 更新日時. */
	private Timestamp updateDate;

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}

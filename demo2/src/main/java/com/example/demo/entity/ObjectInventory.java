package com.example.demo.entity;

public class ObjectInventory {

    private String id;
    private String objectName;
    private String objectCount;
    private String objectPrice;
    private String objectOrigin;
    private String objectType;

    public String getId() {
        return id;
    }
    
	public void setId(String id) {
        this.id = id;
    }

    public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectCount() {
		return objectCount;
	}

	public void setObjectCount(String objectCount) {
		this.objectCount = objectCount;
	}

	public String getObjectPrice() {
		return objectPrice;
	}

	public void setObjectPrice(String objectPrice) {
		this.objectPrice = objectPrice;
	}

	public String getObjectOrigin() {
		return objectOrigin;
	}

	public void setObjectOrigin(String objectOrigin) {
		this.objectOrigin = objectOrigin;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
}

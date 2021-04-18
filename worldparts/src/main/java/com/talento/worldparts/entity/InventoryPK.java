package com.talento.worldparts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "WAREHOUSE_ID")
	private long warehouseId;

	public InventoryPK() {
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}

}
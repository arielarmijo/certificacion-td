package com.talento.certificacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORIES")
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected InventoryPK inventoryPK;

	@Column(name = "QUANTITY")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "WAREHOUSE_ID", insertable = false, updatable = false)
	private Warehouse warehouse;

	public Inventory() {
	}

	public InventoryPK getInventoryPK() {
		return inventoryPK;
	}

	public void setInventoryPK(InventoryPK inventoryPK) {
		this.inventoryPK = inventoryPK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
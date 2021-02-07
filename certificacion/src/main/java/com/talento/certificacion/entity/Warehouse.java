package com.talento.certificacion.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "WAREHOUSES")
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "WAREHOUSE_ID")
	private long id;

	@Column(name = "WAREHOUSE_NAME")
	private String name;

	@Column(name = "LOCATION_ID")
	private long locationId;

	@JsonIgnore
	@OneToMany(mappedBy = "warehouse")
	private Set<Inventory> inventories;

	public Warehouse() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public Set<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

}
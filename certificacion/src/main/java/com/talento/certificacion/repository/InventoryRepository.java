package com.talento.certificacion.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.certificacion.entity.Inventory;
import com.talento.certificacion.entity.Product;
import com.talento.certificacion.entity.Warehouse;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

		List<Inventory> findByWarehouseInAndProductIn(Collection<Warehouse> warehouses, Collection<Product> products, Sort sort);

}

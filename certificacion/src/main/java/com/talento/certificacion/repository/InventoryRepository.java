package com.talento.certificacion.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.certificacion.entity.Inventory;
import com.talento.certificacion.entity.Product;
import com.talento.certificacion.entity.Warehouse;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

		Page<Inventory> findByWarehouseInAndProductIn(Collection<Warehouse> warehouses, Collection<Product> products, Pageable pageable);

}

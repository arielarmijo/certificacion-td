package com.talento.worldparts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.talento.worldparts.entity.Inventory;
import com.talento.worldparts.entity.Product;
import com.talento.worldparts.entity.ProductCategory;
import com.talento.worldparts.entity.Warehouse;
import com.talento.worldparts.exception.ProductCategoryNotFoundException;
import com.talento.worldparts.exception.WarehouseNotFoundException;
import com.talento.worldparts.repository.InventoryRepository;
import com.talento.worldparts.repository.ProductCategoryRepository;
import com.talento.worldparts.repository.ProductRepository;
import com.talento.worldparts.repository.WarehouseRepository;

@Service
public class WorldPartsService {

	@Autowired
	private ProductRepository pRepo;

	@Autowired
	private ProductCategoryRepository pcRepo;

	@Autowired
	private WarehouseRepository whRepo;

	@Autowired
	private InventoryRepository iRepo;

	public List<ProductCategory> buscarCategoriasProducto() {
		return pcRepo.findAllByOrderByName();
	}

	public List<Warehouse> buscarAlmacenes() {
		return whRepo.findAllByOrderByName();
	}
	
	public Page<Inventory> buscarProduductosInventario(Pageable pageable) {
		return iRepo.findAll(pageable);
	}

	public Page<Inventory> filtrarProductosInventario(long categoriaProductoId, long almacenId, Pageable pageable) {

		List<Product> products = null;
		if (categoriaProductoId == 0) {
			products = pRepo.findAll();
		} else {
			ProductCategory pc = pcRepo.findById(categoriaProductoId).orElseThrow(() -> new ProductCategoryNotFoundException(categoriaProductoId));
			products = new ArrayList<>(pc.getProducts());
		}

		List<Warehouse> warehouses = null;
		if (almacenId == 0) {
			warehouses = whRepo.findAll();
		} else {
			warehouses = new ArrayList<>();
			warehouses.add(whRepo.findById(almacenId).orElseThrow(() -> new WarehouseNotFoundException(almacenId)));
		}

		return iRepo.findByWarehouseInAndProductIn(warehouses, products, pageable);

	}

	public Product buscarProductoPorId(long id) {
		return pRepo.findById(id).orElse(null);
	}

	public Warehouse buscarAlmacenPorId(long id) {
		return whRepo.findById(id).orElse(null);
	}

	public ProductCategory buscarCategoriaProductoPorId(long id) {
		return pcRepo.findById(id).orElse(null);
	}

}

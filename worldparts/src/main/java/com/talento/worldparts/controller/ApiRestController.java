package com.talento.worldparts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talento.worldparts.entity.Inventory;
import com.talento.worldparts.entity.ProductCategory;
import com.talento.worldparts.entity.Warehouse;
import com.talento.worldparts.service.WorldPartsService;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	@Autowired
	private WorldPartsService wpService;
	

	@GetMapping("/almacenes")
	List<Warehouse> mostrarAlmacenes() {
		return wpService.buscarAlmacenes();
	}

	@GetMapping("/categorias")
	List<ProductCategory> mostrarCategorias() {
		return wpService.buscarCategoriasProducto();
	}
	
	@GetMapping("/inventario")
	List<Inventory> mostrarInventario(@RequestParam(defaultValue = "0") long warehouseId,
									  @RequestParam(defaultValue = "0") long productCategoryId,
									  @RequestParam(defaultValue = "0") int page,
									  @RequestParam(defaultValue = "product.name") String sortBy) {
		Pageable pageRequest = PageRequest.of(page, 10, Sort.by(sortBy));
		Page<Inventory> inventoryPages = wpService.filtrarProductosInventario(productCategoryId, warehouseId, pageRequest);
		return inventoryPages.getContent();
	}

}

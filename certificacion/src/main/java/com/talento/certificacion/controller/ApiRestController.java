package com.talento.certificacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talento.certificacion.entity.Inventory;
import com.talento.certificacion.entity.ProductCategory;
import com.talento.certificacion.entity.Warehouse;
import com.talento.certificacion.service.WorldPartsService;

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
	List<Inventory> mostrarInventario(@RequestParam(defaultValue = "0") long almacenId,
									  @RequestParam(defaultValue = "0") long categoriaProductoId,
									  @RequestParam(defaultValue = "product.name") String sortBy) {
		return wpService.filtrarProductosInventario(categoriaProductoId, almacenId, sortBy);
	}

}

package com.talento.certificacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.talento.certificacion.entity.Inventory;
import com.talento.certificacion.entity.ProductCategory;
import com.talento.certificacion.entity.Warehouse;
import com.talento.certificacion.service.WorldPartsService;

@Controller
public class WebController {
	
	private String titulo = "World Parts";
	
	private static Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	private WorldPartsService wpServicio;
	
	@ModelAttribute("titulo")
	public String setAttributes() {
		return titulo;
	}

	@GetMapping("/")
	public String mostrarMonitorProductos(@RequestParam(defaultValue = "0") long almacenId,
										  @RequestParam(defaultValue = "0") long categoriaProductoId,
										  @RequestParam(defaultValue = "product.name") String sortBy,
										  Model model) {
		List<Warehouse> warehouses = wpServicio.buscarAlmacenes();
		List<ProductCategory> productCategories = wpServicio.buscarCategoriasProducto();
		List<Inventory> inventories = wpServicio.filtrarProductosInventario(categoriaProductoId, almacenId, sortBy);
		model.addAttribute("warehouses", warehouses);
		model.addAttribute("warehouseId", almacenId);
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("productCategoryId", categoriaProductoId);
		model.addAttribute("inventario", inventories);
		logger.info("Almacen: {}, categoria: {}, productos: {}", almacenId == 0 ? "Todos" : wpServicio.buscarAlmacenPorId(almacenId).getName(),
																categoriaProductoId == 0 ? "Todos" : wpServicio.buscarCategoriaProductoPorId(categoriaProductoId).getName(),
																inventories.size());
		return "listado-productos";
	}
	
	@GetMapping("/product")
	public String mostrarFichaProducto(@RequestParam long id, Model model) {
		model.addAttribute("producto", wpServicio.buscarProductoPorId(id));
		return "ficha-producto";
	}
	
}

package com.talento.certificacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public String mostrarMonitorProductos(@RequestParam(defaultValue = "0")  long warehouseId,
										  @RequestParam(defaultValue = "0") long productCategoryId,
										  @RequestParam(defaultValue = "0") int page,
										  @RequestParam(defaultValue = "product.id") String sortBy,
										  Model model) {
		List<Warehouse> warehouses = wpServicio.buscarAlmacenes();
		List<ProductCategory> productCategories = wpServicio.buscarCategoriasProducto();
		Pageable pageRequest = PageRequest.of(page, 10, Sort.by(sortBy));
		Page<Inventory> inventoryPages = wpServicio.filtrarProductosInventario(productCategoryId, warehouseId, pageRequest);
		List<Inventory> inventories =  inventoryPages.getContent();
		int delta = 5;
		int totalPages = inventoryPages.getTotalPages();
		int startPage = delta * ((int) page / delta);
		int endPage =  page <= totalPages - delta ? startPage + delta - 1 : totalPages - 1;
		model.addAttribute("warehouseId", warehouseId);
		model.addAttribute("productCategoryId", productCategoryId);
		model.addAttribute("startPage", startPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("warehouses", warehouses);
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("inventories", inventories);
		logger.info("Almacen: {}, categoria: {}, productos: {}, pagina: {}/{}", warehouseId == 0 ? "Todos" : wpServicio.buscarAlmacenPorId(warehouseId).getName(),
																productCategoryId == 0 ? "Todos" : wpServicio.buscarCategoriaProductoPorId(productCategoryId).getName(),
																inventoryPages.getTotalElements(), page, totalPages);
		return "listado-productos";
	}
	
	@GetMapping("/product")
	public String mostrarFichaProducto(@RequestParam long id, Model model) {
		model.addAttribute("producto", wpServicio.buscarProductoPorId(id));
		return "ficha-producto";
	}
	
}

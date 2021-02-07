package com.talento.certificacion.service;

import java.util.List;

import com.talento.certificacion.entity.Inventory;
import com.talento.certificacion.entity.Product;
import com.talento.certificacion.entity.ProductCategory;
import com.talento.certificacion.entity.Warehouse;

public interface WorldPartsService {
	
	List<ProductCategory> buscarCategoriasProducto();
	List<Warehouse> buscarAlmacenes();
	List<Inventory> filtrarProductosInventario(long categoriaProductoId, long almacenId, String sortBy);
	Product buscarProductoPorId(long id);
	Warehouse buscarAlmacenPorId(long id);
	ProductCategory buscarCategoriaProductoPorId(long id);

}

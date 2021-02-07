package com.talento.certificacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.talento.certificacion.entity.Inventory;
import com.talento.certificacion.entity.Product;
import com.talento.certificacion.entity.ProductCategory;
import com.talento.certificacion.entity.Warehouse;
import com.talento.certificacion.exception.ProductCategoryNotFoundException;
import com.talento.certificacion.exception.WarehouseNotFoundException;
import com.talento.certificacion.repository.InventoryRepository;
import com.talento.certificacion.repository.ProductCategoryRepository;
import com.talento.certificacion.repository.ProductRepository;
import com.talento.certificacion.repository.WarehouseRepository;

@Service
public class WorldPartsServiceImpl implements WorldPartsService {

	//private static final Logger logger = LoggerFactory.getLogger(WorldPartsServiceImpl.class);

	@Autowired
	private ProductRepository pRepo;

	@Autowired
	private ProductCategoryRepository pcRepo;

	@Autowired
	private WarehouseRepository whRepo;

	@Autowired
	private InventoryRepository iRepo;

	@Override
	public List<ProductCategory> buscarCategoriasProducto() {
		return pcRepo.findAllByOrderByName();
	}

	@Override
	public List<Warehouse> buscarAlmacenes() {
		return whRepo.findAllByOrderByName();
	}

	@Override
	public List<Inventory> filtrarProductosInventario(long categoriaProductoId, long almacenId, String sortBy) {

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

		return iRepo.findByWarehouseInAndProductIn(warehouses, products, Sort.by(Sort.Direction.ASC, sortBy));

	}

	@Override
	public Product buscarProductoPorId(long id) {
		return pRepo.findById(id).orElse(null);
	}

	@Override
	public Warehouse buscarAlmacenPorId(long id) {
		return whRepo.findById(id).orElse(null);
	}

	@Override
	public ProductCategory buscarCategoriaProductoPorId(long id) {
		return pcRepo.findById(id).orElse(null);
	}

}

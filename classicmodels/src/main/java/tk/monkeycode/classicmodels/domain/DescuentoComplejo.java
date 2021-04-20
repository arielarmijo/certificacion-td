package tk.monkeycode.classicmodels.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescuentoComplejo implements Descuento {
	
	private static final Logger logger = LoggerFactory.getLogger(DescuentoComplejo.class);
	private static final DescuentoSimple dcto15 = new DescuentoSimple(0.15);
	private static final DescuentoSimple dcto10 = new DescuentoSimple(0.10);
	private static final DescuentoSimple dcto5 = new DescuentoSimple(0.05);
	

	/**
	 * Calcula el monto total de descuento a aplicar sobre el total de una lista de precios.
	 * Se asume que cada precio es de 1 producto.
	 * A cada precio mayor a $5.000 se aplica un descuento del 10%. Si la suma de todos los
	 * precios supera los $20.000, se aplica un 15% a cada producto.
	 * Se aplica un 5% de descuento a los precios menores o iguales a $3.500.
	 * Los precios mayores a $3.500 y  menores o iguales a $5.000 no se les aplica descuento.
	 * @param precios Lista de precios
	 * @return Monto total del descuento a aplicar
	 */
	@Override
	public int calcularDescuento(List<Precio> precios) {
		
		if (precios == null) {
			logger.info("Lista de precios nula");
			return 0;
		}
		
		// Calcula total de la lista de precios
		int precioTotal = calcularTotal(precios);
		logger.debug("Precio total: {}", precioTotal);
		
		// Separa los tipos de precios
		Map<CategoriaPrecio, List<Precio>> preciosClasificados = precios.stream().collect(Collectors.groupingBy(precio -> clasificarPrecio(precio.getPrecio())));
		logger.debug("Clasificacion de precios: {}", preciosClasificados);
		
		// Calcula descuentos
		BigDecimal dctoPreciosBajos = dcto5.calcularDescuentoExacto(preciosClasificados.get(CategoriaPrecio.BAJO));
		BigDecimal sinDcto = BigDecimal.valueOf(calcularTotal(preciosClasificados.get(CategoriaPrecio.SIN_DCTO)));
		BigDecimal dctoPreciosAltos = (precioTotal > 20000) ? dcto15.calcularDescuentoExacto(preciosClasificados.get(CategoriaPrecio.ALTO)) : dcto10.calcularDescuentoExacto(preciosClasificados.get(CategoriaPrecio.ALTO));
		logger.debug("dctoPreciosAltos: {}", dctoPreciosAltos);
		logger.debug("dctoPreciosBajos: {}", dctoPreciosBajos);
		logger.debug("sinDcto: {}", sinDcto);
		
		// Calcula total de descuentos
		return dctoPreciosAltos.add(dctoPreciosBajos).add(sinDcto).setScale(0, RoundingMode.HALF_UP).intValue();

	}
	
	private CategoriaPrecio clasificarPrecio(int precio) {
		CategoriaPrecio category = CategoriaPrecio.NEGATIVO;
		if (precio > 0 && precio <= 3500) {
			category = CategoriaPrecio.BAJO;
		} else if (precio > 3500 && precio <= 5000) {
			category = CategoriaPrecio.SIN_DCTO;
		} else {
			category = CategoriaPrecio.ALTO;
		}
		logger.debug("Precio {} > {}", precio, category);
		return category;
	}

}

package tk.monkeycode.classicmodels.domain;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescuentoSimple implements Descuento {
	
	private static final Logger logger = LoggerFactory.getLogger(DescuentoSimple.class);
	
	private BigDecimal dcto;
	
	public DescuentoSimple() {
		this(0.1);
	}
	
	public DescuentoSimple(double dcto) {
		this.dcto = BigDecimal.valueOf(dcto);
	}
	
	/**
	 * Calcula el monto total de descuento a aplicar sobre el total de una lista de precios.
	 * Se asume que cada precio es de 1 producto. El descuento aplicado es del 10% en cada caso.
	 * @param precios Lista de precios
	 * @return Monto total del descuento a aplicar
	 */
	@Override
	public int calcularDescuento(List<Integer> precios) {

		// Problemas de coma flotante
//		float totalDcto = 0;
//		for (Integer precio : precios) {
//			totalDcto += precio * dcto;
//			logger.info("{} * {} = {}; {}", precio, dcto, precio*dcto, totalDcto);
//		}
//		return Integer.valueOf((int)totalDcto);
		
		// Sin problemas de coma flotante
//		BigDecimal totalDcto = BigDecimal.ZERO;
//		for (Integer precio : precios) {
//			BigDecimal parcialDcto = BigDecimal.valueOf(precio.longValue()).multiply(BigDecimal.valueOf(dcto)); //.setScale(10, RoundingMode.HALF_UP);
//			totalDcto = totalDcto.add(parcialDcto);
//			logger.info("{} * {} = {}; {}", precio, dcto, parcialDcto, totalDcto);
//		}
//		totalDcto = totalDcto.setScale(0, RoundingMode.HALF_UP);
//		return Integer.valueOf(totalDcto.intValue());
		
		// Calcula descuento total usando la suma de los precios
//		BigDecimal totalDcto = BigDecimal.ZERO;
//		int precioTotal = 0;
//		for (Integer precio : precios) {
//			precioTotal += precio; // auto unboxing
//		}
//		totalDcto = BigDecimal.valueOf(precioTotal).multiply(BigDecimal.valueOf(dcto)).setScale(0, RoundingMode.HALF_UP);
//		logger.info("Precio total: {}; Descuento total: {}", precioTotal, totalDcto);
//		return Integer.valueOf(totalDcto.intValue());
		
		// Usando API Stream para calcular el precio total sin descuento
//		int precioTotal = precios.stream().mapToInt(precio -> precio.intValue()).sum();
//		BigDecimal totalDcto = BigDecimal.valueOf(precioTotal).multiply(BigDecimal.valueOf(dcto)).setScale(0, RoundingMode.HALF_UP);
//		logger.debug("Precio total: {}; Descuento total: {}", precioTotal, totalDcto);
//		return totalDcto.intValue();
		
		// Usando API Stream para calcular el descuento de cada precio
//		return precios.stream().map(precio -> BigDecimal.valueOf(precio).multiply(BigDecimal.valueOf(dcto)))
//							   .peek(precio -> logger.info("{}", precio))
//							   .reduce(BigDecimal.ZERO, (total, precio) -> total.add(precio)).intValue());
		
		try {
			double totalDcto = precios.stream().mapToDouble(precio -> BigDecimal.valueOf(precio).multiply(dcto).doubleValue())
											   .peek(precio -> logger.debug("Dcto {}: {}", dcto, precio))
											   .sum();
			return (int) Math.round(totalDcto);
		} catch (NullPointerException e) {
			logger.info("Lista de precios nula");
			return 0;
		}

	}
	
	public BigDecimal calcularDescuentoExacto(List<Integer> precios) {
		try {
		return precios.stream().map(precio -> BigDecimal.valueOf(precio).multiply(dcto))
							   .peek(precio -> logger.debug("Dcto {}: {}", dcto, precio))
							   .reduce(BigDecimal.ZERO, (total, precio) -> total.add(precio));
		} catch (NullPointerException e) {
			logger.info("Lista de precios nula");
			return BigDecimal.ZERO;
		}
	}

}

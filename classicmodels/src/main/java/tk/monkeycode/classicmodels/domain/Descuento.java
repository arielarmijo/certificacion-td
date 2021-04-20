package tk.monkeycode.classicmodels.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Descuento {
	
	Logger logger = LoggerFactory.getLogger(Descuento.class);

	int calcularDescuento(List<Integer> precios);
	
	default int calcularTotal(List<Integer> precios) {
		try {
			return precios.stream().mapToInt(precio -> precio.intValue()).sum();
		} catch (NullPointerException e) {
			logger.debug("Lista de precios nula");
			return 0;
		}
	}
	
}

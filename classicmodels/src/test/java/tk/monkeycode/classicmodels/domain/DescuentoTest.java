package tk.monkeycode.classicmodels.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DescuentoTest {
	
	private Descuento dcto = new DescuentoSimple();

	@Test
	void testCalcularTotal() {
		List<Precio> precios = GeneradorPrecios.generarPreciosCaso();
		assertEquals(30300, dcto.calcularTotal(precios));
	}
	
	@Test
	void testCalcularTotalListaNula() {
		List<Precio> precios = null;
		assertEquals(0, dcto.calcularTotal(precios));
	}
	
	@Test
	void testCalcularTotalListaVacia() {
		List<Precio> precios = new ArrayList<>();
		assertEquals(0, dcto.calcularTotal(precios));
	}


}

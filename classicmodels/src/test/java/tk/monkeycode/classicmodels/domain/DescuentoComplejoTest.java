package tk.monkeycode.classicmodels.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DescuentoComplejoTest {
	
	private Descuento dcto = new DescuentoComplejo();

	@Test
	void testCalcularDescuento() {
		List<Precio> precios = GeneradorPrecios.generarPreciosCaso();
		int dctoEsperado = 3968;
		int dctoObtenido = dcto.calcularDescuento(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	@Test
	void testCalcularDescuentoListaPreciosVacia() {
		List<Precio> precios = new ArrayList<>();
		int dctoEsperado = 0;
		int dctoObtenido = dcto.calcularDescuento(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	@Test
	void testCalcularDescuentoListaPreciosNulo() {
		List<Precio> precios = null;
		int dctoEsperado = 0;
		int dctoObtenido = dcto.calcularDescuento(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}

}

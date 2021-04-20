package tk.monkeycode.classicmodels.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DescuentoSimpleTest {
	
	private DescuentoSimple dcto = new DescuentoSimple();

	@Test
	void testCalcularDescuento() {
		List<Integer> precios = GeneradorPrecios.generarPreciosCaso();
		int dctoEsperado = 3030;
		int dctoObtenido = dcto.calcularDescuento(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	@Test
	void testCalcularDescuentoListaPreciosVacia() {
		List<Integer> precios = new ArrayList<>();
		int dctoEsperado = 0;
		int dctoObtenido = dcto.calcularDescuento(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	@Test
	void testCalcularDescuentoListaPreciosNulo() {
		List<Integer> precios = null;
		int dctoEsperado = 0;
		int dctoObtenido = dcto.calcularDescuento(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}

	@Test
	void testCalcularDescuentoExacto() {
		List<Integer> precios = GeneradorPrecios.generarPreciosCaso();
		BigDecimal dctoEsperado = BigDecimal.valueOf(3030.0);
		BigDecimal dctoObtenido = dcto.calcularDescuentoExacto(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	@Test
	void testCalcularDescuentoExactoListaPreciosVacia() {
		List<Integer> precios = new ArrayList<>();
		BigDecimal dctoEsperado = BigDecimal.valueOf(0);
		BigDecimal dctoObtenido = dcto.calcularDescuentoExacto(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	@Test
	void testCalcularDescuentoExactoListaPreciosNulo() {
		List<Integer> precios = null;
		BigDecimal dctoEsperado = BigDecimal.valueOf(0);
		BigDecimal dctoObtenido = dcto.calcularDescuentoExacto(precios);
		assertEquals(dctoEsperado, dctoObtenido);
	}
	
	
	// Que pasa con los precios negativos?: Hacer una clase precio que implemente la restriccion.

}

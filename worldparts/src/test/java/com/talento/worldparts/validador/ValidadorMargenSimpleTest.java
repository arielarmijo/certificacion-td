package com.talento.worldparts.validador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ValidadorMargenSimpleTest {

	@Test
	void testObtenerMargenNormal() {
		double precio = 150;
		double costo = 100;
		ValidadorMargen validador = new ValidadorMargenSimple();
		
		assertEquals((precio-costo)/precio, validador.obtenerMargen(precio, costo));
	}
	
	@Test
	void testObtenerMargenPrecioCero() {
		double precio = 0;
		double costo = 100;
		ValidadorMargen validador = new ValidadorMargenSimple();
		assertEquals((precio-costo)/precio, validador.obtenerMargen(precio, costo));
	}
	
	@Test
	void testObtenerMargenPrecioIgualCosto() {
		double precio = 100;
		double costo = 100;
		ValidadorMargen validador = new ValidadorMargenSimple();
		assertEquals((precio-costo)/precio, validador.obtenerMargen(precio, costo));
	}
	
	@Test
	void testObtenerMargenCostoCero() {
		double precio = 150;
		double costo = 0;
		ValidadorMargen validador = new ValidadorMargenSimple();
		assertEquals((precio-costo)/precio, validador.obtenerMargen(precio, costo));
	}
	
	@Test
	void testObtenerMargenCostoCeroPrecioCero() {
		double precio = 0;
		double costo = 0;
		ValidadorMargen validador = new ValidadorMargenSimple();
		assertEquals((precio-costo)/precio, validador.obtenerMargen(precio, costo));
	}
	
	@Test
	void testValidarMargenOk() {
		double precio = 150;
		double costo = 100;
		ValidadorMargen validador = new ValidadorMargenSimple();
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenAlerta() {
		double precio = 150;
		double costo = 140;
		ValidadorMargen validador = new ValidadorMargenSimple();
		assertEquals(ValidadorMargen.ALERTA, validador.validar(precio, costo));
	}

}

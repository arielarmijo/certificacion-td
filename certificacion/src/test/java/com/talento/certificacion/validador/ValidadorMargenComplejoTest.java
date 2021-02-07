package com.talento.certificacion.validador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ValidadorMargenComplejoTest {
	
	private ValidadorMargen validador = new ValidadorMargenComplejo();

	// Margen mayor a cero%
	@Test
	void testValidarMargenMayorMin() {
		double margen = 0.25;
		double precio = 150;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenIgualMin() {
		double margen = 0.1;
		double precio = 150;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenMenorMinMayorCero() {
		double margen = 0.05;
		double precio = 150;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ALERTA, validador.validar(precio, costo));
	}
	
	// Margenes igual a cero%
	@Test
	void testValidarMargenIgualCero() {
		double margen = 0;
		double precio = 150;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ALERTA, validador.validar(precio, costo));
	}
	
	// Margen menor a cero%
	@Test
	void testValidarMargenMenorCero() {
		double margen = -0.1;
		double precio = 150;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ERROR, validador.validar(precio, costo));
	}
	
	// Margen mayor a 100%
	@Test
	void testValidarMargenMayorCienPrecioMayorMil() {
		double margen = 1.2;
		double precio = 1500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ADVERTENCIA, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenMayorCienPrecioIgualMil() {
		double margen = 1.2;
		double precio = 1000;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ADVERTENCIA, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenMayorCienPrecioMenorMil() {
		double margen = 1.2;
		double precio = 500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ADVERTENCIA, validador.validar(precio, costo));
	}
	
	// Margen igual a 100%
	@Test
	void testValidarMargenIgualCienPrecioMayorMil() {
		double margen = 1;
		double precio = 1500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenIgualCienPrecioIgualMil() {
		double margen = 1;
		double precio = 1000;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenIgualCienPrecioMenorMil() {
		double margen = 1;
		double precio = 500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.ADVERTENCIA, validador.validar(precio, costo));
	}
	
	// Margen igual 50%
	@Test
	void testValidarMargenIgual50PrecioMayorMil() {
		double margen = 0.5;
		double precio = 1500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenIgual50PrecioIgualMil() {
		double margen = 0.5;
		double precio = 1000;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenIgual50PrecioMenorMil() {
		double margen = 0.5;
		double precio = 500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	// Margen menor a 50%
	@Test
	void testValidarMargenMenor50PrecioMayorMil() {
		double margen = 0.25;
		double precio = 1500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenMenor50PrecioIgualMil() {
		double margen = 0.25;
		double precio = 1000;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}
	
	@Test
	void testValidarMargenMenor50PrecioMenorMil() {
		double margen = 0.25;
		double precio = 500;
		double costo = precio * (1 - margen);
		assertEquals(ValidadorMargen.OK, validador.validar(precio, costo));
	}

}

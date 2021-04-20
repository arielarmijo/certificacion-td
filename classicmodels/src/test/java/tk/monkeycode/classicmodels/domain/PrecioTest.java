package tk.monkeycode.classicmodels.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrecioTest {

	@Test
	void testPrecioMayorCero() {
		Precio precio = new Precio(1000);
		int precioEsperado = 1000;
		int precioObtenido = precio.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	void testPrecioMayorIgualCero() {
		Precio precio = new Precio(0);
		int precioEsperado = 0;
		int precioObtenido = precio.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	void testPrecioMayorMenorCero() {
		assertThrows(IllegalArgumentException.class, () -> new Precio(-1));
	}

}

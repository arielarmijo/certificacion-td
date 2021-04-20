package tk.monkeycode.classicmodels;

import java.util.List;

import tk.monkeycode.classicmodels.domain.Descuento;
import tk.monkeycode.classicmodels.domain.DescuentoComplejo;
import tk.monkeycode.classicmodels.domain.DescuentoSimple;
import tk.monkeycode.classicmodels.domain.GeneradorPrecios;
import tk.monkeycode.classicmodels.domain.Precio;

public class DemoConsola {
	
	public static void main(String[] args) {
		
		// Mustra cabecera
		System.out.println("\n");
		System.out.println("--------------------------------------");
		System.out.println("Demostracion Calculadora de Descuentos");
		System.out.println("--------------------------------------");
		System.out.println();

		// Genera y muestra 5 precios aleatorios
		System.out.println("Tomando 5 precios aleatorios...");
		List<Precio> precios = GeneradorPrecios.generarPreciosCaso();
//		List<Integer> precios = GeneradorPrecios.generarPreciosAleatorios(5, 1000, 10000);
		precios.forEach(precio -> System.out.print(String.format("$%,d ", precio.getPrecio())));
		System.out.println("\n");

		// Descuentos
		Descuento dctoSimple = new DescuentoSimple();
		Descuento dctoComplejo = new DescuentoComplejo();
		System.out.println(String.format("Descuento con Algoritmo Simple: $%,d", dctoSimple.calcularDescuento(precios)));
		System.out.println(String.format("Descuento con Algoritmo Complejo: $%,d", dctoComplejo.calcularDescuento(precios)));
		System.out.println("\n");

	}

}

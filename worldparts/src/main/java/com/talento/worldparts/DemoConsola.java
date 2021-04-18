package com.talento.worldparts;

import com.talento.worldparts.validador.ValidadorMargen;
import com.talento.worldparts.validador.ValidadorMargenComplejo;
import com.talento.worldparts.validador.ValidadorMargenSimple;

public class DemoConsola {

	public static void main(String[] args) {

		mostrarValidaciones(5, new ValidadorMargenSimple(), new ValidadorMargenComplejo());
		
	}
	
	private static void mostrarValidaciones(int n, ValidadorMargen... validadores) {
		System.out.println("\nDemostracion algoritmo verificacion margen");
		for (int i = 1; i <= n; i++) {
			double precio = generarNumeroAleatoreo(200, 2000);
			double costo = generarNumeroAleatoreo(200, 2000);
			double margen = validadores[0].obtenerMargen(precio, costo)*100;
			System.out.printf("%n%d. Precio $%.2f, Costo $%.2f, margen %.2f%%%n", i, precio, costo, margen);
			for (int j = 0; j < validadores.length; j++) {
				mostrarValidacion(validadores[j], precio, costo);
			}
		}
	}
	
	private static void mostrarValidacion(ValidadorMargen v, double precio, double costo) {
		System.out.printf("Algoritmo %s: %s%n", v.tipo(), v.validar(precio, costo));
	}

	private static double generarNumeroAleatoreo(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	
}

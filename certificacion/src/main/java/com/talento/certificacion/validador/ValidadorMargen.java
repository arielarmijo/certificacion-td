package com.talento.certificacion.validador;

public interface ValidadorMargen {
	
	String OK = "MARGEN OK";
	String ALERTA = "ALERTA MARGEN BAJO MINIMO";
	String ADVERTENCIA = "ADVERTENCIA POSIBLE ERROR EN COSTO";
	String ERROR = "ERROR MARGEN NEGATIVO";

	double MARGEN_MIN = 0.1;
	
	String validar(double precio, double costo);
	String tipo();
	
	default double obtenerMargen(double precio, double costo) {
		return (precio - costo)/ precio;
	}
	
}

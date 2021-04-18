package com.talento.worldparts.validador;

public class ValidadorMargenSimple implements ValidadorMargen {

	@Override
	public String validar(double precio, double costo) {
		double margen = obtenerMargen(precio, costo);
		return margen >= MARGEN_MIN ? OK : ALERTA;
	}
	
	@Override
	public String tipo() {
		return "Simple";
	}

}

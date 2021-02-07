package com.talento.certificacion.validador;

public class ValidadorMargenComplejo implements ValidadorMargen {
	
	private static ValidadorMargen validador;
	
	public ValidadorMargenComplejo() {
		validador = new ValidadorMargenSimple();
	}
	

	@Override
	public String validar(double precio, double costo) {
		
		double margen = obtenerMargen(precio, costo);

		if (margen < 0) {
			return ERROR;
		}
		
		if ((margen > 1 && precio >= 1000) || (margen > 0.5 && precio < 1000)) {
			return ADVERTENCIA;
		}
		
		return validador.validar(precio, costo);
		
	}
	
	@Override
	public String tipo() {
		return "Complejo";
	}

}

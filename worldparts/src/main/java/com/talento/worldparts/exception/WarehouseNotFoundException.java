package com.talento.worldparts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Almacen no existe")
public class WarehouseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WarehouseNotFoundException(long id) {
		super("Almacen ID " + id + " no exites.");
	}
	
	
}

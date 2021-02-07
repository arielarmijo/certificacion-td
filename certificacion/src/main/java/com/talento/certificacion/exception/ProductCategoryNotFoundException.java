package com.talento.certificacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Categoria producto no existe")
public class ProductCategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductCategoryNotFoundException(long id) {
		super("Categoria producto " + id + " no existe.");
	}

}

package com.rehmanmsit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

/**
 *
 * @author Rehman
 *
 */

public class CustomUnProcessableEntity extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomUnProcessableEntity(HttpStatus status, Errors errors) {
		this.status = status;
		this.errors = errors;
	}

	private HttpStatus status;

	private Errors errors;

	public HttpStatus getStatus() {
		return status;
	}

	public Errors getErrors() {
		return errors;
	}

}

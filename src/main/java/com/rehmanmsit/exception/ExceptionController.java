package com.rehmanmsit.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Rehman
 *
 */

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = CustomUnProcessableEntity.class)
	public ResponseEntity<RestError> handleCustomUnProcessableEntity(CustomUnProcessableEntity ex) {
		RestError restError = getRestError();
		List<Error> errors = new ArrayList<>();
		for(FieldError error : ex.getErrors().getFieldErrors()) {
			Error err = new Error();
			err.setStatus(ex.getStatus().value());
			err.setError(error.getField());
			err.setDescription(error.getCode());
			errors.add(err);
		}
		restError.setErrors(errors);
		return new ResponseEntity<RestError>(restError, ex.getStatus());
	}

	private RestError getRestError() {
		RestError restError = new RestError();
		restError.setService("MY Service");
		return restError;
	}

}

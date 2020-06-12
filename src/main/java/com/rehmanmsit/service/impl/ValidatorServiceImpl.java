package com.rehmanmsit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.rehmanmsit.controller.vo.InitialPostRequestVO;
import com.rehmanmsit.exception.CustomUnProcessableEntity;
import com.rehmanmsit.service.ValidatorService;
import com.rehmanmsit.validator.InitialPostRequestValidator;

import reactor.core.publisher.Mono;

/**
 *
 * @author Rehman
 *
 */

@Service
public class ValidatorServiceImpl implements ValidatorService {
	
	@Autowired
	private InitialPostRequestValidator initialPostRequestValidator;
	
	@Override
	public Mono<InitialPostRequestVO> checkForValidation(InitialPostRequestVO request) {
		Errors errors = new BeanPropertyBindingResult(request, request.getClass().getName());
		initialPostRequestValidator.validate(request, errors);
		if (null != errors && !errors.getAllErrors().isEmpty()) {
			return Mono.error(new CustomUnProcessableEntity(HttpStatus.BAD_REQUEST, errors));
		}
		return Mono.just(request);
	}

}

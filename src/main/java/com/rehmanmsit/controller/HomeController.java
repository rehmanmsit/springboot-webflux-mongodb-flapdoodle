package com.rehmanmsit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rehmanmsit.controller.vo.InitialPostRequestVO;
import com.rehmanmsit.controller.vo.InitialPostResponseVO;
import com.rehmanmsit.service.ValidatorService;

import reactor.core.publisher.Mono;

/**
 *
 * @author Rehman
 *
 */


@RestController
public class HomeController {
	
	@Autowired
	private ValidatorService validatorService;
	
	@PostMapping(value = "/initialPostRequest",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<InitialPostResponseVO> handleInitialPostRequest(@RequestBody InitialPostRequestVO initialPostRequestVO) {

		return Mono.just(initialPostRequestVO)
				.flatMap(validatorService::checkForValidation)
				.flatMap(request -> {
					InitialPostResponseVO response = new InitialPostResponseVO();
					response.setMessage("Request passed through all validations.");
					return Mono.just(response);
				});
	}

}

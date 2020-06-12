package com.rehmanmsit.service;

import com.rehmanmsit.controller.vo.InitialPostRequestVO;

import reactor.core.publisher.Mono;

/**
 *
 * @author Rehman
 *
 */

public interface ValidatorService {

	Mono<InitialPostRequestVO> checkForValidation(InitialPostRequestVO request);

}

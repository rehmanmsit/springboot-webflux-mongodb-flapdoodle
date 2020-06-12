package com.rehmanmsit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rehmanmsit.controller.vo.InitialPostRequestVO;

/**
*
* @author Rehman
*
*/

@Component
public class InitialPostRequestValidator implements Validator {
	
	private static final String ERR_MSG = "Field Shouldn't be Null or Empty";
	
	@Autowired
	private AddressValidator addressValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return InitialPostRequestVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", ERR_MSG);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", ERR_MSG);
		
		InitialPostRequestVO initialPostRequest = (InitialPostRequestVO) target;
		
		errors.pushNestedPath("address");
		ValidationUtils.invokeValidator(addressValidator, initialPostRequest.getAddress(), errors);
		errors.popNestedPath();
		
	}

}

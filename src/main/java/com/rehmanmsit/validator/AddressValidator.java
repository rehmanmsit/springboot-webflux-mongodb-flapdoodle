package com.rehmanmsit.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rehmanmsit.controller.vo.AddressVO;

/**
*
* @author Rehman
*
*/

@Component
public class AddressValidator implements Validator {
	
	private static final String ERR_MSG = "Field Shouldn't be Null or Empty";

	@Override
	public boolean supports(Class<?> clazz) {
		return AddressVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", ERR_MSG);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", ERR_MSG);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", ERR_MSG);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", ERR_MSG);
	}

}

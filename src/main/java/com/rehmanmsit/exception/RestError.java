package com.rehmanmsit.exception;

import java.util.List;

import lombok.Data;

/**
*
* @author Rehman
*
*/

@Data
public class RestError {
	
	private String service;
	
	private List<Error> errors;
	
	

}

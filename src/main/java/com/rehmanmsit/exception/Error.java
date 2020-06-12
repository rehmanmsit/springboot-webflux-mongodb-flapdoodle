package com.rehmanmsit.exception;

import lombok.Data;

/**
 *
 * @author Rehman
 *
 */

@Data
public class Error {

	private int status;

	private String error;

	private String description;

}

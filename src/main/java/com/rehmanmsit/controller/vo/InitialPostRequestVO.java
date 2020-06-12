package com.rehmanmsit.controller.vo;

import lombok.Data;

/**
 *
 * @author Rehman
 *
 */

@Data
public class InitialPostRequestVO {

	private Long id;

	private String name;

	private Integer age;
	
	private AddressVO address;

}

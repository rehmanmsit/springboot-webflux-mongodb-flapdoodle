package com.rehmanmsit.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 *
 * @author Rehman
 *
 */

@Document
@Data
public class User {

	@Id
	private Long id;

	private String name;

	private Integer age;

	private Address address;

}

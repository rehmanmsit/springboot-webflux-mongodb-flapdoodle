package com.rehmanmsit.controller.vo;

import com.rehmanmsit.repository.entity.User;

import lombok.Data;

/**
*
* @author Rehman
*
*/

@Data
public class InitialPostResponseVO {
	
	private String message;
	
	private User user;

}

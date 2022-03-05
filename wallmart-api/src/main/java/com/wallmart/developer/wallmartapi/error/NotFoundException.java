package com.wallmart.developer.wallmartapi.error;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public class NotFoundException extends RuntimeException{

	public NotFoundException(String message) {
		super(message);
	}

}

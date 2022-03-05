package com.wallmart.developer.wallmartapi.error;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public class BadRequestException extends RuntimeException{

	public BadRequestException(String message) {
		super(message);
	}

}

package com.wallmart.developer.wallmartapi.error;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public class UnauthorizedException extends RuntimeException {

	public UnauthorizedException(String message) {
		super(message);
	}

}

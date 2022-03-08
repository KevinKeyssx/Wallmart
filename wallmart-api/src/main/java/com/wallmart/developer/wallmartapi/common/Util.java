package com.wallmart.developer.wallmartapi.common;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public class Util implements Serializable {

    private static final long serialVersionUID = 1L;

    public Util(Boolean value) {
        if (Boolean.FALSE.equals(value)) {
            throw new IllegalAccessError("Ilegal access.");
        }
    }

    public HttpStatus typeStatus(Object object){
        return object == null || object.toString().equals("[]") || object.toString().isBlank() ? 
            HttpStatus.NO_CONTENT: HttpStatus.OK;
    }

    public boolean isPalindrome(String cadena) {
		return new StringBuilder(cadena).reverse().toString().equals(cadena);
	}

    public boolean isLong(String value) {
        try{
            var myLong = Long.parseLong(value);
            System.out.println(myLong);
            return true;
        }
        catch (Exception e) {
            System.out.println("The input string does not represent a valid number");
            return false;
        }
    }

}

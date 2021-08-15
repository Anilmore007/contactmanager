package com.contact.manager.exception;

public class GenericException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericException(String message) {
         
		super(message);
	}
	
	public GenericException(String message, Throwable throwable) {
		
		super(message, throwable);
	}

}

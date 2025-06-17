package com.korayakben.taxup.exception;


public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(){
		
	}
	
	public BaseException(ErrorType exception_message) {
		super(exception_message.getException_message());
	}
	
	
}


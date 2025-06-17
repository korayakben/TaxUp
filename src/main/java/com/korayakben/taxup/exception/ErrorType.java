package com.korayakben.taxup.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorType {
	
	USERNAME_EXISTS("Username you entered already exists."),
	NULL_POINTER("Nothing found with the datas entered!"),
	CLIENT_NOT_FOUND("Client not found!"),
	PRODUCT_NOT_FOUND("Product not found!"),
	DB_CONTROL("Inappropriate field usage."),
	UNAUTHORIZED_ATTEMPT("Unauthorized attempt.");
	
	private String exception_message;

}

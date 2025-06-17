package com.korayakben.taxup.dto.exceptionDto;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationDto {

	private int status;
	
	private UUID id;
	
	private Date exception_date;
	
	private HashMap<String, String> errors;
}


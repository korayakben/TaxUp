package com.korayakben.taxup.dto.exceptionDto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDto {

	private int status;
	
	private UUID id;
	
	private Date date;
	
	private String exception_message;
	
}

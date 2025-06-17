package com.korayakben.taxup.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import com.korayakben.taxup.dto.exceptionDto.ValidationDto;


public class ValidationUtils {

	public static ValidationDto prepareValDto(ValidationDto valDto, HashMap<String, String> errMap) {
		valDto.setStatus(HttpStatus.BAD_REQUEST.value());
		valDto.setId(UUID.randomUUID());
		valDto.setException_date(new Date());
		valDto.setErrors(errMap);
		return valDto;
	}
	
}

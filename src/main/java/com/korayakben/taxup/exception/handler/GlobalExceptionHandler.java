package com.korayakben.taxup.exception.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.korayakben.taxup.dto.exceptionDto.ValidationDto;
import com.korayakben.taxup.dto.exceptionDto.ExceptionDto;
import com.korayakben.taxup.exception.BaseException;
import com.korayakben.taxup.exception.ErrorType;
import com.korayakben.taxup.utils.ValidationUtils;

@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	ResponseEntity<ValidationDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
	
		ValidationDto valDto = new ValidationDto();
		HashMap<String, String> errMap = new HashMap<>();
		
		for(ObjectError objErr: ex.getAllErrors()) {
			System.out.println(objErr.getDefaultMessage());
			String field_name = ((FieldError) objErr).getField();
			String err_message = objErr.getDefaultMessage();
			errMap.put(field_name, err_message);
		}
		
		return ResponseEntity.badRequest().body(ValidationUtils.prepareValDto(valDto, errMap));
	}
	
	
	@ExceptionHandler(value = BaseException.class)
	ResponseEntity<ExceptionDto> handleBaseException(BaseException ex) {
		ExceptionDto exDto = new ExceptionDto();
		String ex_message = ex.getMessage();
		exDto.setStatus(HttpStatus.BAD_REQUEST.value());
		exDto.setId(UUID.randomUUID());
		exDto.setDate(new Date());
		exDto.setException_message(ex_message);
		return ResponseEntity.badRequest().body(exDto);
	}
	
	
	@ExceptionHandler(value = NullPointerException.class)
	ResponseEntity<ExceptionDto> handleNullPointerException(NullPointerException ex) {
		ExceptionDto exDto = new ExceptionDto();
		exDto.setStatus(HttpStatus.BAD_REQUEST.value());
		exDto.setId(UUID.randomUUID());
		exDto.setDate(new Date());
		exDto.setException_message(ErrorType.NULL_POINTER.getException_message());
		return ResponseEntity.badRequest().body(exDto);
	}
	
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	ResponseEntity<ExceptionDto> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		ExceptionDto exDto = new ExceptionDto();
		exDto.setStatus(HttpStatus.BAD_REQUEST.value());
		exDto.setId(UUID.randomUUID());
		exDto.setDate(new Date());
		exDto.setException_message(ErrorType.DB_CONTROL.getException_message());
		return ResponseEntity.badRequest().body(exDto);
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	ResponseEntity<ExceptionDto> handleNoSuchElementException(NoSuchElementException ex) {
		ExceptionDto exDto = new ExceptionDto();
		exDto.setStatus(HttpStatus.BAD_REQUEST.value());
		exDto.setId(UUID.randomUUID());
		exDto.setDate(new Date());
		exDto.setException_message(ErrorType.CLIENT_NOT_FOUND.getException_message());
		return ResponseEntity.badRequest().body(exDto);
	}
	
}

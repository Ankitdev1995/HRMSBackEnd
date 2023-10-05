package com.ob.app.vendor.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public	Map<String, Object> handleMethodNotArgumentException(MethodArgumentNotValidException ex){

		Map<String, Object> map = new HashMap<>();
		BindingResult bs = 	ex.getBindingResult();
		List<FieldError> fieldErrors = bs.getFieldErrors();
		for(FieldError fieldError : fieldErrors ) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return map;
	}


	@ExceptionHandler(LocationNotFoundException.class)
	ResponseEntity<ErrorResponse> handleCompanyNameNotFoundException(LocationNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	@ExceptionHandler(DocumentNotFoundException.class)
	ResponseEntity<ErrorResponse> handleDocumentNotFoundException(DocumentNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
}	


package com.ob.app.company.exception;


import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CompanyGlobalExceptionHandler  {	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodNotArgumentExceptions(MethodArgumentNotValidException ex){
		
		HashMap<String, Object> map = new HashMap<>();
		
		BindingResult bs =  ex.getBindingResult();
		List<FieldError>  fieldErrors = bs.getFieldErrors();
		for(FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return map;             
	}
	
	
	
	@ExceptionHandler(CompanyNameNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCompanyNameNotFoundException(CompanyNameNotFoundException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleLocationNotFoundException(LocationNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value() , ex.getMessage());
		return  new ResponseEntity<ErrorResponse>(errorResponse ,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DesignationNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDesignationNotFoundException(DesignationNotFoundException ex){
	
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}	


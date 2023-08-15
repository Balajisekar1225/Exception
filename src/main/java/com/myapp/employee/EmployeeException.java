package com.myapp.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
	@ExceptionHandler (NameNotFoundException.class) 
	public ResponseEntity<Object> NameNotFoundHandling (NameNotFoundException n) {
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<Object> AgeNotFoundHandling (AgeNotFoundException n) {
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
	}

}

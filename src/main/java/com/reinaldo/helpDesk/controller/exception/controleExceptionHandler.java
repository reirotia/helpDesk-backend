package com.reinaldo.helpDesk.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reinaldo.helpDesk.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class controleExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandError> objectNotFoundException(ObjectNotFoundException ex, 
			HttpServletRequest request) {
		
		StandError error = new StandError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object not found"
				, ex.getMessage(), request.getRequestURI());	
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}

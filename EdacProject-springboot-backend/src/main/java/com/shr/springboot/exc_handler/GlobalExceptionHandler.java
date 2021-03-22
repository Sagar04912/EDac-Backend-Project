package com.shr.springboot.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shr.springboot.custom_exceptions.UsersHandlingException;
import com.shr.springboot.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UsersHandlingException.class)
	public ResponseEntity<?> handleCustomerHandlingException(UsersHandlingException e) {
		System.out.println("in cust hand exc "+e);
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), "details"), HttpStatus.UNAUTHORIZED);
	}
}

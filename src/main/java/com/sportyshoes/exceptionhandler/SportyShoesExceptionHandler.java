package com.sportyshoes.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.sportyshoes.exception.SportyShoesNotFoundException;


@ControllerAdvice
public class SportyShoesExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SportyShoesErrorResponse> handleException(Exception exc) {
		SportyShoesErrorResponse error = new SportyShoesErrorResponse();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<SportyShoesErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<SportyShoesErrorResponse> handleException(SportyShoesNotFoundException exc) {
		SportyShoesErrorResponse error = new SportyShoesErrorResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<SportyShoesErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

}
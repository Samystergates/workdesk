package com.project.task1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailNotFoundCustEx.class)
	public ResponseEntity<String> handlingEmailException(EmailNotFoundCustEx ex) {

		return new ResponseEntity<String>("User could not be found, " + ex.getMessage() + "Try another", HttpStatus.NOT_FOUND);

	}

}

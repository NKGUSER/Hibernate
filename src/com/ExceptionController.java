package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> exception(NotFoundException exception) {
	      return new ResponseEntity<>("World not found", HttpStatus.NOT_FOUND);
	   }
}

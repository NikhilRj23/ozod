package com.ozod.policy.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ozod.policy.dto.Error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Error> handleNotFound(UserNotFoundException ex) {
		Error error = new Error();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return ResponseEntity.status(404).body(error);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Error> handleBadRequest(IllegalArgumentException ex) {
		Error error = new Error();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(error);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Error> handleConstraintViolationException(ConstraintViolationException ex) {
		Error error = new Error();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			//String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			error.setMessage(message);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}

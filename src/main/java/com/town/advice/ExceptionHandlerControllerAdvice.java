package com.town.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.town.exception.ApplicationException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ApplicationException.class)
	public String handleApplicationException(ApplicationException ex) {
		return "error/app";
	}

	@ExceptionHandler(DataAccessException.class)
	public String handleDataAccessException(DataAccessException ex) {
		return "error/db";
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException ex) {
		return "error/unknown";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		return "error/unknown";
	}

}

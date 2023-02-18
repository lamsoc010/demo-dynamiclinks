package com.vinhlam.dynamiclinks.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidError.class)
	public Map<String, String> handleInvalidArgument(InvalidError ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", ex.getErrorResponse().getInvalidAgrument().getMessage());
		return errorMap;
	}
}

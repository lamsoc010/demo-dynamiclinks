package com.vinhlam.dynamiclinks.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidError extends Exception{
	private int code;
	private ErrorResponse errorResponse;
}

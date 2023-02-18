package com.vinhlam.dynamiclinks.exception;


import com.vinhlam.dynamiclinks.common.ErrorStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class InvalidAgrument {
	public int code;
	public String message;
	public ErrorStatus status;

}

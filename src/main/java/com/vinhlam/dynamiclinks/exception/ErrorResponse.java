package com.vinhlam.dynamiclinks.exception;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse{
	@SerializedName("error")
	public InvalidAgrument invalidAgrument;
}

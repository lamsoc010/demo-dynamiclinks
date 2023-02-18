package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicLinksNoParam {
	@SerializedName("longDynamicLink")
	private String longDynamicLink;
	@SerializedName("suffix")
	private Suffix suffix;
}

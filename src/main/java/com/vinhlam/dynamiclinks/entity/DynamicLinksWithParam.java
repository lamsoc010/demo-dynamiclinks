package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicLinksWithParam {

	@SerializedName("dynamicLinkInfo")
	private DynamicLinksInfo dynamicLinkInfo;
}
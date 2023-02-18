package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AndroidInfo {
	@SerializedName("androidPackageName")
	private String androidPackageName;
	@SerializedName("androidMinPackageVersionCode")
	private String androidMinPackageVersionCode;
	@SerializedName("androidFallbackLink")
	private String androidFallbackLink;
}

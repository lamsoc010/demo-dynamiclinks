package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialMetaTagInfo {
	@SerializedName("socialTitle")
	private String socialTitle;
	@SerializedName("socialDescription")
	private String socialDescription;
	@SerializedName("socialImageLink")
	private String socialImageLink;
}

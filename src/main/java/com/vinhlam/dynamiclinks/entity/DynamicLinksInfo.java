package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicLinksInfo {
	@SerializedName("domainUriPrefix")
	private String domainUriPrefix;
	@SerializedName("link")
	private String link;
	@SerializedName("navigationInfo")
	private NavigationInfo navigationInfo;
	@SerializedName("androidInfo")
	private AndroidInfo androidInfo;
	@SerializedName("iosInfo")
	private IosInfo iosInfo;
	@SerializedName("socialMetaTagInfo")
	private SocialMetaTagInfo socialMetaTagInfo;
	@SerializedName("analyticsInfo")
	private AnalyticsInfo analyticsInfo;
}

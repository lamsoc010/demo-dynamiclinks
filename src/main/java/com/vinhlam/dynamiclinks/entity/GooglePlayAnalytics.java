package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GooglePlayAnalytics {
	@SerializedName("utmSource")
	private String utmSource;
	@SerializedName("utmMedium")
	private String utmMedium;
	@SerializedName("utmContent")
	private String utmContent;
	@SerializedName("utmCampaign")
	private String utmCampaign;
	@SerializedName("utmTerm")
	private String utmTerm;
	
	public GooglePlayAnalytics(String utmSource, String utmMedium, String utmContent) {
		super();
		this.utmSource = utmSource;
		this.utmMedium = utmMedium;
		this.utmContent = utmContent;
	}
	
	
}

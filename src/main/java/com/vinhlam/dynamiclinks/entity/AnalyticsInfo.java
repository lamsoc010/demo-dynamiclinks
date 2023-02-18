package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsInfo {
	@SerializedName("googlePlayAnalytics")
	private GooglePlayAnalytics googlePlayAnalytics;
}

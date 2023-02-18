package com.vinhlam.dynamiclinks.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class IosInfo {
	@SerializedName("iosBundleId")
	private String iosBundleId;
	@SerializedName("iosAppStoreId")
	private String iosAppStoreId;
	@SerializedName("iosIpadBundleId")
	private String iosIpadBundleId;
	@SerializedName("iosFallbackLink")
	private String iosFallbackLink;
	@SerializedName("iosIpadFallbackLink")
	private String iosIpadFallbackLink;
	@SerializedName("iosCustomScheme")
	private String iosCustomScheme;
	
	public IosInfo(String iosBundleId, String iosAppStoreId, String iosIpadBundleId) {
		super();
		this.iosBundleId = iosBundleId;
		this.iosAppStoreId = iosAppStoreId;
		this.iosIpadBundleId = iosIpadBundleId;
	}
	
	
}

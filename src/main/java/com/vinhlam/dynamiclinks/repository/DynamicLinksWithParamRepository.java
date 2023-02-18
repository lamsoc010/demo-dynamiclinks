package com.vinhlam.dynamiclinks.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.vinhlam.dynamiclinks.entity.AnalyticsInfo;
import com.vinhlam.dynamiclinks.entity.AndroidInfo;
import com.vinhlam.dynamiclinks.entity.DynamicLinksInfo;
import com.vinhlam.dynamiclinks.entity.DynamicLinksWithParam;
import com.vinhlam.dynamiclinks.entity.GooglePlayAnalytics;
import com.vinhlam.dynamiclinks.entity.IosInfo;
import com.vinhlam.dynamiclinks.entity.NavigationInfo;
import com.vinhlam.dynamiclinks.entity.SocialMetaTagInfo;

@Configuration
public class DynamicLinksWithParamRepository {
	
//	Get value for AndroidInfo
	@Value("${dynamiclink.androidInfo.androidPackageName}")
    private String androidPackageName;
	@Value("${dynamiclink.androidInfo.androidMinPackageVersionCode}")
    private String androidMinPackageVersionCode;
	@Value("${dynamiclink.androidInfo.androidFallbackLink}")
    private String androidFallbackLink;
	
//	Get value for IosInfo
	@Value("${dynamiclink.iosInfo.iosBundleId}")
    private String iosBundleId;
	@Value("${dynamiclink.iosInfo.iosAppStoreId}")
    private String iosAppStoreId;
	@Value("${dynamiclink.iosInfo.iosIpadBundleId}")
    private String iosIpadBundleId;
	
//	Get value domainUriPrefix and link
	@Value("${dynamiclink.domainUriPrefix}")
    private String domainUriPrefix;
	@Value("${dynamiclink.link}")
    private String link;
	
//	Get value navigationInfo
	@Value("${dynamiclink.navigationInfo.enableForcedRedirect}")
    private boolean enableForcedRedirect;
	
//	Get value socialMetaTagInfo
	@Value("${dynamiclink.socialMetaTagInfo.socialTitle}")
    private String socialTitle;
	@Value("${dynamiclink.socialMetaTagInfo.socialImageLink}")
    private String socialImageLink;
	@Value("${dynamiclink.socialMetaTagInfo.socialDescription}")
    private String socialDescription;
	
//	Get value analyticsInfo - googlePlayAnalytics
	@Value("${dynamiclink.analyticsInfo.googlePlayAnalytics.utmSource}")
    private String utmSource;
	@Value("${dynamiclink.analyticsInfo.googlePlayAnalytics.utmContent}")
    private String utmContent;
	@Value("${dynamiclink.analyticsInfo.googlePlayAnalytics.utmMedium}")
    private String utmMedium;
	
	
	public DynamicLinksWithParam setDataForDynamicLinkWithParam(DynamicLinksInfo dynamicLinksInfoInput) {
		System.out.println("Set dữ liệu param cho dynamiclink: " + dynamicLinksInfoInput.getDomainUriPrefix());
		DynamicLinksWithParam dynamicLinksWithParam = new DynamicLinksWithParam();
		
//		Setdata navigationInfo
		boolean navigationInfoInput;
		navigationInfoInput = dynamicLinksInfoInput.getNavigationInfo() == null ? enableForcedRedirect : dynamicLinksInfoInput.getNavigationInfo().isEnableForcedRedirect();
		NavigationInfo navigationInfo = new NavigationInfo(navigationInfoInput);
		
//		Set androidInfo
		AndroidInfo androidInfo = setDataAndroidInfo(dynamicLinksInfoInput.getAndroidInfo());
	
//		Set iosInfo
		IosInfo iosInfo = setDataIosInfo(dynamicLinksInfoInput.getIosInfo());
		
//		Set socialMetaTagInto
		SocialMetaTagInfo socialMetaTagInfo = setDataForSocialMetaTagInfo(dynamicLinksInfoInput.getSocialMetaTagInfo());		
		

//		Set analyticsInfo - googlePlayAnalytics
		AnalyticsInfo analyticsInfo = setDataAnalyticsInfo(dynamicLinksInfoInput.getAnalyticsInfo());
		
//		Set link;
		String linkInput = "";
		linkInput = dynamicLinksInfoInput.getLink() == null ? link : dynamicLinksInfoInput.getLink();
		
//		Set domainUriPrefix
		String domainUriPrefixInput = "";
		domainUriPrefixInput = dynamicLinksInfoInput.getDomainUriPrefix() == null ? domainUriPrefix : dynamicLinksInfoInput.getDomainUriPrefix();

//		Set DynamicLinksInfo
		DynamicLinksInfo dynamicLinksInfo = 
				new DynamicLinksInfo(domainUriPrefixInput, linkInput, navigationInfo, androidInfo, iosInfo, socialMetaTagInfo, analyticsInfo);
		
		dynamicLinksWithParam.setDynamicLinkInfo(dynamicLinksInfo);
		return dynamicLinksWithParam;
	}
	
	
	
	public SocialMetaTagInfo setDataForSocialMetaTagInfo(SocialMetaTagInfo socialMetaTagInfoInput) {
		String socialTitleInput = "";
		String socialDescriptionInput = "";
		String socialImageLinkInput = "";
		if(socialMetaTagInfoInput != null) {
			System.out.println(socialMetaTagInfoInput.getSocialTitle());
			socialTitleInput = socialMetaTagInfoInput.getSocialTitle() == null ? socialTitle : socialMetaTagInfoInput.getSocialTitle();
			socialDescriptionInput = socialMetaTagInfoInput.getSocialDescription() == null ? socialDescription : socialMetaTagInfoInput.getSocialDescription();
			socialImageLinkInput = socialMetaTagInfoInput.getSocialImageLink() == null ? socialImageLink : socialMetaTagInfoInput.getSocialImageLink();
		} else {
			socialTitleInput = socialTitle;
			socialDescriptionInput = socialDescription;
			socialImageLinkInput = socialImageLink;
		}
		SocialMetaTagInfo socialMetaTagInfo = new SocialMetaTagInfo(socialTitleInput, socialDescriptionInput, socialImageLinkInput);
		return socialMetaTagInfo;
	}
	
	public AndroidInfo setDataAndroidInfo(AndroidInfo androidInfoInput) {
		String androidPackageNameInput = "";
		String androidMinPackageVersionCodeInput = "";
		String androidFallbackLinkInput = "";
		if(androidInfoInput != null) {
			androidPackageNameInput = androidInfoInput.getAndroidPackageName() == null ? androidPackageName : androidInfoInput.getAndroidPackageName();
			androidMinPackageVersionCodeInput = androidInfoInput.getAndroidMinPackageVersionCode() == null ? androidMinPackageVersionCode : androidInfoInput.getAndroidMinPackageVersionCode();
			androidFallbackLinkInput = androidInfoInput.getAndroidFallbackLink() == null ? androidFallbackLink : androidInfoInput.getAndroidFallbackLink();
		} else {
			System.out.println("Chạy vào set android ở application");
			androidPackageNameInput = androidPackageName;
			androidMinPackageVersionCodeInput = androidMinPackageVersionCode;
			androidFallbackLinkInput = androidFallbackLink;
		}
		System.out.println("androidPackageNameInput: " + androidPackageNameInput);
		System.out.println("androidMinPackageVersionCodeInput: " + androidMinPackageVersionCodeInput);
		System.out.println("androidFallbackLinkInput: " + androidFallbackLinkInput);
		AndroidInfo androidInfo = new AndroidInfo(androidPackageNameInput, androidMinPackageVersionCodeInput, androidFallbackLinkInput);
		return androidInfo;
	}
	
	public IosInfo setDataIosInfo(IosInfo iosInfoInput) {
		String iosBundleIdInput = "";
		String iosAppStoreIdInput = "";
		String iosIpadBundleIdInput = "";
		if(iosInfoInput != null) {
			iosBundleIdInput = iosInfoInput.getIosBundleId() == null ? iosBundleId : iosInfoInput.getIosBundleId();
			iosAppStoreIdInput = iosInfoInput.getIosAppStoreId() == null ? iosAppStoreId : iosInfoInput.getIosAppStoreId();
			iosIpadBundleIdInput = iosInfoInput.getIosIpadBundleId() == null ? iosIpadBundleId : iosInfoInput.getIosIpadBundleId();
		} else {
			iosBundleIdInput = iosBundleId;
			iosAppStoreIdInput = iosAppStoreId;
			iosIpadBundleIdInput = iosIpadBundleId;
		}
		IosInfo iosInfo = new IosInfo(iosBundleIdInput, iosAppStoreIdInput, iosIpadBundleIdInput);
		return iosInfo;
	}

	public AnalyticsInfo setDataAnalyticsInfo(AnalyticsInfo analyticsInfoInput) {
		String utmSourceInput = "";
		String utmMediumInput = "";
		String utmContentInput = "";
		if(analyticsInfoInput != null && analyticsInfoInput.getGooglePlayAnalytics() != null) {
			utmSourceInput = analyticsInfoInput.getGooglePlayAnalytics().getUtmSource() == null ? utmSource : analyticsInfoInput.getGooglePlayAnalytics().getUtmSource();
			utmMediumInput = analyticsInfoInput.getGooglePlayAnalytics().getUtmMedium() == null ? utmMedium : analyticsInfoInput.getGooglePlayAnalytics().getUtmMedium();
			utmContentInput = analyticsInfoInput.getGooglePlayAnalytics().getUtmContent() == null ? utmContent : analyticsInfoInput.getGooglePlayAnalytics().getUtmContent();
		} else {
			utmSourceInput = utmSource;
			utmMediumInput = utmMedium;
			utmContentInput = utmContent;
		}
		GooglePlayAnalytics googlePlayAnalytics = new GooglePlayAnalytics(utmSourceInput, utmMediumInput, utmContentInput);
		AnalyticsInfo analyticsInfo = new AnalyticsInfo(googlePlayAnalytics);
		return analyticsInfo;
	}

} 

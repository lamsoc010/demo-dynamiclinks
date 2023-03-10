package com.vinhlam.dynamiclinks.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vinhlam.dynamiclinks.entity.DynamicLinksInfo;
import com.vinhlam.dynamiclinks.entity.DynamicLinksNoParam;
import com.vinhlam.dynamiclinks.entity.DynamicLinksWithParam;
import com.vinhlam.dynamiclinks.entity.Suffix;
import com.vinhlam.dynamiclinks.exception.ErrorResponse;
import com.vinhlam.dynamiclinks.exception.InvalidError;
import com.vinhlam.dynamiclinks.repository.DynamicLinksWithParamRepository;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@RestController
@RequestMapping("/dynamiclinks")
public class DynamicLinksController {
	
	@Autowired
	public DynamicLinksWithParamRepository dynamicLinksWithParamRepository;
//	@Autowired
//	private FirebaseConfig firebaseConfig;
//	public DynamicLinksController() {
//		dynamicLinksWithParamRepository = new DynamicLinksWithParamRepository();
//	}
	
	
	
//	API: Create dynamic link with longLink http://localhost:8080/dynamiclinks
	@PostMapping
	public String createDynamicLinkNoParam() throws URISyntaxException {
		
		String url = "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyBaQiHeYxY7wdmG6k-6VhFaCtw50enRrbE";
				
		DynamicLinksNoParam longLink = new DynamicLinksNoParam();
		longLink.setLongDynamicLink("https://demohahalolo.page.link?link=https://www.hahalolo.com/");
		Suffix option = new Suffix();
		option.setOption("SHORT");
		longLink.setSuffix(option);
		
		Gson gson = new Gson();
		RequestBody requestBody1 = RequestBody.create(MediaType.parse("application/json"), gson.toJson(longLink));
				
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody1)
				.build();
		
		OkHttpClient client = new OkHttpClient();
		try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
            	String responseBody = response.body().string();
                throw new IOException("Unexpected code: " + response.body());
            }
            String shortLink = response.body().string();
            
            return shortLink;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
//	API: Create dynamic link with params http://localhost:8080/dynamiclinks/params
	@PostMapping("/params")
	public String createDynamicLinksWithParam(@org.springframework.web.bind.annotation.RequestBody DynamicLinksInfo dynamicLinksInfo) throws InvalidError {
//		Link API request
		String url = "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyBaQiHeYxY7wdmG6k-6VhFaCtw50enRrbE";
						
//		Set d??? li???u cho c??c param
		DynamicLinksWithParam dynamicLinksWithParam = dynamicLinksWithParamRepository.setDataForDynamicLinkWithParam(dynamicLinksInfo);
		
//		Chuy???n ?????i d??? li???u t??? Object th??nh chu???i Json
		Gson gson = new Gson();
		RequestBody requestBody1 = RequestBody.create(MediaType.parse("application/json"), gson.toJson(dynamicLinksWithParam));
			
//		T???o request ?????n API URL k??m c??c prarams
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody1)
				.build();
		
//		G???i request
		OkHttpClient client = new OkHttpClient();
		try (Response response = client.newCall(request).execute()) {

//			Ki???m tra n???i l???i th?? x??? l?? v?? tr??? v??? l???i
            if (!response.isSuccessful()) {
            	System.out.println("V??o l???i");
            	String responseMessage = response.body().string();
            	System.out.println(responseMessage);
            	
//            	Chuy???n chu???i json t??? response th??nh ?????i t?????ng ????? handle exception
            	ErrorResponse errorResponse = gson.fromJson(responseMessage, ErrorResponse.class);
                throw new InvalidError(400, errorResponse);
            }
            String responseMessage = response.body().string();
            System.out.println("ResponseMessage: " + responseMessage);
            
            return responseMessage;
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "";
	}

//	@GetMapping("/testGetToken")
//	public String testGetToken() throws IOException {
//		String url = "https://firebasedynamiclinks.googleapis.com/v1/https%3A%2F%2Fdemohahalolo.page.link%2FFBqeh5Q8LYbecoVQ9/linkStats?durationDays=7";
//		
//		String bearerToken = "Bearer " + firebaseConfig.getAccessToken();
//		System.out.println("Bearer Token: " + bearerToken);
//		Request request = new Request.Builder()
//				.url(url)
//				.header("Authorization", bearerToken)
//				.build();
//		
//		OkHttpClient client = new OkHttpClient();
//		try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//            	String responseBody = response.body().string();
//            	System.out.println(responseBody);
//                throw new IOException("Unexpected code: " + response.body());
//            }
//            String shortLink = response.body().string();
//            return shortLink;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
//		
//		return "";
//	}
}

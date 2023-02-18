package com.vinhlam.dynamiclinks.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.vinhlam.dynamiclinks.entity.DynamicLinksInfo;
import com.vinhlam.dynamiclinks.entity.DynamicLinksWithParam;
import com.vinhlam.dynamiclinks.exception.ErrorResponse;
import com.vinhlam.dynamiclinks.exception.InvalidError;
import com.vinhlam.dynamiclinks.repository.DynamicLinksWithParamRepository;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class DynamicLinksService {
	
	@Autowired
	public DynamicLinksWithParamRepository dynamicLinksWithParamRepository;
	
	public String createDynamicLinksWithParam(DynamicLinksInfo dynamicLinksInfo) throws InvalidError {
//		Link API request
		String url = "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyBaQiHeYxY7wdmG6k-6VhFaCtw50enRrbE";
						
//		Set dữ liệu cho các param
		DynamicLinksWithParam dynamicLinksWithParam = dynamicLinksWithParamRepository.setDataForDynamicLinkWithParam(dynamicLinksInfo);
		
//		Chuyển đổi dữ liệu từ Object thành chuỗi Json
		Gson gson = new Gson();
		RequestBody requestBody1 = RequestBody.create(MediaType.parse("application/json"), gson.toJson(dynamicLinksWithParam));
			
//		Tạo request đến API URL kèm các prarams
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody1)
				.build();
		
//		Gửi request
		OkHttpClient client = new OkHttpClient();
		try (Response response = client.newCall(request).execute()) {

//			Kiểm tra nối lỗi thì xử lý và trả về lỗi
            if (!response.isSuccessful()) {
            	System.out.println("Vào lỗi");
            	String responseMessage = response.body().string();
            	System.out.println(responseMessage);
            	
//            	Chuyển chuỗi json từ response thành đối tượng để handle exception
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
	
	public String createDynamicLinksWithParam1(DynamicLinksWithParam dynamicLinksWithParam) throws InvalidError {
//		Link API request
		String url = "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyBaQiHeYxY7wdmG6k-6VhFaCtw50enRrbE";
						
////		Set dữ liệu cho các param
//		DynamicLinksWithParam dynamicLinksWithParam = dynamicLinksWithParamRepository.setDataForDynamicLinkWithParam(dynamicLinksInfo);
		
//		Chuyển đổi dữ liệu từ Object thành chuỗi Json
		Gson gson = new Gson();
		RequestBody requestBody1 = RequestBody.create(MediaType.parse("application/json"), gson.toJson(dynamicLinksWithParam));
			
//		Tạo request đến API URL kèm các prarams
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody1)
				.build();
		
//		Gửi request
		OkHttpClient client = new OkHttpClient();
		try (Response response = client.newCall(request).execute()) {

//			Kiểm tra nối lỗi thì xử lý và trả về lỗi
            if (!response.isSuccessful()) {
            	System.out.println("Vào lỗi");
            	String responseMessage = response.body().string();
            	System.out.println(responseMessage);
            	
//            	Chuyển chuỗi json từ response thành đối tượng để handle exception
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
}

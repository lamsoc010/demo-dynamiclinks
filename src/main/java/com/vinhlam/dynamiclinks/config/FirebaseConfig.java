//package com.vinhlam.dynamiclinks.config;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Component;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.auth.ActionCodeSettings;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//
//
//
//@Component
//public class FirebaseConfig {
//	@Value("${app.firebase-configuration-file}")
//	private String firebaseConfigPath;
//
//	@Bean
//	public FirebaseApp initialize()  {
////		if(FirebaseApp.getInstance(FirebaseApp.DEFAULT_APP_NAME) != null) {
////		    FirebaseApp.getInstance().delete();
////		}
//		try {
//			FirebaseOptions options = new FirebaseOptions.Builder()
//					.setCredentials(
//							GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream()))
//					.build();
//			
//			return FirebaseApp.initializeApp(options);
//
//			
//		} catch (IOException e) {
////			logger.error(e.getMessage());
//		}
//		return null;
//	}
//	
//	@Bean
//	public String getAccessToken() throws IOException {
////		FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);
//		GoogleCredential googleCred = GoogleCredential.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream());
//		GoogleCredential scoped = googleCred.createScoped(
//			    Arrays.asList(
//			      "https://www.googleapis.com/auth/firebase",
//			      "https://www.googleapis.com/auth/userinfo.email"
//			    )
//			);
//		String uid = "TmfV3HkkYnYciebmScTmabyDaVJ2"; // The user ID for which to generate a token
//		scoped.createDelegated(uid);
//		scoped.refreshToken();
//		String token = scoped.getAccessToken();
//		System.out.println("Token: " +token);
//		return token;
//	}
//}

package com.example.Backend;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Login;
import models.Impl.LoginImpl;
import models.Impl.ProfileSettings;
import services.FetchUserprofile;
import services.InsertProfileServices;
import services.LoginServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MyController {

	private Login loginDetails;
	private ProfileSettings profileSettings;

	@GetMapping("/test")
	public String home() {
		return "home page";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/validate")
	public <T> ResponseEntity<T> validateCredentials(@RequestBody Map<String, Object> userData) {
		loginDetails = new LoginImpl.Builder().emailId(userData.get("emailId").toString())
				.password(userData.get("password").toString()).build();

		return LoginServices.validateCredentials(loginDetails);
	}

	@RequestMapping("/updateProfile")
	public boolean updateProfile(@RequestBody Map<String, Object> userProfile) {
		profileSettings = ProfileSettings.Builder.newInstance().setuserId((int) userProfile.get("userId"))
				.setuserName(userProfile.get("userName").toString())
				.setuserAddress(userProfile.get("userAddress").toString())
				.setUserCity(userProfile.get("userCity").toString())
				.setUserState(userProfile.get("userState").toString())
				.setUserZipCode(userProfile.get("userZipCode").toString()).Build();

		return InsertProfileServices.insertProfile(profileSettings);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getProfile")
	public <T> ResponseEntity<T> getUpdatedProfile(@RequestBody Map<String, Object> userProfile) {
		return FetchUserprofile.fetchUserDetails((int) userProfile.get("userId"));
	}

}

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
import services.LoginServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MyController {

	private Login loginDetails;

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
}

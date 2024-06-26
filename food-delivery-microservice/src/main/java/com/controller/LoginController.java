package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Login;
import com.service.LoginService;

import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:4200")				//allow to access rest api by frontend technology
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value="signin",consumes= MediaType.APPLICATION_JSON)
	public String signIn(@RequestBody Login login) {
		return loginService.signIn(login);
	}
	
	@PostMapping(value="signup",consumes= MediaType.APPLICATION_JSON)
	public String signUp(@RequestBody Login login) {
		return loginService.signUp(login);
		
		
	}

}
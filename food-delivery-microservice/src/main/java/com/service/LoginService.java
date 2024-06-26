package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	public String signUp(Login login) {
		Optional<Login> res = loginRepository.findById(login.getEmailid());

		if(res!=null) {
		if(res.isPresent()) {
			return " Account details already exists, try again!";
		}else {
			if(login.getTypeofuser().equals("admin")) {
				return " Not allowed to create an admin account!";
			}else {
				loginRepository.save(login);
				return "Customer Account created successfully!";
				
			}
	
	
	}}else{
		System.out.println("ID IS NULL");
		return "Empty emailid";
		
	}
	}
	public String signIn(Login login) {
		Optional<Login> res = loginRepository.findById(login.getEmailid());
		System.out.println("Result"+res.toString());
		if(res.isPresent()) {
			Login ll = res.get();
			if(ll.getPassword().equals(login.getPassword())){
				if(ll.getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")) {
					return "Admin login successfull!";
				}else if(!ll.getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")){
					return "Access Denied!, You are not an Admin!";
				}else {
					return "Customer login successfull!";
				}
			}else {
				return "Access Denied!, your email id or password is incorrect!";
			}
		}else {
			return "Access Denied!, your email id or password is incorrect!";
		}
	}

}
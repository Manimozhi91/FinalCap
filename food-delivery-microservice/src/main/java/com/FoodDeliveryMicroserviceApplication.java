package com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.Login;
import com.repository.LoginRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages="com")
@EntityScan(basePackages="com.entity")
@EnableJpaRepositories(basePackages="com.repository")
@EnableDiscoveryClient

public class FoodDeliveryMicroserviceApplication {
	@Autowired
	LoginRepository loginrepo;
	@PostConstruct
	public void init(){
	Optional<Login> result=loginrepo.findById("admin@gmail.com");
	if(result.isPresent()) {
		System.out.println("Account already present");
	}else {
		Login admin=new Login();
		admin.setEmailid("admin@gmail.com");
		admin.setPassword("admin@123");
		admin.setTypeofuser("admin");
		loginrepo.save(admin);
		System.out.println("Admin created ");
	}
	}
	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryMicroserviceApplication.class, args);
	System.out.println("Food delivery up on 9090");
	}

}

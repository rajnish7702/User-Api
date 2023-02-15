package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class UserApiApplication {
	
	@Autowired
	private WelcomeClient clients;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
	@GetMapping("/user")
	public String user() {
		String welcomeApi = clients.involkWelcomeApi();
		String userApiResponse = " User Api Response";
		return welcomeApi+userApiResponse;
	}
}

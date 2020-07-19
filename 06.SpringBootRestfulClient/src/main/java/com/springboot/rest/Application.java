package com.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	
	static final String URL_EMPLOYEES = "http://localhost:8080";

	static final String URL_EMPLOYEES_XML = "http://localhost:8080/employees.xml";
	static final String URL_EMPLOYEES_JSON = "http://localhost:8080/employees.json";


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);
		System.out.println("***********"+result);
	}

}



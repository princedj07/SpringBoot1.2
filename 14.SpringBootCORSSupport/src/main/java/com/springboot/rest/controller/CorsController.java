package com.springboot.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:8080")
public class CorsController {

	public ResponseEntity<Object> getProduct() {
		   System.out.println("CorsController.getProduct()");
		return null;
		}
}



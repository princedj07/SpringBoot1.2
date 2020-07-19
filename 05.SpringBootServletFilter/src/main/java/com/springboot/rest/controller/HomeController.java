package com.springboot.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = "/")
	public String hello() {
		return "<h1>This is Servlet Filter Example....</h1>";
	}

}

package com.springboot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

	@ApiOperation(value = "Returns HelloWorld")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the nessage"),
			@ApiResponse(code = 200, message = "SuccessFull") })

	@GetMapping
	public String getTest() {
		return "Hello World";
	}

	@PostMapping
	public String postTest(@RequestBody final String postTest) {
		return postTest;
	}

	@PutMapping
	public String putTest(@RequestBody final String putTest) {
		return putTest;
	}
}

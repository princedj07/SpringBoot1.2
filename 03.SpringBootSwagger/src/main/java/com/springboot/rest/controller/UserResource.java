package com.springboot.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.User;

@RestController
@RequestMapping("/rest/user")

public class UserResource {

	@GetMapping
	public List<User> getUserTest() {
		return Arrays.asList(new User("Prince", 30000L),
				new User("Raj", 40000L));
	}

	@GetMapping("/{userName}")
	public User getUsers(@PathVariable("userName") final String username) {
		return new User(username, 50000L);
	}
}

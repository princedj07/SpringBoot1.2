package com.springboot.rest.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.springboot.rest.controller.model.Greeting;
import com.springboot.rest.controller.model.HelloMessage;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		System.out.println("GreetingController.greeting()"+message);
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}
	
}
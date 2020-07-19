package com.springboot.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class JavaProfileCongig {

	@Profile("dev")
	@Bean
	public String devBean() {
		return "I will be available in profile dev";
	}


}

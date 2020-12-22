package com.karthick.company.HelloSpringBoot.api.server;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class WelcomeSpringBoot {
	
	private static final Logger LOG = LoggerFactory.getLogger(WelcomeSpringBoot.class);

	@RequestMapping(value = "/api/newking")
	public String welcomeSpring() {
		LOG.info("Karthick, Welcome Back To Spring World");
		return "Karthick, Welcome Back To Spring World";
	}

	@RequestMapping(value = "/api/printDate")
	public String printDate() {
		return LocalDate.now().toString();
	}

}

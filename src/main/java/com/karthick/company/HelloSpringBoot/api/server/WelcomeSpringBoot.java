package com.karthick.company.HelloSpringBoot.api.server;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeSpringBoot {

	@RequestMapping(value = "/api/newking")
	public String welcomeSpring() {
		return "Karthick, Welcome Back To Spring World";
	}

	@RequestMapping(value = "/api/printDate")
	public String printDate() {
		return LocalDate.now().toString();
	}

}

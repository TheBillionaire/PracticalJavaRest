package com.karthick.company.HelloSpringBoot.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthick.company.HelloSpringBoot.api.service.CarService;
import com.karthick.company.HelloSpringBoot.entities.Car;

@RestController
@RequestMapping(value = "/api")
public class RandomCarServiceApi {
	
	@Autowired
	private CarService randomCarService;
	
	@GetMapping(value="/RandomCar/v1", produces=MediaType.APPLICATION_JSON_VALUE)
	public Car randomCarGenerator() {
		return randomCarService.generateCar();
	}
	
	@PostMapping(value="/EchoCar/v1", consumes = MediaType.APPLICATION_JSON_VALUE )
	public Car randomCarEcho(@RequestBody Car car ) {
		return car;
	}
	
}

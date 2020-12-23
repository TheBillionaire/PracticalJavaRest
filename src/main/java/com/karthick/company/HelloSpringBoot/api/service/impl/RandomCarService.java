package com.karthick.company.HelloSpringBoot.api.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.karthick.company.HelloSpringBoot.api.service.CarService;
import com.karthick.company.HelloSpringBoot.entities.Car;

@Service
public class RandomCarService implements CarService {

	@Override
	public Car generateCar() {
		
		var brand = ThreadLocalRandom.current() .nextInt(0, BRANDS.size());
		var type = ThreadLocalRandom.current() .nextInt(0, TYPES.size());
		var color = ThreadLocalRandom.current() .nextInt(0, COLORS.size());
		
		return new Car(BRANDS.get(brand), TYPES.get(type) , COLORS.get(color));
	}

}

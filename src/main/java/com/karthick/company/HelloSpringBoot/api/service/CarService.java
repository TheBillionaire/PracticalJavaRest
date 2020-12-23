package com.karthick.company.HelloSpringBoot.api.service;

import java.util.List;

import com.karthick.company.HelloSpringBoot.entities.Car;

public interface CarService {

	List<String> BRANDS = List.of("BMW", "Mercedes", "Audi");
	
	List<String> COLORS = List.of("Blue", "Green", "Red", "Yellow");
	
	List<String> TYPES = List.of("SUV", "Sedan", "MPV");
	
	Car generateCar();
	
}

package com.karthick.company.HelloSpringBoot.api.service;

import java.util.List;

import com.karthick.company.HelloSpringBoot.entities.Car;

public interface CarService {

	List<String> BRANDS = List.of("BMW", "Mercedes", "Audi", "Rolce Royce", "Mitsubishi", "Toyota", "Fiat", "Tesla");
	
	List<String> COLORS = List.of("Blue", "Green", "Red", "Yellow", "Black", "White", "Silver");
	
	List<String> TYPES = List.of("SUV", "Sedan", "MPV", "Hatchback", "Convertible");
	
	List<String> FEATURES_AVAILABLE = List.of("LEATHER", "STEREO", "AIR BAGS", "Alluminium Barrells");
	
	List<String> ENGINES = List.of("ROLCE ROYCE", "BMW", "MERCEDES");
	
	List<String> TYRE_MANUFARCTURER = List.of("Good Year", "DUNLOP", "Michelin", "MRF");
	
	Car generateCar();
	
}

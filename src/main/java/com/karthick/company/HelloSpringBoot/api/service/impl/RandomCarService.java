package com.karthick.company.HelloSpringBoot.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.karthick.company.HelloSpringBoot.api.service.CarService;
import com.karthick.company.HelloSpringBoot.entities.Car;
import com.karthick.company.HelloSpringBoot.entities.Engine;
import com.karthick.company.HelloSpringBoot.entities.Tyre;
import com.karthick.company.HelloSpringBoot.util.RandomDateGeneratorUtil;

@Service("RandomCarService")
public class RandomCarService implements CarService {

	@Override
	public Car generateCar() {
		
		var brand = ThreadLocalRandom.current() .nextInt(0, BRANDS.size());
		var type = ThreadLocalRandom.current() .nextInt(0, TYPES.size());
		var color = ThreadLocalRandom.current() .nextInt(0, COLORS.size());
		var available = ThreadLocalRandom.current() .nextBoolean();
		var releaseDate = RandomDateGeneratorUtil.randomDateGenerator();
		var price = ThreadLocalRandom.current() .nextInt(100_000, 500_001);
		var numberOfFeatures = ThreadLocalRandom.current().nextInt(0, FEATURES_AVAILABLE.size());
		List<String> featuresAdded = new ArrayList<>();
		for(int i=0; i< numberOfFeatures ; i++) {
			featuresAdded.add(FEATURES_AVAILABLE.get(i));
		}
		
		var tyrePrice = ThreadLocalRandom.current().nextInt(10000, 50001);
		var tyreCompany = TYRE_MANUFARCTURER.get(ThreadLocalRandom.current().nextInt(0, TYRE_MANUFARCTURER.size()));
		var tyreSize = ThreadLocalRandom.current().nextInt(10, 19);
		Tyre tyre = new Tyre(tyreCompany,tyreSize,tyrePrice);
		
		List<Tyre> tyres = List.of(tyre, tyre, tyre, tyre);
		
		//var engine = ENGINES.get(ThreadLocalRandom.current() .nextInt(0, ENGINES.size()));
		
		return new Car(available, BRANDS.get(brand), COLORS.get(color), price, releaseDate,TYPES.get(type), featuresAdded, new Engine("Solar", 1000), tyres);
		
	}

}

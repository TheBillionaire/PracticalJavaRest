package com.karthick.company.HelloSpringBoot.api.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthick.company.HelloSpringBoot.api.service.CarService;
import com.karthick.company.HelloSpringBoot.entities.Car;
import com.karthick.company.HelloSpringBoot.repository.CarElasticRepository;

@RestController
@RequestMapping(value = "/api")
public class RandomCarServiceApi {
	
	@Autowired
	private CarService randomCarService;
	
	@Autowired
	private CarElasticRepository carElasticRepository;
	
	@GetMapping(value="/RandomCar/v1", produces=MediaType.APPLICATION_JSON_VALUE)
	public Car randomCarGenerator() {
		return randomCarService.generateCar();
	}
	
	@PostMapping(value="/EchoCar/v1", consumes = MediaType.APPLICATION_JSON_VALUE )
	public Car randomCarEcho(@RequestBody Car car ) {
		return car;
	}
	
	@GetMapping(value = "/BuyMultipleCars/v1" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> myCarsCollection(){
		
		var carsCount = ThreadLocalRandom.current().nextInt(6);
		List<Car> cars = new ArrayList<>();
		for(int i=0; i<carsCount; i++) {
			cars.add(randomCarService.generateCar());
			System.out.println(cars.get(i));
		}
		return cars;
	}

	/*  
	 * 1) End Point to Display Count Of Cars
	 * 2) End Point to Ad a Car
	 * 3) End Point To Update a Car
	 * 4) End Point to Delete A Car
	 * */
	
	@GetMapping(value="/Count/v1")
	public String getCountOfCars() {
		long carsCount = carElasticRepository.count();
		return "Number Of Cars In Elastic Search are " + carsCount;
	}
	
	@PostMapping(value="/SaveCar/v1/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Car saveCar(@RequestBody Car car) {
		return carElasticRepository.save(car);
	}
		
	
	@GetMapping(value="/FindCar/v1/{id}")
	public Car searchCar(@PathVariable String id) {
		return carElasticRepository.findById(id).orElse(null);
	}
	
	
	@PutMapping(value = "/UpdateCar/v1/{id}")
	public String updateCar(@PathVariable("id") String carId, @RequestBody Car updatedCar) {
		updatedCar.setId(carId);
		var newCar = carElasticRepository.save(updatedCar);
		return "Updated car with ID : " + newCar.getId();
	}
	
	
	@PostMapping(value="/FindCarByBrandColor/", consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Car> findCarByBrandAndColor(@RequestBody Car car) {
		return carElasticRepository.findByBrandAndColor(car.getBrand(), car.getColor());
	}
	
	@GetMapping(value="/FindCarByBrandColor/{brand}/{color}")
	public List<Car> findCarByBrandAndColor(@PathVariable String brand, @PathVariable String color) {
		System.out.println("Call Entered" + brand + " " + color);
		return carElasticRepository.findByBrandAndColor(brand,color);
	}
	
	
}

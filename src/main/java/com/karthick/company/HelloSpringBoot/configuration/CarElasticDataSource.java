package com.karthick.company.HelloSpringBoot.configuration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

import com.karthick.company.HelloSpringBoot.api.service.CarService;
import com.karthick.company.HelloSpringBoot.entities.Car;
import com.karthick.company.HelloSpringBoot.repository.CarElasticRepository;

@Configuration
public class CarElasticDataSource {
	
	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(CarElasticDataSource.class);

	@Autowired
	@Qualifier(value = "CarElasticRepository")
	private CarElasticRepository carElasticRepository;
	
	@Autowired
	@Qualifier("RandomCarService")
	private CarService carService;
	
	@Autowired
	@Qualifier("webClientElasticSearch")
	private WebClient webClient;
	
	@EventListener(classes = {ApplicationReadyEvent.class})
	public void publishData() {
		carElasticRepository.deleteAll();
		LOG.info("Deleted All Existsing Objects");
		List<Car> cars = new ArrayList<>();
		for(int i=0; i<10_000; i++) {
			cars.add(carService.generateCar());
		}
		carElasticRepository.saveAll(cars);
		LOG.info("Added 10K Records to ElasticSearch Repository");
	}
}

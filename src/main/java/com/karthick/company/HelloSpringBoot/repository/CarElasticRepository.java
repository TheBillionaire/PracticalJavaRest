package com.karthick.company.HelloSpringBoot.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.karthick.company.HelloSpringBoot.entities.Car;

@Repository(value = "CarElasticRepository")
public interface CarElasticRepository extends ElasticsearchRepository <Car, String> {
	
	public List<Car> findByBrandAndColor(String brand, String color);
	
}
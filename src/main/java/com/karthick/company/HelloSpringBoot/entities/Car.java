package com.karthick.company.HelloSpringBoot.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Document(indexName = "practical-java")
public class Car {

	@Id
	private String id;

	private boolean available;
	
	private String brand;

	private String color;

	@JsonUnwrapped
	private Engine engine;

	@JsonInclude(value = Include.NON_EMPTY)	
	private List<String> features;

	private int price;

	@Field(type = FieldType.Date, format = DateFormat.date)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private LocalDate releaseDate;

	private String type;

	private List<Tyre> tyre;

	public Car() {

	}

	public Car(boolean available, String brand, String color,  int price, LocalDate releaseDate,
			String type, List<String> features, Engine engine, List<Tyre> tyre) {
		super();
		this.available = available;
		this.brand = brand;
		this.color = color;
		this.features = features;
		this.price = price;
		this.releaseDate = releaseDate;
		this.type = type;
		this.engine=engine;
		this.tyre=tyre;
	}

	public String getBrand() {
		return brand;
	}
	
	public String getColor() {
		return color;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public List<String> getFeatures() {
		return features;
	}
	
	public String getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public String getType() {
		return type;
	}

	public List<Tyre> getTyre() {
		return tyre;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTyre(List<Tyre> tyre) {
		this.tyre = tyre;
	}

	@Override
	public String toString() {
		return "Car [available=" + available + ", brand=" + brand + ", color=" + color + ", engine=" + engine
				+ ", features=" + features + ", price=" + price + ", releaseDate=" + releaseDate + ", type=" + type
				+ ", tyre=" + tyre + "]";
	}


}

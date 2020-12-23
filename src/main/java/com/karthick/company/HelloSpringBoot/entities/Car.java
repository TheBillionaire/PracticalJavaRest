package com.karthick.company.HelloSpringBoot.entities;

import java.time.LocalDate;

public class Car {

	private boolean available;

	private String brand;

	private String color;

	private int price;

	private LocalDate releaseDate;

	private String type;

	public Car() {

	}

	public Car(String brand, String type, String color) {
		super();
		this.brand = brand;
		this.type = type;
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [available=" + available + ", brand=" + brand + ", color=" + color + ", price=" + price
				+ ", releaseDate=" + releaseDate + ", type=" + type + "]";
	}

}

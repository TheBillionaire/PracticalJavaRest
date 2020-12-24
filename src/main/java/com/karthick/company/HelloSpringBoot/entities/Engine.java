package com.karthick.company.HelloSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Engine {
	
	private String fuelType;
	
	private int horsePower;
	
	@JsonIgnore
	private String engineColor = "Black";
	
	@JsonIgnore
	private String serialNumber = "KM0000001";
	
	public Engine() {
	}

	public Engine(String fuelType, int horsePower) {
		this.fuelType = fuelType;
		this.horsePower = horsePower;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getEngineColor() {
		return engineColor;
	}

	public void setEngineColor(String engineColor) {
		this.engineColor = engineColor;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}

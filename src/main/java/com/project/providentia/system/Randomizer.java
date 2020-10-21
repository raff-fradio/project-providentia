package com.project.providentia.system;

public class Randomizer {
	private double temperature;
	private double windSpeed;
	private boolean frontDoor;
	
	public Randomizer() {
		
	}
	public double getRandomTemp() {
		
		return temperature;
	}
	public double getRandomWindspeed() {
		return windSpeed;
	}
	public Boolean getRandomFrontDoor() {
		return frontDoor;
	}
}
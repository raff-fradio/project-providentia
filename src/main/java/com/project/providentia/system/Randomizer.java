package com.project.providentia.system;

import java.util.Random;

public class Randomizer {
	
	private final double MIN_TEMP = -1;
	private final double MAX_TEMP = 40;
	private final double MIN_WIND_SPEED = 0;
	private final double MAX_WIND_SPEED = 370;
	private final double GUEST_CHANCE = 0.1;
	
	private final int DECIMAL_PLACE = 2;
		
	private Random random;
	
	public Randomizer() {
		this.random = new Random();
	}
	
	public double getRandomTemperature() {
		return round(random.nextDouble() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP);
	}
	
	public double getRandomWindSpeed() {
		return round(random.nextDouble() * (MAX_WIND_SPEED - MIN_WIND_SPEED) + MIN_WIND_SPEED);
	}
	
	public boolean getRandomFrontDoor() {
		double randomDouble = random.nextDouble();
		if (randomDouble < GUEST_CHANCE) return true;
		else return false;
	}
	
	private double round(double value) {
		double scale = Math.pow(10, DECIMAL_PLACE);
		return Math.round(value * scale) / scale;
	}
}
package com.project.providentia.system;

import java.util.Random;

public class Randomizer {
	
	private final double MIN_TEMP = -10;
	private final double MAX_TEMP = 30;
	private final double MIN_WIND_SPEED = 0;
	private final double MAX_WIND_SPEED = 370;
	private final double GUEST_CHANCE = 0.2;
		
	Random randomizer = new Random();
	
	public double getRandomTemperature() {
		return randomizer.nextDouble() * (MAX_TEMP - MIN_TEMP) * MIN_TEMP;
	}
	
	public double getRandomWindSpeed() {
		return randomizer.nextDouble() * (MAX_WIND_SPEED - MIN_WIND_SPEED) + MIN_WIND_SPEED;
	}
	
	public boolean getRandomFrontDoor() {
		double random = randomizer.nextDouble();
		if (random < GUEST_CHANCE) return true;
		else return false;
	}
}
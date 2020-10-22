package com.project.providentia.system;

import java.util.Random;

public class Randomizer implements Runnable {
	
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
	
	@Override
	public void run() {
		Activity activity = new Activity();	
		try {
			do {
				double temp = getRandomTemperature(-10,30);
				double windSpeed = getRandomWindSpeed(0,20);
				Boolean frontDoor = frontDoor();
				activity.setVariables(temp, windSpeed, frontDoor);
				System.out.println(activity.getTemperature());
				System.out.println(activity.getWindSpeed());
				System.out.println(activity.getFrontDoor());
				Thread.sleep(1000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error in Randomizer Thread !");
		}
	}
}
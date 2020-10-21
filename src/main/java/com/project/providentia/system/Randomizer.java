package com.project.providentia.system;

import java.util.Random;

public class Randomizer implements Runnable{
	public double getRandomTemp(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public double getRandomWindSpeed(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public Boolean getRandomFrontDoor() {
		return (new Random().nextBoolean());
	}
	public void insertVar() {
		
		
	}
	@Override
	public void run() {
		Activity activity = new Activity();	
		try {
			do {
				double temp = getRandomTemp(-1,30);
				double windSpeed = getRandomWindSpeed(0,-20);
				Boolean frontDoor = getRandomFrontDoor();
				Thread.sleep(10000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error !");
		}
	}
}
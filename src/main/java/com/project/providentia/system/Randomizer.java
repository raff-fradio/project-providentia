package com.project.providentia.system;

import java.util.Random;

public class Randomizer implements Runnable{
	public double getRandomTemp(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public double getRandomWindspeed(double min, double max) {
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
				
				Thread.sleep(10000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error !");
		}
	}
}
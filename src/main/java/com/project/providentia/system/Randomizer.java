package com.project.providentia.system;

import java.util.*;

public class Randomizer implements Runnable {
	public double getRandomTemp(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public double getRandomWindSpeed(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public Boolean getRandomFrontDoor() {
		return (new Random().nextBoolean());
	}
	public Boolean frontDoor() {
		do {
			int ran = 7;
			int rand = (new Random().nextInt()*(9-0)+0);
			if(rand==ran) {
				return true;
			}
			return false;
		} while(true);
	}
	@Override
	public void run() {
		Activity activity = new Activity();	
		try {
			do {
				double temp = getRandomTemp(-1,30);
				double windSpeed = getRandomWindSpeed(0,20);
				Boolean frontDoor = getRandomFrontDoor();
				activity.setVariables(temp, windSpeed, frontDoor);
				System.out.println(activity.getTemperature());
				System.out.println(activity.getWindSpeed());
				System.out.println(activity.getFrontDoor());
				Thread.sleep(10000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error !");
		}
	}
}
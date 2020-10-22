package com.project.providentia.system;

public class Sensor implements Runnable {

	SensorData activity = new SensorData();
	Randomizer randomizer = new Randomizer();
	
	@Override
	public void run() {
		while (true) {
			try {
//				System.out.println("Front Door Sensor: " + randomizer.getRandomFrontDoor());
//				System.out.println("Temperature: " + randomizer.getRandomTemperature());
//				System.out.println("Wind Speed: " + randomizer.getRandomWindSpeed());
				
				activity.setVariables(randomizer.getRandomTemperature(), randomizer.getRandomWindSpeed(), randomizer.getRandomFrontDoor());
				
				System.out.println();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

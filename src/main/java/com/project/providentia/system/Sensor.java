package com.project.providentia.system;

import javafx.application.Platform;

public class Sensor implements Runnable {

	private final int DURATION = 5;
	
	private SensorData sensorData;
	private Randomizer randomizer;
	
	public Sensor() {
		sensorData = SensorData.getInstance();
		randomizer = new Randomizer();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Platform.runLater(() -> {
					sensorData.setVariables(randomizer.getRandomTemperature(), randomizer.getRandomWindSpeed(), randomizer.getRandomFrontDoor());					
				});
				Thread.sleep(DURATION * 1000);
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
	}	
}

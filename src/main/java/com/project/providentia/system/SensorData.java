package com.project.providentia.system;

import java.util.ArrayList;

import com.project.providentia.system.observer.Observer;
import com.project.providentia.system.observer.Subject;

public class SensorData implements Subject {
	
	private volatile static SensorData instance;
	
	private ArrayList<Observer> observers;
	
	
	private double temperature;
	private double windSpeed;
	private boolean frontDoor;
	
	private SensorData() {
		this.observers = new ArrayList<Observer>();
	}
	
	public static SensorData getInstance() {
		if (instance == null) {
			synchronized (SensorData.class) {
				if (instance == null) instance = new SensorData();
			}
		}
		return instance;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		observers.remove(index);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.updateActivity(temperature, windSpeed, frontDoor);
		}
	}
	
	public void setVariables(double temperature, double windSpeed, boolean frontDoor) {
		setTemperature(temperature);
		setWindSpeed(windSpeed);
		setFrontDoor(frontDoor);
		notifyObservers();
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public boolean getFrontDoor() {
		return frontDoor;
	}

	public void setFrontDoor(boolean frontDoor) {
		this.frontDoor = frontDoor;
	}
}

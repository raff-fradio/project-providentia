package com.project.providentia.system;

import java.time.LocalTime;

public class Status implements Runnable {
	private boolean windShield;
	private boolean outdoorLight;
	private boolean AC;
	private boolean heater;
	private double wind;
	private double temp;
	private final LocalTime MORNING = LocalTime.parse("06:00:00");
	private final LocalTime EVENING = LocalTime.parse("18:00:00");
	private final double MAX_WIND_SPEED = 80;
	private final double HIGH_TEMP = 26;
	private final double LOW_TEMP = 18;
	private final LocalTime TIME_NOW = LocalTime.now();
	
	public Status(double wind, double temp) {
		this.wind = wind;
		this.temp = temp;
	}
	
	public Boolean getWindShield() {
		return windShield;
	}
	public void setWindShield() {
		if(wind >= MAX_WIND_SPEED) {
			this.windShield = true;
		} 
		this.windShield = false;
	}
	public boolean getOutdoorLight() {
		return outdoorLight;
	}
	public void setOutdoorLight() {
		if(TIME_NOW.isBefore(EVENING) && TIME_NOW.isAfter(MORNING)) {
			outdoorLight = false;
		} else {
			outdoorLight = true;
		}
	}
	public boolean getAC() {
		return AC;
	}
	public void setAC() {
		if(this.temp >= HIGH_TEMP) {
			AC = true;
		} else {
			AC = false;
		}
	}
	public boolean getHeater() {
		return heater;
	}
	public void setHeater() {
		if(this.temp <= LOW_TEMP) {
			heater = true;
		} else {
			heater = false;
		}
	}
	@Override
	public void run() {
		try {
			do {
				setWindShield();
				setOutdoorLight();
				setAC();
				setHeater();
				
				System.out.println(getWindShield());
				System.out.println(getOutdoorLight());
				System.out.println(getAC());
				System.out.println(getHeater());
				Thread.sleep(10000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error in Randomizer Thread !");
		}
		
	}
}
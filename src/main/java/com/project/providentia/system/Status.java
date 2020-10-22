package com.project.providentia.system;

import java.time.LocalTime;

public class Status implements Runnable {
	private Boolean windShield;
	private Boolean outdoorLight;
	private Boolean AC;
	private Boolean heater;
	private double wind;
	private double temp;
	LocalTime timeNow = LocalTime.now();
	
	public Status(double wind, double temp) {
		this.wind = wind;
		this.temp = temp;
	}
	
	public Boolean getWindShield() {
		return windShield;
	}
	public void setWindShield() {
		if(wind >= 80) {
			this.windShield = true;
		} 
		this.windShield = false;
	}
	public Boolean getOutdoorLight() {
		return outdoorLight;
	}
	public void setOutdoorLight() {
		LocalTime morning = LocalTime.parse("06:00:00");
		LocalTime evening = LocalTime.parse("18:00:00");
		if(timeNow.isBefore(evening) && timeNow.isAfter(morning)) {
			outdoorLight = false;
		} else {
			outdoorLight = true;
		}
	}
	public Boolean getAC() {
		return AC;
	}
	public void setAC() {
		if(this.temp >= 26) {
			AC = true;
		} else {
			AC = false;
		}
	}
	public Boolean getHeater() {
		return heater;
	}
	public void setHeater() {
		if(this.temp <= 18) {
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
package com.project.providentia.system;

public class Status {
	
	private boolean ac;
	private boolean heater;
	private boolean windShield;
	private boolean outdoorLight;
	
	public boolean isAC() {
		return ac;
	}
	public void setAC(boolean ac) {
		this.ac = ac;
	}
	public boolean isHeater() {
		return heater;
	}
	public void setHeater(boolean heater) {
		this.heater = heater;
	}
	public boolean isWindShield() {
		return windShield;
	}
	public void setWindShield(boolean windShield) {
		this.windShield = windShield;
	}
	public boolean isOutdoorLight() {
		return outdoorLight;
	}
	public void setOutdoorLight(boolean outdoorLight) {
		this.outdoorLight = outdoorLight;
	}
		
}
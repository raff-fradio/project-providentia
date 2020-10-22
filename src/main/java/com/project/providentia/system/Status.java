package com.project.providentia.system;

public class Status {
	
	public static final int SAFE_WIND_SPEED = 60;
	
	private boolean ac;
	private boolean heater;
	private boolean windShield;
	private boolean outdoorLight;
	private boolean guest;
	
	public Status() {
		ac = true;
		heater = false;
		windShield = true;
		outdoorLight = true;
		guest = false;
	}
	
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
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
	public boolean isGuest() {
		return guest;
	}
	public void setGuest(boolean guest) {
		this.guest = guest;
	}
	
}
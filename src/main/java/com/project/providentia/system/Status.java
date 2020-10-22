package com.project.providentia.system;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Status {
	
	public static final int SAFE_WIND_SPEED = 60;
	
	private BooleanProperty ac;
	private BooleanProperty heater;
	private BooleanProperty windShield;
	private BooleanProperty outdoorLight;
	private BooleanProperty guest;
	
	public Status() {
		this.ac = new SimpleBooleanProperty(this, "ac", true);
		this.heater = new SimpleBooleanProperty(this, "heater", false);
		this.windShield = new SimpleBooleanProperty(this, "windShield", false);
		this.outdoorLight = new SimpleBooleanProperty(this, "outdoorLight", false);
		this.guest = new SimpleBooleanProperty(this, "guest", false);
	}

	public BooleanProperty acProperty() {
		return ac;
	}

	public BooleanProperty heaterProperty() {
		return heater;
	}

	public BooleanProperty windShieldProperty() {
		return windShield;
	}

	public BooleanProperty outdoorLightProperty() {
		return outdoorLight;
	}

	public BooleanProperty guestProperty() {
		return guest;
	}
	
	
	public boolean getAc() {
		return ac.get();
	}
	public boolean getHeater() {
		return heater.get();
	}
	public boolean getWindShield() {
		return windShield.get();
	}
	public boolean getOutdoorLight() {
		return outdoorLight.get();
	}
	public boolean getGuest() {
		return guest.get();
	}
	
			
	public void setAc(boolean value) {
		ac.set(value);
	}
	public void setHeater(boolean value) {
		heater.set(value);
	}
	public void setWindShield(boolean value) {
		windShield.set(value);
	}
	public void setOutdoorLight(boolean value) {
		outdoorLight.set(value);
	}
	public void setGuest(boolean value) {
		guest.set(value);
	}
}
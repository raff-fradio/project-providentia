package com.project.providentia.system;

import java.util.HashMap;

public class Control {
	
	private int temperature;
	private HashMap<String, Boolean> lights;
	
	public Control() {
		this.temperature = 20;
		this.lights = new HashMap<String, Boolean>();
		
		lights.put("Bedroom", false);
		lights.put("Bathroom", false);
		lights.put("Kitchen", false);
		lights.put("Living Room", false);
	}
	
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public boolean getLight(String key) {
		return lights.get(key);
	}
	public void setLight(String key, boolean value) {
		lights.put(key, value);
	}
	public HashMap<String, Boolean> getAllLights() {
		return lights;
	}
	public void setAllLights(HashMap<String, Boolean> lights) {
		this.lights = lights;
	}
	
}
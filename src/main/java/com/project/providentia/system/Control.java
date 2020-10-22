package com.project.providentia.system;
public class Control {
	double temp;
	Boolean roomLight;
	Boolean blind;
//	ArrayList<Light> light = new ArrayList<Light>();
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public Boolean getLight() {
		return roomLight;
	}
	public void setLight(Boolean light) {
		this.roomLight = light;
	}
	public void checkLight() {
		System.out.println("Light is On !");
	}
	public Boolean getBlind() {
		return blind;
	}
	public void setBlind(Boolean blind) {
		this.blind = blind;
	}
	
}
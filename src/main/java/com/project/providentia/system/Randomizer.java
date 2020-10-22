package com.project.providentia.system;

import java.util.Random;

<<<<<<< HEAD
public class Randomizer implements Runnable{
=======
public class Randomizer implements Runnable {
>>>>>>> master
	public double getRandomTemp(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public double getRandomWindSpeed(double min, double max) {
		return (new Random().nextDouble()*(max-min)+min);
	}
	public Boolean getRandomFrontDoor() {
		return (new Random().nextBoolean());
	}
	public Boolean frontDoor() {
<<<<<<< HEAD
		do {
			int ran = 7;
			int rand = (new Random().nextInt()*(9-0)+0);
			if(rand==ran) {
				return true;
			}
		} while(true);
=======
			int ran = 7;
			int rand = (new Random().nextInt(9));
			if(rand==ran) {
				return true;
			}
			return false;
>>>>>>> master
	}
	@Override
	public void run() {
		Activity activity = new Activity();	
		try {
			do {
				double temp = getRandomTemp(-1,30);
				double windSpeed = getRandomWindSpeed(0,20);
<<<<<<< HEAD
				Boolean frontDoor = getRandomFrontDoor();
				
				activity.setVariables(temp, windSpeed, frontDoor);
				Thread.sleep(10000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error !");
=======
				Boolean frontDoor = frontDoor();
				activity.setVariables(temp, windSpeed, frontDoor);
				System.out.println(activity.getTemperature());
				System.out.println(activity.getWindSpeed());
				System.out.println(activity.getFrontDoor());
				Thread.sleep(1000);
			} while(true);
		} catch(InterruptedException e) {
			System.out.println("Error in Randomizer Thread !");
>>>>>>> master
		}
	}
}
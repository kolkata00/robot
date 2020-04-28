package com.robot;
import java.util.Random;

public class Robot {
	int batteryRemaining = 100;
	int talkCounter = 10;
	int hitsCharge = 5;
	
	public Robot() {
		
	}
	
	public void navigate(String objectFront, int pixels) {
		if (objectFront.equals("wall")) {
			goSideways();
		} else if (objectFront.equals("chair")) {
			jump();
		} else if (objectFront.equals("nothing")) {
			walkForward();
		} else {
			System.out.println("No such command.");
			return;
		}
		//detect mouse
		if(pixels % 2 == 0) {
			hit();
		}
	}
	
	void walkForward() {
		//walk forward
		talk();
	}
	void goSideways() {
		talk();
	}
	void hit() {
		if (hitsCharge > 0) {
			Random rand = new Random();
			if (rand.nextInt(9) + 1 == 5) {
				//Furniture destroyed
				talk();
			} else {
				//mouse destroyed
				talk();
			}
			
			hitsCharge--;
		} else {
			//no battery, try to charge
			charge();
		}
	}
	void jump() {
		talk();
	}
	void talk() {
		if (talkCounter % 2 == 0) {
			System.out.println("I am robottttt" + talkCounter);
		}
		
		if (talkCounter > 1) {
			talkCounter--;
		} else {
			talkCounter = 10;
		}
		
	}
	
	void charge() {
		//generate two numbers
		Random rand = new Random();
		int num1 = rand.nextInt(999) + 1;
		int num2 = rand.nextInt(999) + 1;
		if (num1 > num2) {
			hitsCharge = 5;
		}
		
		talk();
	}
}

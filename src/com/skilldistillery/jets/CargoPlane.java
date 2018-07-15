package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	public void loadCargo() {
		System.out.println("Loading...");
	}
	@Override
	public void fly() {
		System.out.println("I'm a giant metal whale");
	}
 
}

package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	public void fight() {
		
	}
	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}

}

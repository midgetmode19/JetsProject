package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	public FighterJet(String model) {
		super(model);
	}
	public void fight() {
		
	}
	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}
	public void fight(Jet jet) {
		System.out.println(getModel() + " shoots down " + jet.getModel());
	}

}

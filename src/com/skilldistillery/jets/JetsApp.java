package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApp {
	private Airfield airField = new Airfield();
	Scanner sc = new Scanner(System.in);

	public JetsApp() {

	}

	public static void main(String[] args) {
		JetsApp jetsApp = new JetsApp();
		jetsApp.launch();
		jetsApp.displayUserMenu();
		// on launch, populate jets array with 5 different types of jets.
		// array must have extra space for more jets.

	}

	public void launch() {
		Jet globemaster2 = new CargoPlane("C-17 Globemaster 2", 517, 6456, 220_000_000);
		Jet galaxy = new CargoPlane("C-5 Galaxy", 540, 7273, 224_290_000);
		Jet eagle = new FighterJet("F-15 Eagle", 1875, 2992, 30_000_000);
		Jet falcon = new FighterJet("F-16 Falcon", 1500, 2622, 18_800_000);
		Jet raptor = new FighterJet("F-22 Raptor", 1498, 1893, 150_000_000);
		
		airField.addJet(globemaster2);
		airField.addJet(galaxy);
		airField.addJet(eagle);
		airField.addJet(falcon);
		airField.addJet(raptor);

	}

	public void displayUserMenu() {
		// menu here
		int input;
		do {
			System.out.println("1. List fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Quit");
			System.out.println();
			input = sc.nextInt();
	
			if (input == 1) {
				System.out.println(airField);
			}
			else if (input == 2) {
				for (Jet jet : airField.getJets()) {
					if (jet != null) {
						jet.fly();
					}
				}
			}
			else if (input == 3) {
				//print jet info of fastest jet
				Jet fastestJet = null;
				for (Jet jet : airField.getJets()) {
					if (jet != null) {
						if (fastestJet == null || jet.getSpeed() > fastestJet.getSpeed()) {
							fastestJet = jet;
						}
					}
				}
				System.out.println(fastestJet);
			}
			else if (input == 4) {
				//print jet with longest range
				Jet farthestJet = null;
				for (Jet jet : airField.getJets()) {
					if (jet != null) {
						if (farthestJet == null || jet.getRange() > farthestJet.getRange()) {
							farthestJet = jet;
						}
					}
				}
				System.out.println(farthestJet);
			}
			else if (input == 5) {
				//load cargo jets
				for (Jet jet : airField.getJets()) {
					if (jet != null && jet.getClass().getSimpleName().equals("CargoPlane")) {
						System.out.print(jet.getModel() + " ");
						((CargoPlane)jet).loadCargo();
					}
				}
			
			}
			else if (input == 6) {
				//Dogfight!
			}
			else if (input == 7) {
				// user adds a jet to the airfield (stretch goal: sub-menu to
				// choose type of jet)
			}
			else if (input == 8) {
				System.out.println("Goodbye");
				sc.close();
				System.exit(0);
			}
			else {
				System.out.println("That is not a valid selection.");
			}
			System.out.println();
		} while (input != 8);
	}
	
}

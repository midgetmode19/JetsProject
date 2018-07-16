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
			} else if (input == 2) {
				for (Jet jet : airField.getJets()) {
					if (jet != null) {
						jet.fly();
					}
				}
			} else if (input == 3) {
				// print jet info of fastest jet
				Jet fastestJet = null;
				for (Jet jet : airField.getJets()) {
					if (jet != null) {
						if (fastestJet == null || jet.getSpeed() > fastestJet.getSpeed()) {
							fastestJet = jet;
						}
					}
				}
				System.out.println(fastestJet);
			} else if (input == 4) {
				// print jet with longest range
				Jet farthestJet = null;
				for (Jet jet : airField.getJets()) {
					if (jet != null) {
						if (farthestJet == null || jet.getRange() > farthestJet.getRange()) {
							farthestJet = jet;
						}
					}
				}
				System.out.println(farthestJet);
			} else if (input == 5) {
				// load cargo jets
				for (Jet jet : airField.getJets()) {
					if (jet != null && jet.getClass().getSimpleName().equals("CargoPlane")) {
						System.out.print(jet.getModel() + " ");
						((CargoPlane) jet).loadCargo();
					}
				}

			} else if (input == 6) {
				dogFight();
			} else if (input == 7) {
				// user adds a jet to the airfield (stretch goal: sub-menu to
				// choose type of jet)
			} else if (input == 8) {
				System.out.println("Goodbye");
				sc.close();
				System.exit(0);
			} else {
				System.out.println("That is not a valid selection.");
			}
			System.out.println();
		} while (input != 8);
	}

	public void dogFight() {
		System.out.println("Dogfight!!");
		// same idea as mayhem from animal sanctuary project
		Jet[] jets = airField.getJets();

		int numJets = airField.getNumJets();
		int fighterJetIndex = selectStartingJet(jets);

		boolean fighterJetFound = true;
		if (fighterJetIndex < 0) {
			System.out.println("There are no fighter Jets.");
			fighterJetFound = false;
		}
		while (numJets > 1 && fighterJetFound) {
			FighterJet f = null;
			for (int i = fighterJetIndex; i < jets.length; i++) {
				if ((jets[i] instanceof FighterJet)) {
					f = (FighterJet) jets[i];
					int index = chooseNonNullOtherIndex(f, jets);
					if (index != -1) {
						f.fight(jets[index]);
						jets[index] = null;
						numJets--;
					}
				}
			}
			fighterJetIndex = 0;
			System.out.println(f.getModel() + " wins the fight");
		}
	}

	private int selectStartingJet(Jet[] jets) {
		int jetsIndex = -1; // get indexes of fighter jets
		int[] jetsIndexes = calculateFighterJetIndexes(jets);

		if (jetsIndexes.length == 0) {
			return jetsIndex;
		}

		int randomJetIndex = (int) (Math.random() * jetsIndexes.length);
		jetsIndex = jetsIndexes[randomJetIndex];
		return jetsIndex;
	}

	private int[] calculateFighterJetIndexes(Jet[] jets) {
		int num = 0;
		for (int i = 0; i < jets.length; i++) {
			Jet jet = jets[i];
			if (jet instanceof FighterJet) {
				num++;
			}
		}
		int[] fighterJets = new int[num];
		if (num > 0) {
			num = 0;
			for (int i = 0; i < jets.length; i++) {
				Jet jet = jets[i];
				if (jet instanceof FighterJet) {
					fighterJets[num++] = i;
				}
			}
		}
		return fighterJets;
	}

	public int chooseNonNullOtherIndex(Jet fighter, Jet[] allJets) {
		int index = -1;
		int[] nonNullIndexes = new int[allJets.length];
		int nextNonNullSlot = 0;

		for (int i = 0; i < allJets.length; i++) {
			if (allJets[i] != null && allJets[i] != fighter) {
				nonNullIndexes[nextNonNullSlot] = i;
				nextNonNullSlot++;
			}
		}
		if (nextNonNullSlot > 0) {
			int whichIndex = (int) (Math.random() * nextNonNullSlot);
			index = nonNullIndexes[whichIndex];
		}
		return index;
	}
	public void listJets() {
		Jet[] jets = airField.getJets();
		for (Jet jet : jets) {
			if (jet != null) {
				System.out.println(jet.getModel());
			}
		}
	}

}

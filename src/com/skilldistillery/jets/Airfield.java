package com.skilldistillery.jets;

import java.util.Arrays;

public class Airfield {
	private Jet[] jets = new Jet[20];
	private int i = 0;
	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

	public Airfield() {
		super();
	}
	public void addJet(Jet jet) {
		jets[i++] = jet;
	}

	@Override
	public String toString() {
		String jetsList = "";
		for (Jet jet : jets) {
			if (jet != null) {
				jetsList += jet + "\n";				
			}
		}
		return jetsList;	
	}

	
	
}

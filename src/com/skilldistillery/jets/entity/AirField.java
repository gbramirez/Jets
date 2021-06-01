package com.skilldistillery.jets.entity;

import java.util.*;

public class AirField {
	private List<Jet> jets;

	public AirField() {
		jets = new ArrayList<Jet>();
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	}

package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entity.AirField;
import com.skilldistillery.jets.entity.CargoPlane;
import com.skilldistillery.jets.entity.FighterJet;
import com.skilldistillery.jets.entity.Jet;
import com.skilldistillery.jets.entity.JetImpl;

import java.io.*;
import java.util.*;

public class JetsApplication {
	private AirField airfield;
	private Scanner keyboard = new Scanner(System.in);

	public JetsApplication() {
		airfield = new AirField();
	}

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
		app.displayMenu();

	}

	public void launch() {
		List<Jet> jets = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("jets.txt"));

			String line = null;
			while ((line = reader.readLine()) != null) {

				String[] planeDetails = line.split(",");
				String subclass = planeDetails[0].trim();
				String model = planeDetails[1].trim();
				double speed = Double.parseDouble(planeDetails[2].trim());
				int range = Integer.parseInt(planeDetails[3].trim());
				double price = Double.parseDouble(planeDetails[4].trim());

				if (subclass.equals("FighterJet")) {
					Jet fj = new FighterJet(model, speed, range, price);
					jets.add(fj);
				}

				if (subclass.equals("CargoPlane")) {
					Jet cp = new CargoPlane(model, speed, range, price);
					jets.add(cp);
				} 
				if (subclass.equals("JetImpl")) {
					Jet ca = new JetImpl(model, speed, range, price);
					jets.add(ca);
				}

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		airfield.setJets(jets);

	}
	
	private void displayAirField() {
		List<Jet> allJets = airfield.getJets();
		for (Jet jet : allJets) {
			System.out.println(jet);
		}
	}

	private void flyAllJets() {
		List<Jet> allJets = airfield.getJets();
		for (Jet jet : allJets) {
			jet.fly();
		}
	}
	
	private void fastestJet() {
		List<Jet> allJets = airfield.getJets();
		Comparator<Jet> comparator = Comparator.comparing(Jet::getSpeed);
		Jet fastest = allJets.stream().max(comparator).get();
		System.out.println("The fastest jet is:\n" + fastest);
		System.out.println("It's speed in mach is " + fastest.getMachSpeed(fastest.getSpeed()));

	}

	private void longestRange() {
		List<Jet> allJets = airfield.getJets();
		Comparator<Jet> comparator = Comparator.comparing(Jet::getRange);
		Jet longest = allJets.stream().max(comparator).get();
		System.out.println("The jet with the longest range is:\n" + longest);

	}
	
	private void displayMenu() {
		int userChoice = 0;
		while (userChoice != 5) {
	System.out.println("Welcome to the airfield, pilot!");
	System.out.println("\nSelect an option from the list below: ");
	System.out.println("\n1. Show all jets.");
	System.out.println("\n2. Fly all jets.");
	System.out.println("\n3. View fastest jet.");
	System.out.println("\n4. View jest with longest range.");
	System.out.println("\n5. Quit.");
	
	userChoice = keyboard.nextInt();
	
	switch(userChoice) {
	case 1:
		displayAirField();
		break;
	
	case 2:
		flyAllJets();
		break;
		
	case 3:
		fastestJet();
		break;
		
	case 4:
		longestRange();
		break;
		
	case 5:
		System.out.println("\nFarewell, pilot! Next time, bring a helmet!");
		break;
	
	default:
		System.out.println("\nInvalid choice. Try again, pilot!");
		break;
	}
}
}
}
package com.skilldistillery.jets.entity;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private double price;

	public Jet(String model, double speed, int range, double price) {

		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setSpeed(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract void fly();

	public double getMachSpeed(double MPH) {
		double machSpeed = MPH / 767.21;
		return machSpeed;
	}

}

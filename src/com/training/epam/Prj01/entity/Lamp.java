package com.training.epam.Prj01.entity;

public class Lamp extends PartOfTheBuilding{

	private int power;
	private String name;
	
	public Lamp() {
		super();
	}

	public Lamp(String name, int power) {
		super(name);
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Lamp power=" + power ;
	}
	
}

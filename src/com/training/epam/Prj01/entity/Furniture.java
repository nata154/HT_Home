package com.training.epam.Prj01.entity;

public class Furniture extends PartOfTheBuilding {

	private String name;
	private int squareFurniture;

	public Furniture() {
		super();
	}

	public Furniture(String name, int square) {
		this.name = name;
		this.squareFurniture = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSquare() {
		return squareFurniture;
	}

	public void setSquare(int square) {
		this.squareFurniture = square;
	}

	@Override
	public String toString() {
		return "Furniture: " + getNamePartOfTheBuilding() +" "+ squareFurniture + "m2";
	}
}

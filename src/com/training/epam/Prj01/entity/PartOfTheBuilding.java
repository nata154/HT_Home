package com.training.epam.Prj01.entity;

public class PartOfTheBuilding {

	private String namePartOfTheBuilding;

	public PartOfTheBuilding() {

	}

	public PartOfTheBuilding(String namePartOfTheBuilding) {
		super();
		this.namePartOfTheBuilding = namePartOfTheBuilding;
	}

	public String getNamePartOfTheBuilding() {
		return namePartOfTheBuilding;
	}

	public void setNamePartOfTheBuilding(String namePartOfTheBuilding) {
		this.namePartOfTheBuilding = namePartOfTheBuilding;
	}

	@Override
	public String toString() {
		return "PartOfTheBuilding  " + namePartOfTheBuilding + "]";
	}

}

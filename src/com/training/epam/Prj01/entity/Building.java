package com.training.epam.Prj01.entity;

import java.util.ArrayList;
import java.util.List;

public class Building extends PartOfTheBuilding{
	
	List<RoomMaker> building;
	RoomMaker roomMaker = new RoomMaker();

	public Building() {
		this.building = new ArrayList<RoomMaker>();
	}
	
	public Building(List<RoomMaker> building) {
		this.building = building;
	}
	
	//Don't work
	public List<RoomMaker> getBuilding() {
		return building;
	}
	
	//Don't work
	public void setBuilding(List<RoomMaker> building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Building [building=" + building + "]";
	}
	


	//Don't work
	public void describe() {
	for (RoomMaker p: building) {
		p.describe();
	}

}
}

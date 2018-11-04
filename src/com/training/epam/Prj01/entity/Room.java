package com.training.epam.Prj01.entity;

public class Room extends PartOfTheBuilding{
	
	private String name;
	private int square;
	private int numWindow;
		
	public Room() {
		super();
	}

	public Room(String name, int square, int numWindow) {
		super(name);
		this.square = square;
		this.numWindow = numWindow;
	}
	
	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumWindow() {
		return numWindow;
	}

	public void setNumWindow(int numWindow) {
		this.numWindow = numWindow;
	}

	@Override
	public String toString() {
		return getNamePartOfTheBuilding() + " square=" + square + ", numWindow=" + numWindow + "]";
	}

	//	List<PartOfTheBuilding> room;
//	PartOfTheBuilding partOfTheBuilding = new PartOfTheBuilding();
//
//	public List<PartOfTheBuilding> getRoom() {
//		return room;
//	}
//
//	public void setRoom(List<PartOfTheBuilding> room) {
//		this.room = room;
//	}
//	
//	public void addRoom(PartOfTheBuilding placement, PartOfTheBuilding furniture, PartOfTheBuilding lamp ) {
//		PartOfTheBuilding placement = new Placement();
//		PartOfTheBuilding furniture = new Furniture();
//		PartOfTheBuilding lamp = new Lamp();
//		room.add(placement);
//		room.add(furniture);
//		room.add(lamp);
//	}
//	
//	public void add (PartOfTheBuilding partOfTheBuilding) {
//		this.partOfTheBuilding = partOfTheBuilding;
	
	}


	


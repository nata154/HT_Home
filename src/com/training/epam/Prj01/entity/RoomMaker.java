package com.training.epam.Prj01.entity;

import java.util.ArrayList;
import java.util.List;

import com.training.epam.Prj01.exception.IlluminanceTooMuchException;
import com.training.epam.Prj01.exception.SpaceUsageTooMuchException;

public class RoomMaker {

	List<PartOfTheBuilding> roomMaker;

	public RoomMaker() {
		this.roomMaker = new ArrayList<PartOfTheBuilding>();
	}

	public void addPart(PartOfTheBuilding pB) {
		roomMaker.add(pB);
	}

	public void describe() {
		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Room) {
				System.out.println(roomMaker.get(i).getNamePartOfTheBuilding());
				Room room = (Room) roomMaker.get(i);
				System.out.println("Square is: " + room.getSquare() + "m2");
			}
		}

		int numLamp = 0;
		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Lamp) {
				// Lamp lamp = new Lamp();
				numLamp++;
			}
		}
		System.out.println("Number of Lamps is: " + numLamp);

		System.out.println("Furniture:");
		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Furniture) {
				Furniture furniture = (Furniture) roomMaker.get(i);
				System.out.println(furniture.getName() + "  " + furniture.getSquare() + " m2.");
			}
		}
	}

	public void checkIlluminance(RoomMaker rm) throws IlluminanceTooMuchException {
		int illuminsanceLamp = 0;
		int illuminsanceWindow = 0;
		int illuminsanceWindowPower = 700;

		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Lamp) {
				Lamp lamp = (Lamp) roomMaker.get(i);
				illuminsanceLamp = illuminsanceLamp + lamp.getPower();
			}
		}

		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Room) {
				Room room = (Room) roomMaker.get(i);
				illuminsanceWindow = illuminsanceWindowPower * room.getNumWindow();
			}
		}

		int sumIlluminance = illuminsanceLamp + illuminsanceWindow;
		System.out.println("Illuminance is: " + sumIlluminance + " lk.");
		if (sumIlluminance < 300 || sumIlluminance > 4000) {
			throw new IlluminanceTooMuchException("Problem with illuminance!");
		} else {
			System.out.println("There is no problems with illuminance!");
		}
	}

	
	public void checkSpaceUsage(RoomMaker rm) throws SpaceUsageTooMuchException {
		int sumSpaceFurniture = 0;
		double koef = 0.7;
		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Furniture) {
				Furniture furniture = (Furniture) roomMaker.get(i);
				int spaceFurniture = furniture.getSquare();
				sumSpaceFurniture = sumSpaceFurniture + spaceFurniture;
			}
		}

		for (int i = 0; i < roomMaker.size(); i++) {
			if (roomMaker.get(i) instanceof Room) {
				Room room = (Room) roomMaker.get(i);
				int s = room.getSquare();
				System.out.println("Square of room is: " + s + "m2");
				System.out.println("Space usage is: " + sumSpaceFurniture + " m2.");
				if (sumSpaceFurniture > s * koef) {
					throw new SpaceUsageTooMuchException("Problem with amount of furniture!");
				}
			}
		}
	}

	
	@Override
	public String toString() {
		return "Room" + roomMaker;
	}

}

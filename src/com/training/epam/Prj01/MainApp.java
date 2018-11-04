package com.training.epam.Prj01;

import java.util.ArrayList;
import java.util.List;

import com.training.epam.Prj01.entity.Furniture;
import com.training.epam.Prj01.entity.Lamp;
import com.training.epam.Prj01.entity.Room;
import com.training.epam.Prj01.entity.RoomMaker;
import com.training.epam.Prj01.exception.IlluminanceTooMuchException;
import com.training.epam.Prj01.exception.SpaceUsageTooMuchException;

public class MainApp {

	public static void main(String[] args) throws IlluminanceTooMuchException {

		// List<PartOfTheBuilding> roomMaker1;
		List<RoomMaker> building = new ArrayList<RoomMaker>();

		RoomMaker roomMaker1 = new RoomMaker();
		Room room1 = new Room("Room 1", 100, 3);
		Lamp lamp1_1 = new Lamp("Lamp 1", 400);
		Lamp lamp2_1 = new Lamp("Lamp 2", 800);
		Furniture furniture1_1 = new Furniture("Sofa", 60);
		Furniture furniture2_1 = new Furniture("Wardrobe", 30);

			roomMaker1.addPart(room1);
			roomMaker1.addPart(lamp1_1);
			roomMaker1.addPart(lamp2_1);
			roomMaker1.addPart(furniture1_1);
			roomMaker1.addPart(furniture2_1);
			building.add(roomMaker1);
			roomMaker1.describe();
			
			try {
				roomMaker1.checkIlluminance(roomMaker1);
		} catch (IlluminanceTooMuchException ex) {
			ex.printStackTrace();
		}
			
			try {
				roomMaker1.checkSpaceUsage(roomMaker1);
		} catch (SpaceUsageTooMuchException ex) {
			ex.printStackTrace();
		}
		
System.out.println();

		RoomMaker roomMaker2 = new RoomMaker();
		Room room2 = new Room("Room 2", 1000, 0);
		Lamp lamp1_2 = new Lamp("Lamp 1", 4);
		Lamp lamp2_2 = new Lamp("Lamp 2", 8);
		Lamp lamp2_3 = new Lamp("Lamp 2", 8);
		Furniture furniture1_2 = new Furniture("Sofa", 200);
		Furniture furniture2_2 = new Furniture("Wardrobe", 300);

			roomMaker2.addPart(room2);
			roomMaker2.addPart(lamp1_2);
			roomMaker2.addPart(lamp2_2);
			roomMaker2.addPart(lamp2_3);
			roomMaker2.addPart(furniture1_2);
			roomMaker2.addPart(furniture2_2);
			building.add(roomMaker2);
			roomMaker2.describe();
		
		try {
			roomMaker2.checkIlluminance(roomMaker2);
	} catch (IlluminanceTooMuchException ex) {
		ex.printStackTrace();
	}

		// Don't work, WHY?
//		((RoomMaker) building).describe();

		System.out.println();
		for (RoomMaker p : building) {
			System.out.println(p);
		}

	}
/**Задание 1. Представим, что мы разрабатываем некий модуль системы проектирования помещений. У помещения есть такой параметр, как площадь, и известно, что предметы в помещении не должны занимать более 70% площади. Также известно, что освещённость помещения не должна выходить за пределы 300-4000 лк (каждое окно даёт освещённость помещения 700 лк, каждая лампочка даёт такую освещённость, как указано в её параметрах).

Создайте структуру классов и интерфейсов, позволяющую создавать здания (состоящие из помещений), помещения (с указанием их площади и количества окон), а также добавлять в помещение произвольное количество лампочек (пока не будет превышена максимальная освещённость в 4000 лк) и произвольное количество произвольных предметов (пока их суммарная площадь не превышает 70% площади помещения).

При попытке превысить освещённость должно быть порождено исключение IlluminanceTooMuchException, а при попытке превысить 70% площади добавляемым предметом должно быть порождено исключение SpaceUsageTooMuchException.

Предполагается, что использовать вашу библиотеку будут примерно так (написано в псевдокоде):

Здание building = new Здание("Здание 1");
building.addRoom("Комната 1", 100м2, 3окна);
building.addRoom("Комната 2", 5м2, 2окна);
building.getRoom("Комната 1").add(new Лампочка(150));
building.getRoom("Комната 1").add(new Лампочка(250));
building.getRoom("Комната 1").add(new Стол("Стол письменный", 3м2));
building.getRoom("Комната 1").add(new КреслоМягкое("Кресло мягкое и пушистое", от1м2, до2м2));
building.describe();

Пример вывода building.describe():
Здание 1
 Комната 1
  Освещённость = 2500 (3 окна по 700 лк, лампочки 150 лк и 250 лк)
  Площадь = 100 м^2 (занято 4-5 м^2, гарантированно свободно 95 м^2 или 95% площади)
  Мебель:
   Стол письменный (площадь 3 м^2)
   Кресло мягкое и пушистое (площадь от 1 м^2 до 2 м^2)
 Комната 2
  Освещённость = 1400 (2 окна по 700 лк)
  Площадь = 5 м^2 (свободно 100%)
  Мебели нет**/
}

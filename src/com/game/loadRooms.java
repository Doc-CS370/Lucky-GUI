package com.game;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class loadRooms {

	public static room[] compileMansion() throws FileNotFoundException {
		room[] Room = new room[32];
		Scanner mapIn = new Scanner(loadRooms.class.getResourceAsStream("/assets/rooms.txt"));

		for (int i = 0; mapIn.hasNext(); i++) {
			Room[i] = new room();
			Room[i].setRoomNumber(mapIn.nextInt());
			mapIn.nextLine();
			String adjacentRooms = mapIn.nextLine();
			String[] adjacentStringArray = adjacentRooms.split(",");
			int[] adjacentIntArray = new int[adjacentStringArray.length];
			for (int i2 = 0; i2 < adjacentStringArray.length; i2++) {
				String numberAsString = adjacentStringArray[i2];
				adjacentIntArray[i2] = Integer.parseInt(numberAsString);
			}
			Room[i].setAdjacentRooms(adjacentIntArray);

			String sightlinesString = mapIn.nextLine();
			String[] sightlinesStringArray = sightlinesString.split(",");
			int[] sightlinesIntArray = new int[sightlinesStringArray.length];
			for (int i2 = 0; i2 < sightlinesStringArray.length; i2++) {
				String numberAsString = sightlinesStringArray[i2];
				sightlinesIntArray[i2] = Integer.parseInt(numberAsString);
			}
			Room[i].setRoomSightlines(sightlinesIntArray);

			Room[i].setRoomFlavor(mapIn.nextLine());
			// System.out.println("LOADED:");
			// Room[i].print();
		}
		mapIn.close();

		return Room;
	}
}

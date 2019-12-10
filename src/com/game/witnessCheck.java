package com.game;

public class witnessCheck {
	static boolean checkForWitness(room[] Room, player[] player, int activeTurn) {
        boolean witnessPresent = false;
 
        int murderSite = player[activeTurn].getLocation();
        int numberOfRoomsToCheck = Room[murderSite].getNumberOfSightlines();
 
        System.out.println(numberOfRoomsToCheck + " ROOMS TO CHECK");
        int[] roomsToCheck = Room[murderSite].getRoomSightlines();
 
        System.out.print("PEOPLE IN MURDER ROOM : ");
        System.out.println(Room[0].getNumberOfOccupants());
 
        int numberOfPeopleInSightlines = Room[murderSite].getNumberOfOccupants();
 
        for (int i = 0; i < numberOfRoomsToCheck; i++) {
            numberOfPeopleInSightlines = numberOfPeopleInSightlines + Room[roomsToCheck[i]].getNumberOfOccupants();
 
            System.out.println("Checked room: " + Room[roomsToCheck[i]].getRoomFlavor() + ".....there are "
                    + Room[roomsToCheck[i]].getNumberOfOccupants() + " people. here");
        }
 
        System.out.println(numberOfPeopleInSightlines + " TOTAL WITNESSES");
 
        if (numberOfPeopleInSightlines > 2) {
            witnessPresent = true;
            System.out.println("MURDER IMPOSSIBLE");
        } else {
            System.out.println("MURDER POSSIBLE");
        }
 
        return witnessPresent;
    }
}


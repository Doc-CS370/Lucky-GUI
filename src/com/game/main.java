package com.game;


import java.io.FileNotFoundException;
import java.util.Arrays;

public class main {
	// 0 = Doctor Lucky 
	
	 
	 
	    public static void main(String[] args) {
	 
	        card[] Card = new card[98];
	 
	        try {
	            Card = loadCards.compileDeck();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	 
	        room[] Room = new room[32];
	 
	        try {
	            Room = loadRooms.compileMansion();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	       
	       
	       
	        //Room[11].print();
	        //Card[96].print();
	        //Card[97].print();
	        //player Player = new player();
	        //Card = Player.drawSevenCards(Card);
	        //Card = Player.drawCard(Card);
	       
	        //murder check test
	        player player[] = new player[9];
	       
	        player[0]= new player();
	        player[1]= new player();
	        player[2]= new player();
	        player[3]= new player();
	        player[4]= new player();
	        player[5]= new player();
	        player[6]= new player();
	        player[7]= new player();
	        player[8]= new player();
	       
	        player[0].setLocation(0);
	        player[1].setLocation(6);
	        player[2].setLocation(0);
	        player[3].setLocation(14);
	        player[4].setLocation(14);
	        player[5].setLocation(14);
	        player[6].setLocation(14);
	        player[7].setLocation(14);
	        player[8].setLocation(14);
	       
	        player[0].setAlive();
	        player[1].setAlive();
	        player[2].setAlive();
	        player[3].setAlive();
	        player[4].setAlive();
	        player[5].setAlive();
	        player[6].setAlive();
	        player[7].setAlive();
	        player[8].setAlive();
}
}

package com.game;

import java.io.FileNotFoundException;
//import java.util.Scanner;

public class GlobalValues {
	private static GlobalValues gV = null;
	
	public player[] Player;
	public card[] Card;
	public room[] Room;
	
	private GlobalValues() {
		Card = new card[98];
		 
        try {
            Card = loadCards.compileDeck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        Room = new room[32];
 
        try {
            Room = loadRooms.compileMansion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public static GlobalValues GlobalValues() {
		if (gV == null) 
        { 
            gV = new GlobalValues(); 
        } 
        return gV; 
	}
	//Test that global works
	/*
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		GlobalValues s = GlobalValues.GlobalValues();
		GlobalValues v = GlobalValues.GlobalValues();
		
		s.Player = new player[9];
	    
		int numPlayers;
		do {
			System.out.println("Enter the number of players(3-7)");
			numPlayers = sc.nextInt();
		}while(numPlayers >3 && numPlayers<8);
		for (int i = 0; i < 8; i++) {
			if(i == 0) {
				s.Player[0] = new player();
				s.Player[0].setAlive();
				s.Player[0].setName("Dr.Lucky");
				s.Player[0].setLocation((int)(Math.random() * 20));
				s.Player[0].print();
			}
			else if(i>=1 && i<=numPlayers) {
				s.Player[i] = new player();
				s.Player[i].setAlive();
				s.Player[i].setName("Player " + Integer.toString(i));
				s.Player[i].setLocation(0);
				eventHandler.drawCard(s.Card, s.Player, i);
				eventHandler.drawCard(s.Card, s.Player, i);	
				eventHandler.drawCard(s.Card, s.Player, i);
				eventHandler.drawCard(s.Card, s.Player, i);
				eventHandler.drawCard(s.Card, s.Player, i);
				eventHandler.drawCard(s.Card, s.Player, i);
				s.Player[i].print();
			}
			else {
				s.Player[i] = new player();	
			}
			
		}
		
		eventHandler.drawCard(v.Card, v.Player, 1);
		v.Player[1].print();
	}
	*/
}

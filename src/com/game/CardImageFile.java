package com.game;

import java.io.FileNotFoundException;


public class CardImageFile {
	
	private static String i;

	public static void initializeCards(card[] cards) {
		
		i = Integer.toString(cards[5].getCardNumber());
	}

	public static void main(String[]args) {
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
       
        initializeCards(Card); 
		System.out.println(i);
		
	}
	

}

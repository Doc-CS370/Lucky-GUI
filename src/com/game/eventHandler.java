package com.game;


import java.util.Arrays;

public class eventHandler {
	public static void move(player[] player, room[] Room, int targetRoom, int playerNum) {
        Room[player[playerNum].getLocation()].removeOccupant();
        Room[targetRoom].addOccupant();
        player[playerNum].setLocation(targetRoom);
 
    }
 
    public static void useRoomCard(room[] Room, card[] Card, player[] player, int cardNum, int targetPlayer,
            int usingPlayer) {
 
        Card[cardNum].setCardStatus(2);
        player[usingPlayer].removeCard(cardNum);
        // System.out.println("////////////////ATTEMPTING USE OF CARD//////////////");
        // Card[cardNum].print();
        // System.out.println("////////////////////////////////////////////////////");
 
        // System.out.println("TARGET PLAYER: " + targetPlayer);
        // System.out.println("CURRENT LOCATION: " +
        // player[targetPlayer].getLocation());
        // System.out.println("CURRENT ROOM POPULATION: " +
        // Room[player[targetPlayer].getLocation()].getNumberOfOccupants());
        // System.out.println("CARD VALUE: " + Card[cardNum].getCardValue());
        Room[player[targetPlayer].getLocation()].removeOccupant();
        Room[Card[cardNum].getCardLocation()].addOccupant();
        player[targetPlayer].setLocation(Card[cardNum].getCardLocation());
        // System.out.println("////////////////////////////////////////////////////");
        // System.out.println("TARGET PLAYER: " + targetPlayer);
        // System.out.println("CURRENT LOCATION: " +
        // player[targetPlayer].getLocation());
        // System.out.println("CURRENT ROOM POPULATION: " +
        // Room[player[targetPlayer].getLocation()].getNumberOfOccupants());
    }
 
    public static void useMoveCard(card[] Card, player[] player, int cardNum, int playerTurn) {
        Card[cardNum].setCardStatus(2);
        player[playerTurn].removeCard(cardNum);
        // System.out.println("////////////////ATTEMPTING USE OF CARD//////////////");
        // Card[cardNum].print();
        // System.out.println("////////////////////////////////////////////////////");
 
        // System.out.println("CURRENT TURNS LEFT: " +
        // player[playerTurn].getTurnsLeft());
        // System.out.println("ATTEMPTING TO ADD " + Card[cardNum].getCardValue() + "
        // MOVES");
        player[playerTurn].addTurns(Card[cardNum].getCardValue());
        // System.out.println("PLAYER NOW HAS " + player[playerTurn].getTurnsLeft() + "
        // TURNS");
    }
 
    public static int useWeaponCard(player[] player, int playernum, card[] Card, int cardNum,
            boolean specialAttackActive) {
 
        Card[cardNum].setCardStatus(2);
        player[playernum].removeCard(cardNum);
        int murderValue;
        if (specialAttackActive == true) {
            murderValue = Card[cardNum].getCardSpecialValue();
            System.out.println("CARD IS SPECIAL");
        } else {
            murderValue = Card[cardNum].getCardValue();
            System.out.println("CARD IS NOT SPECIAL");
        }
 
        return murderValue;
    }
 
    public static int useFailureCard(player[] player, int playernum, card[] Card, int cardNum) {
 
        Card[cardNum].setCardStatus(2);
        player[playernum].removeCard(cardNum);
        int failure = Card[cardNum].getCardValue();
 
        return failure;
    }
 
    public static void drawCard(card[] Card, player[] player, int playerNum) {
    	

        /*
         * int hasDrawn = 0;
         *
         * while (hasDrawn == 0) { int randInt = (int) (Math.random() * 97); if
         * (Card[randInt].getCardStatus() == 0) { player[playerNum].addCard(randInt);
         * Card[randInt].setCardStatus(1); hasDrawn++;
         *
         *
         * }
         *
         * }
         */
 
        // Create undrawn array
        // Supports a maximum of 200 cards
        int[] eligibleCards = new int[200];
        Arrays.fill(eligibleCards, 999);
        // 999 means null
 
        int cnt = 0;
        int deckCheck = 0;
        for (int i = 1; i < Card.length; i++) {
            if (Card[i].getCardStatus() == 0) {
 
                eligibleCards[cnt] = Card[i].getCardNumber();
                cnt++;
            }
 
        }
 
       
       
       
       
       
        if (cnt == 0) {
            for (int i = 1; i < Card.length; i++) {
                if(Card[i].getCardStatus() == 2) {
                    Card[i].setCardStatus(0);
                    deckCheck++;
                }
                if(deckCheck == 0) {
                   
                    System.out.println("ERROR! OUT OF CARDS, CANNOT DRAW");
                }
               
               
            }
        } else {
 
            int randInt = (int) (Math.random() * cnt);
            player[playerNum].addCard(eligibleCards[randInt]);
            Card[eligibleCards[randInt]].setCardStatus(1);
 
        }
 
    }
    
    public static boolean killDoctorLucky(int playernum, int weaponPower, card[] Card, player[] Player, room[] Room) {
        
        boolean success = false;
        int failureValue = MapGame.failureValue;
 
        if(witnessCheck.checkForWitness(Room, Player, playernum) == false) {
       /* 	
        for (int i = 1; i < 8; i++) {
            if (Player[i].getStatus() == true && i != playernum) {
            	
                // GIVE PLAYER CHANCE TO USE FAILURE CARD
 
                //int cardNum = 1; // HARD CODE TEST VALUE
               //failureValue = failureValue + useFailureCard(Player, i, Card, cardNum);
            }
        }
        */
       
        if(failureValue < weaponPower) { success = true; System.out.println("Player " + playernum +" YOU KILLED DOCTOR LUCKY");}
        }
       
        return success;
    }
	}


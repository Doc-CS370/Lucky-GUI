package com.game;



import java.awt.Graphics;

public class GetCardLocation {
	static int currentCardNumber;
	static int[] playerHand = { Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(0))),
			Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(1))),
			Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(2))),
			Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(3))),
			Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(4))),
			Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(5)))};
	static boolean isEnabled = true;

	public static void CheckForCardLocation(int x, int y, Graphics g) {
		if(x>220 && x<340 && y>640 && y<785) {
			HighlightCards.updateCardHighLights(0);
			HighlightCards.paintHighlights(g);
			currentCardNumber = playerHand[0];

		}
		else if(x>360 && x<480 && y>640 && y<785) {
			HighlightCards.updateCardHighLights(1);
			HighlightCards.paintHighlights(g);
			currentCardNumber = playerHand[1];
		}
		else if(x>500 && x<620 && y>640 && y<785) {
			HighlightCards.updateCardHighLights(2);
			HighlightCards.paintHighlights(g);
			currentCardNumber = playerHand[2];
		}
		else if(x>640 && x<760 && y>640 && y<785) {
			HighlightCards.updateCardHighLights(3);
			HighlightCards.paintHighlights(g);
			currentCardNumber = playerHand[3];
		}
		else if(x>780 && x<900 && y>640 && y<785) {
			HighlightCards.updateCardHighLights(4);
			HighlightCards.paintHighlights(g);
			currentCardNumber = playerHand[4];
		}
		else if(x>920 && x<1040 && y>640 && y<785) {
			HighlightCards.updateCardHighLights(5);
			HighlightCards.paintHighlights(g);
			currentCardNumber = playerHand[5];
		}
	}

	public static void printPlayerHand() {
		for(int i = 0; i>playerHand.length;i++) {
			System.out.println("PlayerHand" + i + ":" + playerHand[i]);
		}
	}

	public static void updatePlayerHand(int[] i) {
		for(int j = 0; j<playerHand.length;j++) {
			playerHand[j] = Integer.parseInt(PaintPanel.getP1Value(MapGame.getCardValue(j)));
		}
	}

	public static void updatePlayerHandTurn() {
		for(int j = 0; j<playerHand.length;j++) {
			playerHand[j] = Integer.parseInt(PaintPanel.getP1Value(j));
		}
	}
}

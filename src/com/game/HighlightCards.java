package com.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HighlightCards {
	private static boolean checkCards[] = {false,false,false,false,false,false};
	public static void paintHighlights(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//Card 1 Highlights
		if(checkCards[0] == true) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.red);
			g2d.drawRect(220,640,120,145);
		}
		///
		//Card 2 Highlights
		else if(checkCards[1] == true){
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.red);
			g2d.drawRect(360,640,120,145);
		}
		///
		//Card 3 Highlights
		else if(checkCards[2] == true) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.red);
			g2d.drawRect(500,640,120,145);
		}
		///
		//Card 4 Highlights
		else if (checkCards[3] == true) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.red);
			g2d.drawRect(640,640,120,145);
		}
		///
		//Card 5 Highlights
		else if(checkCards[4] == true) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.red);
			g2d.drawRect(780,640,120,145);
		}
		///
		//Card 6 Highlights
		else if(checkCards[5] == true) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.red);
			g2d.drawRect(920,640,120,145);
		}
		///
	}
	
	public static void updateCardHighLights(int value) {
		for(int i = 0; i < checkCards.length; i++) {
			checkCards[i] = false;
		}
		
		checkCards[value] = true;
	}
	
	public static void getCheckCards() {
		
	}
	
	public static void printCheckCards() {
		int i = 0;
		while(i<6) {
			System.out.println(checkCards[i] + " ");
			i++;
		}
	}
}

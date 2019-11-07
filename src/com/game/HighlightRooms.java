package com.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HighlightRooms {
	public static void paintHighlights(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		

		if(PaintPanel.getClick(PaintPanel.getCountClick()) == true ) {
			//This checks where the player is at to show the nearby rooms the player can go to
			//by the green rectangles
			
			if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 0) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(470,125,278,178);//Room 3
				g2d.drawRect(745,305,160,110);//Room 1
				g2d.drawRect(310,305,160,110);//Room 5
				g2d.drawRect(530,380,160,40);//Room 20
				
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 1) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(470,305,270,80);//Room 0
				g2d.drawRect(745,270,450,30);//Room 29
				g2d.drawRect(745,415,160,185);//Room 18
				g2d.drawRect(900,300,60,190);//Room 30
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 2){
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,270,450,30);//Room 29
				g2d.drawRect(470,125,278,178);//Room 3
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 3) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,120,160,150);//Room 2
				g2d.drawRect(310,120,160,150);//Room 4
				g2d.drawRect(745,270,450,30);//Room 29
				g2d.drawRect(20,270,450,30);//Room 23
				g2d.drawRect(470,305,270,80);//Room 0
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 4) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(20,270,450,30);//Room 23
				g2d.drawRect(470,125,278,178);//Room 3
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 5) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(255,300,60,190);//Room 21
				g2d.drawRect(20,270,450,30);//Room 23
				g2d.drawRect(470,305,270,80);//Room 0
				g2d.drawRect(310,415,160,185);//Room 6
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 6) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(310,305,160,110);//Room 5
				g2d.drawRect(20,490,290,110);//Room 7
				g2d.drawRect(470,415,278,185);//Room 19
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 7) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(20,410,235,80);//Room 22
				g2d.drawRect(255,300,60,190);//Room 21
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 8) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(20,270,450,30);//Room 23
				g2d.drawRect(20,410,235,80);//Room 22
				g2d.drawRect(255,300,60,190);//Room 21
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 9) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(20,20,230,140);//Room 10
				g2d.drawRect(20,160,60,105);//Room 24
				g2d.drawRect(250,20,60,140);//Room 25
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 10) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(250,20,60,140);//Room 25
				g2d.drawRect(80,160,230,105);//Room 9
				g2d.drawRect(20,160,60,105);//Room 24
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 11) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(470,20,278,65);//Room 12
				g2d.drawRect(470,90,278,30);//Room 26
				g2d.drawRect(250,20,60,140);//Room 25
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 12) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,20,160,100);//Room 13
				g2d.drawRect(310,20,160,100);//Room 11
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick())== 13) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(900,20,60,140);//Room 27
				g2d.drawRect(470,90,278,30);//Room 26
				g2d.drawRect(470,20,278,65);//Room 12
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 14) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(900,20,60,140);//Room 27
				g2d.drawRect(1140,160,60,105);//Room 28
				g2d.drawRect(910,160,230,105);//Room 15
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 15) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(1140,160,60,105);//Room 28
				g2d.drawRect(960,20,240,140);//Room 14
				g2d.drawRect(900,20,60,140);//Room 27
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 16) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,270,450,30);//Room 29
				g2d.drawRect(900,300,60,190);//Room 30
				g2d.drawRect(960,410,235,80);//Room 31
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 17) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,415,160,185);//Room 18
				g2d.drawRect(900,300,60,190);//Room 30
				g2d.drawRect(960,410,235,80);//Room 31
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 18) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,305,160,110);//Room 1
				g2d.drawRect(470,415,278,185);//Room 19
				g2d.drawRect(900,490,290,110);//Room 17
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 19) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(530,380,160,40);//Room 20
				g2d.drawRect(745,415,160,185);//Room 18
				g2d.drawRect(310,415,160,185);//Room 6
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 20) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(470,305,270,80);//Room 0
				g2d.drawRect(470,415,278,185);//Room 19
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 21) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(310,305,160,110);//Room 5
				g2d.drawRect(20,300,235,110);//Room 8
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 22) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(20,300,235,110);//Room 8
				g2d.drawRect(20,490,290,110);//Room 7
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 23) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(310,120,160,150);//Room 4
				g2d.drawRect(310,305,160,110);//Room 5
				g2d.drawRect(255,300,60,190);//Room 21
				g2d.draw3DRect(20,300,235,110,false);//Room 8
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 24) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(20,20,230,140);//Room 10
				g2d.drawRect(80,160,230,105);//Room 9
				g2d.drawRect(20,270,450,30);//Room 23
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 25) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(310,20,160,100);//Room 11
				g2d.drawRect(80,160,230,105);//Room 9
				g2d.drawRect(20,20,230,140);//Room 10
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 26) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(470,125,278,178);//Room 3
				g2d.drawRect(310,20,160,100);//Room 11
				g2d.drawRect(745,20,160,100);//Room 13
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 27) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(910,160,230,105);//Room 15
				g2d.drawRect(960,20,240,140);//Room 14
				g2d.drawRect(745,20,160,100);//Room 13
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 28) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(745,270,450,30);//Room 29
				g2d.drawRect(910,160,230,105);//Room 15
				g2d.drawRect(960,20,240,140);//Room 14
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 29) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(900,300,60,190);//Room 30
				g2d.drawRect(745,120,160,150);//Room 2
				g2d.drawRect(745,305,160,110);//Room 1
				g2d.drawRect(960,300,235,110);//Room 16
				g2d.drawRect(1140,160,60,105);//Room 28
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 30) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(900,490,290,110);//Room 17
				g2d.drawRect(960,300,235,110);//Room 16
				g2d.drawRect(745,305,160,110);//Room 1
			}else if(PaintPanel.getPRoom(PaintPanel.getCountClick()) == 31) {
				g2d.setStroke(new BasicStroke(4));
				g2d.setColor(Color.green);
				g2d.drawRect(900,490,290,110);//Room 17
				g2d.drawRect(960,300,235,110);//Room 16
			}
		}
	}
}

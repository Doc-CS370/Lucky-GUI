package com.game;

public class GetPawnLocation {
	protected static int roomNum = 0;
	
	public static void getXYCoordinates(int x, int y) {
		if(x>485 && x<720 && y>330 && y<360) {
			roomNum = 0;
		}
		else if(x>775 && x<870 && y>330 && y<390) {
			roomNum = 1;
		}
		else if(x>775 && x<865 && y>150 && y<240) {
			roomNum = 2;
		}
		else if(x>505 && x<705 && y>165 && y<285) {
			roomNum = 3;
		}
		else if(x>335 && x<440 && y>145 && y<235) {
			roomNum = 4;
		}
		else if(x>340 && x<445 && y>330 && y<390) {
			roomNum = 5;
		}
		else if(x>340 && x<435 && y>440 && y<535) {
			roomNum = 6;
		}
		else if(x>5 && x<280 && y>520 && y<570) {
			roomNum = 7;
		}
		else if(x>68 && x<215 && y>330 && y<380) {
			roomNum = 8;
		}
		else if(x>110 && x<270 && y>185 && y<225) {
			roomNum = 9;
		}
		else if(x>65 && x<205 && y>55 && y<130) {
			roomNum = 10;
		}
		else if(x>345 && x<435 && y>45 && y<90) {
			roomNum = 11;
		}
		else if(x>500 && x<715 && y==50) {
			roomNum = 12;
		}
		else if(x>785 && x<870 && y>45 && y<95) {
			roomNum = 13;
		}
		else if(x>995 && x<1160 && y>45 && y<135) {
			roomNum = 14;
		}
		else if(x>800 && x<945 && y>180 && y<235) {
			roomNum = 15;
		}
		else if(x>995 && x<1000 && y>325 && y<390) {
			roomNum = 16;
		}
		else if(x>930 && x<1175 && y>510 && y<580) {
			roomNum = 17;
		}
		else if(x>770 && x<880 && y>440 && y<570) {
			roomNum = 18;
		}
		
		else if(x>520 && x<690 && y>455 && y<585) {
			roomNum = 19;
		}
		else if(x>555 && x<660 && y==395) {
			roomNum = 20;
		}
		else if(x>270 && x<285 && y>315 && y<465) {
			roomNum = 21;
		}
		else if(x>40 && x<230 && y>435 && y<510) {
			roomNum = 22;
		}
		
		else if(x>40 && x<450 && y==280) {
			roomNum = 23;
		}
		else if(x>30 && x<55 && y>165 && y<240) {
			roomNum = 24;
		}
		else if(x>267 && x<285 && y>35 && y<135) {
			roomNum = 25;
		}
		else if(x>485 && x<725 && y==102) {
			roomNum = 26;
		}
		else if(x>920 && x<940 && y>35 && y<125) {
			roomNum = 27;
		}
		else if(x>1155 && x<1178 && y>170 && y<245) {
			roomNum = 28;
		}
		else if(x>800 && x<1175 && y==280) {
			roomNum = 29;
		}
		else if(x>915 && x<935 && x>320 && x<470) {
			roomNum = 30;
		}
		else if(x>845 && x<990 && x>430 && x<470) {
			roomNum = 31;
		}
		
		
	}
	
	public static int getRoom() {
		return roomNum;
	}
	
	
}

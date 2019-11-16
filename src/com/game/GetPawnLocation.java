package com.game;



public class GetPawnLocation {
	protected static int roomNum = 0;
	
	public static void getXYCoordinates(int x, int y) {
		if(x>475 && x<740 && y>325 && y<375) {
			roomNum = 0;
		}
		else if(x>745 && x<870 && y>330 && y<390) {
			roomNum = 1;
		}
		else if(x>755 && x<870 && y>130 && y<260) {
			roomNum = 2;
		}
		else if(x>480 && x<738 && y>135 && y<290) {
			roomNum = 3;
		}
		else if(x>320 && x<460 && y>130 && y<260) {
			roomNum = 4;
		}
		else if(x>320 && x<460 && y>315 && y<405) {
			roomNum = 5;
		}
		else if(x>320 && x<425 && y>440 && y<590) {
			roomNum = 6;
		}
		else if(x>30 && x<300 && y>500 && y<590) {
			roomNum = 7;
		}
		else if(x>30 && x<245 && y>310 && y<400) {
			roomNum = 8;
		}
		else if(x>90 && x<300 && y>170 && y<255) {
			roomNum = 9;
		}
		else if(x>30 && x<240 && y>30 && y<130) {
			roomNum = 10;
		}
		else if(x>320 && x<460 && y>30 && y<90) {
			roomNum = 11;
		}
		else if(x>480 && x<738 && y>30 && y<85) {
			roomNum = 12;
		}
		else if(x>755 && x<895 && y>30 && y<110) {
			roomNum = 13;
		}
		else if(x>970 && x<1190 && y>30 && y<150) {
			roomNum = 14;
		}
		else if(x>920 && x<1140 && y>170 && y<255) {
			roomNum = 15;
		}
		else if(x>970 && x<1185 && y>310 && y<400) {
			roomNum = 16;
		}
		else if(x>910 && x<1180 && y>500 && y<590) {
			roomNum = 17;
		}
		else if(x>755 && x<895 && y>425 && y<590) {
			roomNum = 18;
		}
		
		else if(x>480 && x<738 && y>425 && y<590) {
			roomNum = 19;
		}
		//Foyer
		else if(x>540 && x<680 && y<390 && y>430) {
			roomNum = 20;
		}
		//Wine Cellar
		else if(x>265 && x<305 && y>310 && y<480) {
			roomNum = 21;
		}
		//South West Hall(Next to Wine Cellar)
		else if(x>30 && x<245 && y>420 && y<480) {
			roomNum = 22;
		}
		//Mid West Hall(Left of Dining Hall)
		else if(x>30 && x<460 &&  y>250 && y<310) {
			roomNum = 23;
		}
		//West South Staircase(Near Lancaster Room)
		else if(x>20 && x<80 && y>170 && y<255) {
			roomNum = 24;
		}
		//NorthWest Hall(Above Lancaster Room)
		else if(x>250 && x<310 && y>30 && y<150) {
			roomNum = 25;
		}
		//Gallery
		else if(x>480 && x<738 && y>90 && y<130) {
			roomNum = 26;
		}
		//NorthEast Hall(Above Lilac Room)
		else if(x>900 && x<960 && y>30 && y<150) {
			roomNum = 27;
		}
		//Northeast Staircase(Right of Lilac Room)
		else if(x>1140 && x<1200 && y>170 && y<255) {
			roomNum = 28;
		}
		//Mid east hall
		else if(x>755 && x<1185 && y>250 && y <310) {
			roomNum = 29;
		}
		//South east Hall
		else if(x>900 && x<960 && x>310 && x<480) {
			roomNum = 30;
		}
		//White Room
		else if(x>970 && x<1185 && x>410 && x<490) {
			roomNum = 31;
		}
		
		
	}
	
	public static int getRoom() {
		return roomNum;
	}
	
	public static boolean checkIfPlayerIsInMapBounds(int x, int y) {
		if(x<=10 && x >=1890 && y<=10 &&y>= 595) {
			MapGame.getChatRoom().append("You clicked out of the map bounds!" + "\n" + "Try again!");
			return true;
		}else {
			return false;
		}
	}
	
	
}

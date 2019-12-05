package com.game;




public class SetPawnLocation {
	protected static int xp = 0;
	protected static int yp = 0;
	
	public static void getXPawnLocation(int s) {
		int xmax = 0;
		int xmin = 0;
		int xrange = 0;

		int x1 = 0;
		
		int ymax = 0;
		int ymin = 0;
		int yrange = 0;

		int y1 = 0;
	

		switch(s) {
		case 0:
				xmax = 720;
				xmin = 485;	
				xrange = xmax - xmin + 1;
				x1 = (int)(Math.random() * xrange) + xmin;
				xp = x1;
				
				ymax = 360;
				ymin = 330;
				yrange = ymax - ymin + 1;
				y1 = (int)(Math.random() * yrange) + ymin;
				yp = y1;
				break;
		case 1:
				xmax = 870;
				xmin = 765;
				xrange = xmax - xmin + 1;
				x1 = (int)(Math.random() * xrange) + xmin;
				xp = x1;
				
				ymax = 390;
				ymin = 330;
				yrange = ymax - ymin + 1;
				y1 = (int)(Math.random() * yrange) + ymin;
				yp = y1;

				
				break;
		case 2:
				xmax = 865;
				xmin = 775;
				xrange = xmax - xmin + 1;
				x1 = (int)(Math.random() * xrange) + xmin;
				xp = x1;
				
				ymax = 240;
				ymin = 150;
				yrange = ymax - ymin + 1;
				y1 = (int)(Math.random() * yrange) + ymin;
				yp = y1;
				break;
		case 3:
			xmax = 735;
			xmin = 490;
			xrange = xmax - xmin +1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 285;
			ymin = 135;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 4:
			xmax = 440;
			xmin = 335;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 255;
			ymin = 145;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
			
		case 5:
			xmax = 445;
			xmin = 340;
			xrange = xmax - xmin +1;
			x1 = (int)(Math.random()* xrange) +xmin;
			xp = x1;
			
			ymax = 390;
			ymin = 325;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 6:
			xmax = 415;
			xmin = 340;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 570;
			ymin = 440;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 7: 
			xmax = 240;
			xmin = 30;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 570;
			ymin = 520;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 8:
			xmax = 225;
			xmin = 30;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 390;
			ymin = 320;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 9:
			xmax = 270;
			xmin = 110;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 235;
			ymin = 185;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 10:
			xmax = 230;
			xmin = 40;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 120;
			ymin = 40;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 11:
			xmax = 455;
			xmin = 345;
			xrange = xmax - xmin +1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 80;
			ymin = 45;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 12:
			xmax = 725;//x>485 && x<725
			xmin = 500;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			yp = 50;
			break;
		case 13:
			xmax = 870;
			xmin = 785;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 95;
			ymin = 45;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 14:
			xmax = 1160;
			xmin = 995;
			xrange = xmax- xmin + 1;
			x1 = (int)(Math.random() * xrange) +xmin;
			xp = x1;
			
			ymax = 135;
			ymin = 45;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 15:
			xmax = 1120;
			xmin = 920;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp =x1;
			
			ymax = 245;
			ymin = 180;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 16:
			xmax = 1185;
			xmin = 980;
			xrange = xmax -xmin+1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 390;
			ymin = 325;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 17:
			xmax = 1175;
			xmin = 930;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 580;
			ymin = 510;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 18:
			xmax = 880;
			xmin = 770;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 570;
			ymin = 440;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 19:
			xmax = 710;
			xmin = 500;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 585;
			ymin = 455;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 20:
			xmax = 660;
			xmin = 555;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			yp = 395;
			break;
		case 21:
			
			xmax = 290;
			xmin = 270;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 470;
			ymin = 320;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 22:
			xmax = 230;
			xmin = 40;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 470;
			ymin = 430;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 23:
			xmax = 450;
			xmin = 40;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			yp = 280;
			break;
		case 24:
			xmax = 70;
			xmin = 30;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 240;
			ymin = 165;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 25:
			xmax = 300;
			xmin = 267;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 135;
			ymin = 40;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 26:
			xmax = 725;
			xmin = 490;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			yp = 102;
			break;
		case 27:
			xmax = 940;
			xmin = 920;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 135;
			ymin = 40;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		
		case 28:
			xmax = 1185;
			xmin = 1155;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 245;
			ymin = 180;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
			
		case 29:
			xmax = 1175;
			xmin = 765;
			xrange = xmax - xmin +1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 290;
			ymin = 260;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 30:
			xmax = 935;
			xmin = 915;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 470;
			ymin = 320;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		case 31:
			xmax = 1175;
			xmin = 980;
			xrange = xmax - xmin + 1;
			x1 = (int)(Math.random() * xrange) + xmin;
			xp = x1;
			
			ymax = 470;
			ymin = 430;
			yrange = ymax - ymin + 1;
			y1 = (int)(Math.random() * yrange) + ymin;
			yp = y1;
			break;
		}		
	}

	public static int getXP() {
		return xp;
		
	}
	
	public static int getYP() {
		return yp;
	
	}
	
	public void printXY() {
		System.out.println("X: " + xp + "Y: "+ yp);
	}
	

}

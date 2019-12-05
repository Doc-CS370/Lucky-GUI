package com.game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	/**
	 * 
	 */
	private static String fileLocat = "images\\";

	private static final long serialVersionUID = 1L;
	private static String p1value[] = {"0","0","0","0","0","0","0","0","0","0"};
	private static String p1[] = { fileLocat + "cards//" + p1value[0] + ".png",
			fileLocat + "cards//" + p1value[1] + ".png", fileLocat + "cards//" + p1value[2] + ".png",
			fileLocat + "cards//" + p1value[3] + ".png", fileLocat + "cards//" + p1value[4] + ".png",
			fileLocat + "cards//" + p1value[5] + ".png" };
	private static Image playerIcons[] = { new ImageIcon(fileLocat + "Dr.Lucky Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player1 Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player2 Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player3 Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player4 Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player5 Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player 6 Chip.png").getImage(),
			new ImageIcon(fileLocat + "Player 7 Chip.png").getImage(), };
	// x and y coordinates for each player
	private static int ArrayCT[][] = { { 1075, 530 }, { 1000, 30 }, { 1150, 30}, { 1000, 200 }, { 1150, 200 },
			{ 1000, 370 }, { 1150, 370,0,0 }, { 1330, 200 } };
	private static int previousXY[] = {0,0};
	final private int pawnWidth = 35;
	final private int pawnHeight = 35;

	private Image backImg = new ImageIcon(fileLocat + "Map_with_special_rooms.png").getImage();
	// cardImg
	private static Image cardImg[] = { new ImageIcon(p1[0]).getImage(), new ImageIcon(p1[1]).getImage(),
			new ImageIcon(p1[2]).getImage(), new ImageIcon(p1[3]).getImage(), new ImageIcon(p1[4]).getImage(),
			new ImageIcon(p1[5]).getImage() };
	//
	protected static int playerNum = 0;
	private static SetPawnLocation pxy = new SetPawnLocation();
	// Player Rooms
	private static int pRoom[] = { 0, 0, 0, 0, 0, 0, 0 };
	// Doctor Lucky Rooms
	private static int dRoom = (int) (Math.random() * 20);
	private static boolean clicks[] = { false, false, false, false, false, false, false };
	private static int countClick = 0;
	static boolean goHighlights = false;
	static int found = 0;
	static boolean Again = false;
	static GlobalValues paint = GlobalValues.GlobalValues();

	PaintPanel() {
		
		setDoctorLoad();
		setPlayerLoad();
		MapGame.getChatRoom().append("Welcome to Doctor Lucky!" + MapGame.getNextLine());
		MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
		MapGame.getChatRoom().append("Player 1, you are in " + paint.Room[pRoom[0]].getRoomFlavor() + MapGame.getNextLine());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// Map drawn
		g2d.drawImage(backImg, 10, 10, 1200, 600, this);

		// Image drawn
		g2d.drawImage(cardImg[0], 220, 640, 120, 145, this);

		g2d.drawImage(cardImg[1], 360, 640, 120, 145, this);

		g2d.drawImage(cardImg[2], 500, 640, 120, 145, this);

		g2d.drawImage(cardImg[3], 640, 640, 120, 145, this);

		g2d.drawImage(cardImg[4], 780, 640, 120, 145, this);

		g2d.drawImage(cardImg[5], 920, 640, 120, 145, this);

		// Spite Token
		g2d.setColor(Color.black);
		g2d.fillOval(35, 700, 80, 80);
		g2d.setFont(new Font("ComicSans", Font.PLAIN, 15));
		g2d.drawString("Spite Tokens", 33, 680);

		// Doctor Lucky
		g2d.drawImage(playerIcons[0], ArrayCT[0][0], ArrayCT[0][1], pawnWidth, pawnHeight, this);

		// Player 1,2,3 Drawn
		if (playerNum >= 3) {

			// Player 1 Token
			g2d.drawImage(playerIcons[1], ArrayCT[1][0], ArrayCT[1][1], pawnWidth, pawnHeight, this);
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[0] == true) {
						
						previousXY[0]= ArrayCT[1][0];
						previousXY[1]= ArrayCT[1][1];
						
						ArrayCT[1][0] = e.getX() - 12;
						ArrayCT[1][1] = e.getY() - 8;
						
						GetPawnLocation.getXYCoordinates(ArrayCT[1][0], ArrayCT[1][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[1][0], ArrayCT[1][1])) {
							found = 0;
						}
						
						System.out.println("AdjacentRooms: " + Arrays.toString(paint.Room[pRoom[0]].getAdjacentRooms()) + GetPawnLocation.getRoom());
						for(int i=0;i<paint.Room[pRoom[0]].getAdjacentRooms().length;i++) {
							int[] adj = paint.Room[pRoom[0]].getAdjacentRooms();
							if(adj[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
							
						}						

						if(found==0) {
							ArrayCT[1][0] = previousXY[0];
							ArrayCT[1][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());
							repaint();
							clicks[0]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[0] = false;
							System.out.println("Found Count: " + found);
							setPRoom(0,GetPawnLocation.getRoom());
							System.out.println("Player Room: " + pRoom[0]);
							eventHandler.move(paint.Player, paint.Room, pRoom[0], 1);
							MapGame.getChatRoom().append("Player 1, you are in " + paint.Room[paint.Player[1].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[1].endTurn();
							if(paint.Player[1].getTurnsLeft()>0) {
								clicks[0] = true;
								
							}
						}
						
					}
				}
				
			});
			// Player 2 Token
			g2d.drawImage(playerIcons[2], ArrayCT[2][0], ArrayCT[2][1], pawnWidth, pawnHeight, this);

			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[1] == true) {
						previousXY[0]= ArrayCT[2][0];
						previousXY[1]= ArrayCT[2][1];
						
						ArrayCT[2][0] = e.getX() - 12;
						ArrayCT[2][1] = e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[2][0], ArrayCT[2][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[2][0], ArrayCT[2][1])) {
							found = 0;
						}
						for(int i=0;i<paint.Room[pRoom[1]].adjacentRooms.length;i++) {
							if(paint.Room[pRoom[1]].adjacentRooms[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
						}	
						if(found==0) {
							ArrayCT[2][0] = previousXY[0];
							ArrayCT[2][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());	
							clicks[1]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[1] = false;
							System.out.println("Found Count: " + found);
							setPRoom(1,GetPawnLocation.getRoom());
							eventHandler.move(paint.Player, paint.Room, pRoom[1], 2);
							MapGame.getChatRoom().append("Player 2, you are in " + paint.Room[paint.Player[2].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[2].endTurn();
							if(paint.Player[2].getTurnsLeft() >0) {
								
								clicks[1] = true;
								
							}
						}
					}

				}

			});
			// Player 3 Token
			g2d.drawImage(playerIcons[3], ArrayCT[3][0], ArrayCT[3][1], pawnWidth, pawnHeight, this);

			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[2] == true) {
						previousXY[0]= ArrayCT[3][0];
						previousXY[1]= ArrayCT[3][1];
						
						ArrayCT[3][0] = e.getX() - 12;
						ArrayCT[3][1] = e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[3][0], ArrayCT[3][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[3][0], ArrayCT[3][1])) {
							found = 0;
						}
						for(int i=0;i<paint.Room[pRoom[2]].adjacentRooms.length;i++) {
							if(paint.Room[pRoom[2]].adjacentRooms[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
						}	
						if(found==0) {
							ArrayCT[3][0] = previousXY[0];
							ArrayCT[3][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());	
							clicks[2]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[2] = false;
							System.out.println("Found Count: " + found);
							setPRoom(2,GetPawnLocation.getRoom());
							eventHandler.move(paint.Player, paint.Room, pRoom[2], 3);
							MapGame.getChatRoom().append("Player 3, you are in " + paint.Room[paint.Player[3].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[3].endTurn();
							if(paint.Player[3].getTurnsLeft() >0) {
								
								clicks[2] = true;
								
							}
						}
						
					}

				}

			});

		}

		// Player 4 Drawn
		if (playerNum >= 4) {
			// Player 4 Token
			g2d.drawImage(playerIcons[4], ArrayCT[4][0], ArrayCT[4][1], pawnWidth, pawnHeight, this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[3] == true) {
						previousXY[0]= ArrayCT[4][0];
						previousXY[1]= ArrayCT[4][1];
						
						ArrayCT[4][0] = e.getX() - 12;
						ArrayCT[4][1] = e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[4][0], ArrayCT[4][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[4][0], ArrayCT[4][1])) {
							found = 0;
						}
						for(int i=0;i<paint.Room[pRoom[3]].adjacentRooms.length;i++) {
							if(paint.Room[pRoom[3]].adjacentRooms[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
						}	
						if(found==0) {
							ArrayCT[4][0] = previousXY[0];
							ArrayCT[4][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());	
							clicks[3]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[3] = false;
							System.out.println("Found Count: " + found);
							setPRoom(3,GetPawnLocation.getRoom());
							eventHandler.move(paint.Player, paint.Room, pRoom[3], 4);
							MapGame.getChatRoom().append("Player 4, you are in " + paint.Room[paint.Player[4].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[4].endTurn();
							if(paint.Player[4].getTurnsLeft() >0) {
								
								clicks[3] = true;
								
							}
						}
						

					}

				}

			});

		}
		// Player 5
		if (playerNum >= 5) {
			// Player 5 Token
			g2d.drawImage(playerIcons[5], ArrayCT[5][0], ArrayCT[5][1], pawnWidth, pawnHeight, this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[4] == true) {
						previousXY[0]= ArrayCT[5][0];
						previousXY[1]= ArrayCT[5][1];
						
						ArrayCT[5][0] = e.getX() - 12;
						ArrayCT[5][1] = e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[5][0], ArrayCT[5][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[5][0], ArrayCT[5][1])) {
							found = 0;
						}
						for(int i=0;i<paint.Room[pRoom[4]].adjacentRooms.length;i++) {
							if(paint.Room[pRoom[4]].adjacentRooms[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
						}	
						if(found==0) {
							ArrayCT[5][0] = previousXY[0];
							ArrayCT[5][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());	
							clicks[4]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[4] = false;
							System.out.println("Found Count: " + found);
							setPRoom(0,GetPawnLocation.getRoom());
							eventHandler.move(paint.Player, paint.Room, pRoom[4], 5);
							MapGame.getChatRoom().append("Player 5, you are in " + paint.Room[paint.Player[5].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[5].endTurn();
							if(paint.Player[5].getTurnsLeft() >0) {
								
								clicks[4] = true;
								
							}
						}
						

					}

				}

			});

		}
		// Player 6
		if (playerNum >= 6) {
			// Player 6 Token
			g2d.drawImage(playerIcons[6], ArrayCT[6][0], ArrayCT[6][1], pawnWidth, pawnHeight, this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[5] == true) {
						previousXY[0]= ArrayCT[6][0];
						previousXY[1]= ArrayCT[6][1];
						
						ArrayCT[6][0] = e.getX() - 12;
						ArrayCT[6][1] = e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[6][0], ArrayCT[6][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[6][0], ArrayCT[6][1])) {
							found = 0;
						}
						for(int i=0;i<paint.Room[pRoom[5]].adjacentRooms.length;i++) {
							if(paint.Room[pRoom[5]].adjacentRooms[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
						}	
						if(found==0) {
							
							ArrayCT[6][0] = previousXY[0];
							ArrayCT[6][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());	
							clicks[5]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[5] = false;
							System.out.println("Found Count: " + found);
							setPRoom(5,GetPawnLocation.getRoom());
							eventHandler.move(paint.Player, paint.Room, pRoom[5], 6);
							MapGame.getChatRoom().append("Player 6, you are in " + paint.Room[paint.Player[6].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[6].endTurn();
							if(paint.Player[6].getTurnsLeft() >0) {
								
								clicks[5] = true;		
							}
						}
					
					}

				}

			});

		}
		// Player 7
		if (playerNum >= 7) {
			// Player 7 Token
			g2d.drawImage(playerIcons[7], ArrayCT[7][0], ArrayCT[7][1], pawnWidth, pawnHeight, this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (clicks[6] == true) {
						previousXY[0]= ArrayCT[7][0];
						previousXY[1]= ArrayCT[7][1];
						
						ArrayCT[7][0] = e.getX() - 12;
						ArrayCT[7][1] = e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[7][0], ArrayCT[7][1]);
						if(GetPawnLocation.checkIfPlayerIsInMapBounds(ArrayCT[7][0], ArrayCT[7][1])) {
							found = 0;
						}
						for(int i=0;i<paint.Room[pRoom[6]].adjacentRooms.length;i++) {
							if(paint.Room[pRoom[6]].adjacentRooms[i] == GetPawnLocation.getRoom()) {
								found++;				
							}
						}	
						if(found==0) {
							ArrayCT[7][0] = previousXY[0];
							ArrayCT[7][1] = previousXY[1];
							System.out.println("Found Count: " + found);
							MapGame.getChatRoom().append("Try Again!" + MapGame.getNextLine());	
							clicks[6]=false;
							MapGame.getMoveJButton().setEnabled(true);
							
						}else {
							clicks[6] = false;
							System.out.println("Found Count: " + found);
							setPRoom(6,GetPawnLocation.getRoom());
							eventHandler.move(paint.Player, paint.Room, pRoom[6], 7);
							MapGame.getChatRoom().append("Player 7, you are in " + paint.Room[paint.Player[7].getLocation()].getRoomFlavor() + MapGame.getNextLine());
							repaint();
							MapGame.getMoveJButton().setEnabled(false);
							found = 0;
							paint.Player[7].endTurn();
							if(paint.Player[7].getTurnsLeft() >0) {
								clicks[6] = true;		
							}
							
						}
						
						
						
					}

				}

			});

		}

		// When move button is pressed, it sets clicks to true to allow the player
		// to mouseclick to a room. This enables the player to show the green rectangles
		// for the player
		// to click to
		HighlightRooms.paintHighlights(g2d);
		// Highlight Cards
		
		
		HighlightCards.paintHighlights(g2d);
		if(GetCardLocation.isEnabled = true) {
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GetCardLocation.CheckForCardLocation(e.getX(), e.getY(), g2d);
					repaint();
					
				}
		
			});
		}
			

	}

	public static void setPRoom(int num, int Room) {
		pRoom[num] = Room;
	}

	// Updates a specific
	public static void resetPlayerRoom(int num) {
		SetPawnLocation.getXPawnLocation(pRoom[num]);
		ArrayCT[num + 1][0] = SetPawnLocation.getXP();
		ArrayCT[num + 1][1] = SetPawnLocation.getYP();
	}

	public static void setDRoom(int Room) {
		dRoom = Room;
	}

	// Loads the player location
	public static void setPlayerLoad() {
		for (int i = 1; i < 7; i++) {
			SetPawnLocation.getXPawnLocation(pRoom[i - 1]);
			ArrayCT[i][0] = SetPawnLocation.getXP();
			ArrayCT[i][1] = SetPawnLocation.getYP();

		}
	}

	// Load the Doctor Lucky's location
	public static void setDoctorLoad() {
		SetPawnLocation.getXPawnLocation(dRoom);
		ArrayCT[0][0] = SetPawnLocation.getXP();
		ArrayCT[0][1] = SetPawnLocation.getYP();
	}

	// Sets the cards for the players
	public static void setArray(int num, String file) {
		p1[num] = file;
	}

	// This is send back to MapGame class to keep track of the clicks
	// and to also make sure that it goes all the around
	public static void setBoolArrayStart(boolean cli[]) {
		for (int i = 0; i < cli.length; i++) {
			clicks[i] = cli[i];
		}

	}

	// The string value for Player 1 deck
	public static String getP1Value(int num) {
		return p1value[num];

	}

	public static void setP1Value(int num, String numb) {
		p1value[num] = numb;

	}

	public static void printP1Value() {
		System.out.println(Arrays.toString(p1value));
	}

	public static String getFileLocat() {
		return fileLocat;

	}

	// The string for the image file location
	public static String getImageValue(int num) {
		return p1[num];

	}

	// Sets the card file
	public static void setCardValue(int num, Image lol) {
		cardImg[num] = lol;
	}

	// Returns the click array to MapGame class
	public static boolean[] getBoolArrayBack() {

		return clicks;

	}

	// Sets the next player turn
	public static void setCountClick(int n) {
		countClick = n;
	}

	public static int getPlayerNum() {
		return playerNum;
	}

	public static boolean getClick(int n) {
		return clicks[n];

	}

	public static int getCountClick() {
		return countClick;
	}

	public static int getPRoom(int num) {
		return pRoom[num];
	}

	public static int getDRoom() {

		return dRoom;
	}

	public static void updateCardImg() {
		for(int i = 0;i<6;i++) {
			PaintPanel.setArray(i, PaintPanel.getFileLocat() + "cards//" + PaintPanel.getP1Value(i) + ".png");
			PaintPanel.setCardValue(i, new ImageIcon(PaintPanel.getImageValue(i)).getImage());
		}
		
	}

}